package com.lcr.hackerrank.exercices.applesandorange;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.lcr.hackerrank.utils.FileProcessor;
import com.lcr.hackerrank.utils.IArgumentProcessor;

/**
 * Unit test for simple App.
 */
public class ApplesAndOrangeTest {


	House house;
	private int s;//House Start Range
	private int t;//House Range End
	private int a;//Apple Tree
	private int b;//Orange Tree

	private int expectedInRangeOrange;
	private int expectedInRangeApple;
	
	@Test
	public void outRangeFruits(){
		this.s = 7;
		this.t = 11;
		this.a = 5;
		this.b = 15;
		
		int[] apples = {-2, -1, 1};
		int[] oranges = { -3 };
		ApplesAndOrange applesAndOrange = new ApplesAndOrange(s,t,a,b);
		applesAndOrange.processApples(apples);
		applesAndOrange.processOranges(oranges);
		applesAndOrange.summary();
		Assert.assertEquals(3, apples.length - applesAndOrange.getTotalNearHouseAppleTree());
		Assert.assertEquals(1, oranges.length - applesAndOrange.getTotalNearHouseOrangeTree());
	}
	
	@Test
	public void inRangeOrangeFruit(){
		this.s = 7;
		this.t = 11;
		this.a = 5;
		this.b = 15;
		
		int[] apples = {2, 3, 4, 5, 6};
		int[] oranges = { -4, -5, -6 };
		ApplesAndOrange applesAndOrange = new ApplesAndOrange(s,t,a,b);
		applesAndOrange.processApples(apples);
		applesAndOrange.processOranges(oranges);
		applesAndOrange.summary();
		Assert.assertEquals(5, applesAndOrange.getTotalNearHouseAppleTree());
		Assert.assertEquals(3, applesAndOrange.getTotalNearHouseOrangeTree());
	}
	
	
	@Test
	public void orangeTreeInsideRange(){
		this.s = 7;
		this.t = 11;
		this.a = 8;
		this.b = 10;

		int[] apples = {2, 3, 4, 5, 6};
		int[] oranges = { -1, -2, -3 };
		ApplesAndOrange applesAndOrange = new ApplesAndOrange(s,t,a,b);
		applesAndOrange.processApples(apples);
		applesAndOrange.processOranges(oranges);
		applesAndOrange.summary();
		Assert.assertEquals(2, applesAndOrange.getTotalNearHouseAppleTree());
		Assert.assertEquals(3, applesAndOrange.getTotalNearHouseOrangeTree());
	}
	
	@Test
	public void houseAfterTrees() {
		this.s = 11;
		this.t = 20;
		this.a = 8;
		this.b = 10;

		int[] apples = {2, 3, 4, 5, 6};
		int[] oranges = { 3, 5, 7 };
		ApplesAndOrange applesAndOrange = new ApplesAndOrange(s,t,a,b);
		applesAndOrange.processApples(apples);
		applesAndOrange.processOranges(oranges);
		applesAndOrange.summary();
		Assert.assertEquals(4, applesAndOrange.getTotalNearHouseAppleTree());
		Assert.assertEquals(3, applesAndOrange.getTotalNearHouseOrangeTree());		
	}
	
	
	@Test
	public void houseBeforeTrees() {
		this.s = 1;
		this.t = 7;
		this.a = 8;
		this.b = 10;

		int[] apples = {-1, 3, 4, 5, 6};
		int[] oranges = { -5, 5, 7 };
		ApplesAndOrange applesAndOrange = new ApplesAndOrange(s,t,a,b);
		applesAndOrange.processApples(apples);
		applesAndOrange.processOranges(oranges);
		applesAndOrange.summary();
		Assert.assertEquals(1, applesAndOrange.getTotalNearHouseAppleTree());
		Assert.assertEquals(1, applesAndOrange.getTotalNearHouseOrangeTree());		
	}
	
	@Test
	public void processTestCase4() {
		IArgumentProcessor argumentProcessor = new FileProcessor("input-applesoranges-4");
		IArgumentProcessor expectedResult = new FileProcessor("expectedResult-4");
		try {
			argumentProcessor.mapToArgs();
			List<List<String>> args = argumentProcessor.getResults();
			this.s = Integer.valueOf(args.get(0).get(0));
			this.t = Integer.valueOf(args.get(0).get(1));
			this.a = Integer.valueOf(args.get(1).get(0));
			this.b = Integer.valueOf(args.get(1).get(1));
			
			int[] apples = args.get(3).stream().mapToInt(mapper -> Integer.valueOf(mapper)).toArray();
			int[] oranges = args.get(4).stream().mapToInt(mapper -> Integer.valueOf(mapper)).toArray();
			ApplesAndOrange applesAndOrange = new ApplesAndOrange(s,t,a,b);
			applesAndOrange.processApples(apples);
			applesAndOrange.processOranges(oranges);			
			
			
			expectedResult.mapToArgs();
			List<List<String>> assertions = expectedResult.getResults();
			this.expectedInRangeApple = Integer.valueOf(assertions.get(0).get(0));
			this.expectedInRangeOrange = Integer.valueOf(assertions.get(1).get(0));
			
			Assert.assertEquals(expectedInRangeApple, applesAndOrange.getTotalNearHouseAppleTree());
			Assert.assertEquals(expectedInRangeOrange, applesAndOrange.getTotalNearHouseOrangeTree());
			
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Unable to retrieve arguments");
		}
	}

	@Test
	public void processTestCase10() {
		IArgumentProcessor argumentProcessor = new FileProcessor("input-applesoranges-10");
		IArgumentProcessor expectedResult = new FileProcessor("expectedResult-10");
		try {
			argumentProcessor.mapToArgs();
			List<List<String>> args = argumentProcessor.getResults();
			this.s = Integer.valueOf(args.get(0).get(0));
			this.t = Integer.valueOf(args.get(0).get(1));
			this.a = Integer.valueOf(args.get(1).get(0));
			this.b = Integer.valueOf(args.get(1).get(1));
			
			int[] apples = args.get(3).stream().mapToInt(mapper -> Integer.valueOf(mapper)).toArray();
			int[] oranges = args.get(4).stream().mapToInt(mapper -> Integer.valueOf(mapper)).toArray();
			ApplesAndOrange applesAndOrange = new ApplesAndOrange(s,t,a,b);
			applesAndOrange.processApples(apples);
			applesAndOrange.processOranges(oranges);			
			
			
			expectedResult.mapToArgs();
			List<List<String>> assertions = expectedResult.getResults();
			this.expectedInRangeApple = Integer.valueOf(assertions.get(0).get(0));
			this.expectedInRangeOrange = Integer.valueOf(assertions.get(1).get(0));
			
			Assert.assertEquals(expectedInRangeApple, applesAndOrange.getTotalNearHouseAppleTree());
			Assert.assertEquals(expectedInRangeOrange, applesAndOrange.getTotalNearHouseOrangeTree());
			
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Unable to retrieve arguments");
		}
	}

	
}
