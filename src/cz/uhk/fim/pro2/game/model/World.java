package cz.uhk.fim.pro2.game.model;
	
import java.util.ArrayList;
import java.util.List;
	
public class World {
		
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	public World(Bird bird){
		this.bird = bird;
		tubes = new  ArrayList<>();
		hearts = new ArrayList<>();
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




	public void addTubes(Tube tube){
		tubes.add(tube);
		
	}
	
	public void addHeart(Heart heart){
		hearts.add(heart);
	}
	
	public String toString(){
		return bird.getName() +" "+ tubes.size() + " " + hearts.size();
		
	}
	
	
	
}
