package walls;

import mazeElements.Runner;
import mazeElements.AllElements;
public class Wall extends AllElements{

	public void hit(Runner r) {
		r.setPosition(r.getPreviousPosition());
	}
}
