package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

import cz.uhk.fim.pro2.interfaces.*;

public class World {

    private Bird bird;
    private List<Tube> tubes;
    private List<Heart> hearts;
    private WorldListener worldListener;
    private Ground ground;
    private boolean generated = false;
    public static final int SPEED = 100;
    private static final int SPACE_BETW_TUBES = 300;
    private static final int SPACE_BETW_HEARTS = 800;


    public World(Bird bird, WorldListener worldListener) {
        this.bird = bird;
        tubes = new ArrayList<>();
        hearts = new ArrayList<>();
        this.worldListener = worldListener;
    }

    public void update(float deltaTime) {
        if (generated) {
            regenerate();
        }
        bird.update(deltaTime);

        if (bird.isOutOf()) {
            worldListener.outOf();
        }

        for (Heart heart : hearts) {
            heart.update(deltaTime);
            if (bird.collideWith(heart)) {
                worldListener.catchHeart(heart);
            }
        }

        for (Tube tube : tubes) {
            tube.update(deltaTime);
            if (bird.collideWith(tube)) {
                tube.setCounted(true);
                worldListener.crashTube(tube);
            } else {

                if (bird.getPositionX() > tube.getMaxX()
                        ) {
                    if (!tube.isCounted()) {
                        bird.addPoint();
                        tube.setCounted(true);
                    }
                }
            }
        }
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public List<Tube> getTubes() {
        return tubes;
    }

    public void setTubes(List<Tube> tubes) {
        this.tubes = tubes;
    }

    public List<Heart> getHearts() {
        return hearts;
    }

    public void setHearts(List<Heart> hearts) {
        this.hearts = hearts;
    }

    public void addTubes(Tube tube) {
        tubes.add(tube);
    }

    public void addHeart(Heart heart) {
        hearts.add(heart);
    }

    public String toString() {
        return bird.getName() + " " + tubes.size() + " " + hearts.size();

    }
    public void generateRandom() {
        for (int i = 0; i < 3; i++) {
            addTubes(new Tube(SPACE_BETW_TUBES + i * SPACE_BETW_TUBES, Tube.getRandomHeight(), Color.green));
        }

        addHeart(new Heart(SPACE_BETW_HEARTS, Heart.getRandomY()));

        generated = true;
    }
    private void regenerate() {
        for (Tube tube : tubes) {
            if (tube.getPositionX() < -100) {
                tube.setPositionX(tube.getPositionX() + tubes.size() * SPACE_BETW_TUBES);
                tube.setHeight(Tube.getRandomHeight());
                tube.setCounted(false);
            }
        }
        for (Heart heart : hearts) {
            if (heart.getPositionX() < -100) {
                heart.setPositionX(heart.getPositionX() + (hearts.size() + 1) * SPACE_BETW_HEARTS);
                heart.setPositionY(Heart.getRandomY());
            }

        }
    }
}
