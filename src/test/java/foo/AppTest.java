package foo;


import java.util.ArrayList;

import org.testng.annotations.Test;

import com.algos.string.DiffTest;

/**
 * Unit test for simple App.
 */
public class AppTest 

{
	@Test (description = "Find the max pairs of integers that has diff more than k")
    public void test() {
		ArrayList<Integer> list = new ArrayList<Integer>();
    	int[] ar = {1,2,3,4,23,24,25,54,34,10};
    	for (int i=0; i < ar.length; i++) {
    		list.add(new Integer(ar[i]));
    	}
    	DiffTest.findDiff(list, 22);
	}
}
