package Assignment7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
	
	public class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s,int e) {
			start = s;
			end = e;
		}
		
		@Override
		public boolean equals(Object i) {
			if (this == i) return true;
			Interval ii = (Interval) i;
			return (start == ii.start && end == ii.end);
		}
	}
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() == 0) return intervals;
		ArrayList<Interval> ans = new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start != i2.start) {
					return i1.start - i2.start;
				}
				return i1.end - i2.end;
			}
		});
		int lo = intervals.get(0).start;
		int hi = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= hi) {
				hi = Math.max(intervals.get(i).end, hi);
			} else {
				ans.add(new Interval(lo,hi));
				lo = intervals.get(i).start;
				hi = intervals.get(i).end;
			}
		}
		ans.add(new Interval(lo,hi));
		return ans;
		
	}
}
