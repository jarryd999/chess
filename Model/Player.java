package Model;

import java.util.ArrayList;

public class Player {
	public Color color;
	public ArrayList places = new ArrayList<GameSquare>();
	
	public Player(Color color){
		this.color = color;		
	}
	
	public void addSquare(GameSquare sq){
		places.add(sq);
	}
	
	public void removeSquare(GameSquare sq){
		places.remove(sq);
	}
}
