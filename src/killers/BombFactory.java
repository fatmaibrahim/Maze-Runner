package killers;

public class BombFactory {
	public Bomb create(String bombType){
		if(bombType.toLowerCase() == "small"){
			return new SmallBomb();
		}
		return new BigBomb();
	}
}
