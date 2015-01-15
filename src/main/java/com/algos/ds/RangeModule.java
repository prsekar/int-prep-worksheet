package com.algos.ds;

import java.util.ArrayList;
import java.util.Comparator;



class RangeList extends ArrayList<Range> {

	@Override
	public boolean contains(Object o) {
		RangeCmp cmp = new RangeCmp();
		if (o == null) {
			return false;
		} else {
			for (int i =0; i <size() ; i++) {
				int findVal = cmp.compare(get(i), (Range) o);
				if ( findVal == 0 || findVal == 1) {
					return true;
				}
			}
		}
		return false;
	}
	
}
public class RangeModule {
	private RangeList list = new RangeList();
	public void addRange(int start, int end) {
		this.list.add(new Range(start, end));
	}

	public void queryRange(int start, int end) {
		System.out.println(list.contains(new Range(start,end)));
	}

	public void deleteRange(int start, int end) {

	}
	
	public static void main(String[] args) {
		RangeModule rangeMod = new RangeModule();
		rangeMod.addRange(10,20);
		rangeMod.addRange(40,70);
		rangeMod.addRange(100,200);
		rangeMod.addRange(150,250);
		rangeMod.queryRange(10, 20);
		
		
		System.out.println(new Range(10,20).hashCode() + " == " + new Range(10,20).hashCode()); 
	}
}

class RangeCmp implements Comparator<Range> {

	public int compare(Range o1, Range o2) {
		if (o1.start <= o2.start && o1.end >= o2.end) {
			//within the range
			return 0;
		} else {
			//range vioalation
			return -1;
		}
	}
	
}
class Range {
	private int hash;
	public Range(int x, int y) {
		start = x;
		end = y;
	}
	public int start;
	public int end;
	
	@Override
	public int hashCode() {
		if (hash ==0) {
			hash = hash * 31 + new Integer(start).toString().hashCode();
			hash += hash * 31 + new Integer(end).toString().hashCode();
		}
		return hash;
	}
	@Override
	public boolean equals(Object o) {
		return (this.hashCode() == o.hashCode());
	}
}
