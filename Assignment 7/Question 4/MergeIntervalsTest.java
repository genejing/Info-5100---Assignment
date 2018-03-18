package Assignment7;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Assignment7.MergeIntervals.Interval;

public class MergeIntervalsTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMerge() {
		MergeIntervals mi = new MergeIntervals();
		Interval i1 = mi.new Interval(1,3);
		Interval i2 = mi.new Interval(2,6);
		Interval i3 = mi.new Interval(8,10);
		Interval i4 = mi.new Interval(15,18);
		ArrayList<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		
		Interval r1 = mi.new Interval(1,6);
		Interval r2 = mi.new Interval(8,10);
		Interval r3 = mi.new Interval(15,18);
		ArrayList<Interval> res = new ArrayList<>();
		res.add(r1);
		res.add(r2);
		res.add(r3);
		assertEquals(mi.merge(list).size(),res.size());
		for (int i=0;i<mi.merge(list).size();i++) {
			assertEquals(mi.merge(list).get(i),res.get(i));
		}
		
	}

}
