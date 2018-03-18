package Assignment7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RockPaperScissorsGameTest {
	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		Rock r = new Rock(15);
		assertEquals(s.fight(p), true);
		assertEquals(p.fight(s), false);
		assertEquals(p.fight(r), false);
		assertEquals(r.fight(p), true);
		assertEquals(r.fight(s), true);
		assertEquals(s.fight(r), false);
	}
	

}
