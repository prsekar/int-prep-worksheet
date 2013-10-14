package com.algos.search;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class WordSearch {
	private String findStr = "hhspuiakvl";
	private List<String> sampleStr = new ArrayList<String>();
	char[] sampler = new char[] {'a', 'b', 'c', 'd','e','f','g','h', 'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	@BeforeTest (description = "Generates List of random strings using commons.RandomUtils API")
	public void beforeTest() {
		for (int i=0;i<1000;i++) {
			sampleStr.add(RandomStringUtils.random(10, sampler));
		}
	}
	@Test (description = "test recursive method using compareTo. Does not rebuild initial array")
	public void test() {
		Collections.sort(sampleStr);
		findStr = sampleStr.get(new Random().nextInt(999));
		System.out.println("Find str "  + findStr + " from lists of strings");
		System.out.println(findStr + " " + sampleStr.indexOf(findStr));
		Assert.assertTrue(recursiveCheck(sampleStr, 0, sampleStr.size() - 1));
	}

	@Test (description = "sample find a string not in the list")
	public void negativetest() {
		Collections.sort(sampleStr);
		findStr = sampleStr.get(new Random().nextInt(999)); findStr += "1";
		System.out.println("Find str "  + findStr + " from lists of strings");
		Assert.assertFalse(recursiveCheck(sampleStr, 0, sampleStr.size() - 1));
	}

	@Test (description = "Test and compare collection.Binarysearch API for finding a string from sorted list. It rebuilds initial array not space optimized")
	public void testBST() {
		Collections.sort(sampleStr);
		findStr = sampleStr.get(new Random().nextInt(999));
		System.out.println(findStr + " " + sampleStr.indexOf(findStr));
		int keyIndex = Collections.binarySearch(sampleStr, findStr);
		System.out.println("Searched index " + keyIndex);
		
	}

	public boolean recursiveCheck(List<String> array, int startPos, int endPos) {
		int cmpInt = findStr.compareTo(array.get((endPos + startPos) / 2));
		if (startPos < endPos) {
			if (cmpInt > 0) {
				return recursiveCheck(array, ((endPos + startPos)/ 2) + 1, endPos);
			} else if(cmpInt < 0) {
				return recursiveCheck(array, startPos, ((endPos + startPos)/ 2) - 1);
			} else {
				return true;
			}			
		} else {
			return false;
		}
	}
}