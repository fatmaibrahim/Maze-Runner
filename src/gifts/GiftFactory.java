package gifts;

public class GiftFactory {
	public Gift create(String giftType){
		switch (giftType.toLowerCase()) {
		case "bullet":
			return new Bullet();
		case "coin":
			return new Coin();
		case "live":
			return new Live();
		case "raft":
			return new Raft();
		default:
			return new Gift();
		}
	}
}
