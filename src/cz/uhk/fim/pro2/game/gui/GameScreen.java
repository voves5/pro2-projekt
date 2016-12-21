package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Timer;

import cz.uhk.fim.pro2.game.model.Ground;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;
import cz.uhk.fim.pro2.interfaces.WorldListener;


public class GameScreen extends Screen implements WorldListener{
    private JLabel jLabelLifes, jLabelScore;
    private long lastTimeMillis;
    private Timer timer;
    private Bird bird;



    public GameScreen(MainFrame mainFrame) throws IOException {
        super(mainFrame);

        JButton jButtonBack = new JButton("BACK");
        JButton jButtonPause = new JButton("PAUSE");

        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                mainFrame.setScreen(new HomeScreen(mainFrame));
            }
        });

        //WORLD
        bird = new Bird("Jakub", 150, 400);
        World world = new World(bird,this);
        world.generateRandom();

        jButtonPause.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning() == true) {
                    timer.stop();
                    FinishScreen finishScreen= new FinishScreen(mainFrame,world);
                    mainFrame.setScreen(finishScreen);
                } else {
                    lastTimeMillis = System.currentTimeMillis();
                    timer.start();
                }
            }
        });

        jButtonBack.setBounds(320, 10, 60, 30);
        jButtonBack.setFont(new Font("Arial", Font.PLAIN, 8));
        jButtonPause.setBounds(400, 10, 60, 30);
        jButtonPause.setFont(new Font("Arial", Font.PLAIN, 8));

        add(jButtonPause);
        add(jButtonBack);

        jLabelScore = new JLabel("Score: " + Bird.DEFAULT_SCORE);
        jLabelLifes = new JLabel("Životy: " + Bird.DEFAULT_LIFES);

        jLabelScore.setBounds(20, 10, 80, 30);
        jLabelLifes.setBounds(100, 10, 80, 30);

        add(jLabelLifes);
        add(jLabelScore);

        GameCanvas gamecanvas = new GameCanvas(world);
        gamecanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);

        gamecanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                bird.goUp();
            }
        });

        add(gamecanvas);

        timer = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                long currentTimeMillis = System.currentTimeMillis();

                float delta = (currentTimeMillis - lastTimeMillis) / 1000f;
                world.update(delta);

                jLabelLifes.setText("Životy: " + bird.getLifes());
                jLabelScore.setText("Score: " + bird.getScore());

                if (!bird.isAlive()) {
                    timer.stop();
                    FinishScreen finishScreen= new FinishScreen(mainFrame, world) ;
                    mainFrame.setScreen(finishScreen);
                }

                gamecanvas.repaint();

                lastTimeMillis = currentTimeMillis;
            }
        });

        lastTimeMillis = System.currentTimeMillis();
        timer.start();
    }

    @Override
    public void crashTube(Tube tube) {
        bird.removeLive();
        bird.setPositionY(tube.getCenterY());

    }

    @Override
    public void catchHeart(Heart heart) {
        heart.setPositionY(-100);
        bird.catchHeart();

    }

    @Override
    public void outOf() {
        bird.setPositionY(MainFrame.HEIGHT / 2);
        bird.setSpeed(Bird.JUMP / 2);
        bird.removeLive();
    }
}