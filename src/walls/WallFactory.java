package walls;

public class WallFactory {
	public Wall createWall(String wallType) {
		switch (wallType.toLowerCase()) {
		case "stone":
			return new Stone();
		case "tree":
			return new Tree();
		default:
			return new Wall();
		}
	}
}
