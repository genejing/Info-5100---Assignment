package Assignment7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FindMedianTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMedianSortedArrays() {
		FindMedian fm = new FindMedian();
		int[] a1 = {1,3};
		int[] a2 = {2};
		
		int[] b1 = {1,2};
		int[] b2 = {3,4};
		
		assertEquals(fm.findMedianSortedArrays(a1, a2), 2.0,0.0);
		assertEquals(fm.findMedianSortedArrays(b1, b2), 2.5,0.0);
	}

}
