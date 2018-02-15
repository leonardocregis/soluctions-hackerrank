package com.lcr.hackerrank.exercices.applesandorange;

import java.util.LinkedHashMap;
import java.util.Map;


public class ApplesAndOrange {

	public static void main(String[] args) {
		
		ApplesAndOrange applesAndOrange = new ApplesAndOrange(7, 11, 5, 15);
		int oranges[] = {5,-6};
		int apples[] = {-2,2,1};
		applesAndOrange.summary();

		applesAndOrange.processApples(apples);
		applesAndOrange.processOranges(oranges);
		
		for (Tree tree: applesAndOrange.inHouseTrees.keySet()){
			System.out.println(tree.name + " value "+ applesAndOrange.inHouseTrees.get(tree));
		}
		
	}
	
	private House house;
	Tree orangeTree;
	Tree appleTree;
	Map<Tree,Integer> inHouseTrees = new LinkedHashMap<Tree, Integer>(2);
	
	public ApplesAndOrange(int s, int t,int a, int b){
		this.house = new House(s,t);
		this.orangeTree = new Tree("orange",b);
		this.inHouseTrees.put(orangeTree, 0);
		this.appleTree = new Tree("apple",a);
		this.inHouseTrees.put(appleTree, 0);
	}
	
	
	public ApplesAndOrange(House house, Tree appleTree, Tree orangeTree) {

		super();
		this.house = house;
		this.inHouseTrees.put(appleTree, 0);
		this.inHouseTrees.put(orangeTree, 0);
	}

	public void calculate(Tree tree, int fallDist){
		System.out.print(tree.name + " original " + fallDist);
		if ( this.house.checkRange(tree.fallFruit(fallDist))){
			Integer value = this.inHouseTrees.get(tree);
			this.inHouseTrees.put(tree, ++value);
		}
	}
	
	public void summary () {
		System.out.println("Range:        a ------------------------ s ================== t ---------------------------- b");
		System.out.println("OrangeT       " + this.appleTree.location);
		System.out.println("AppleT                                                                                      " + this.orangeTree.location );
		System.out.println("                                         " + this.house.startRange + " ================== " + this.house.endRange);
	}

	static enum FruitKind {
		Apple,Orange;
	}

	public void processApples(int[] apples) {
		for (int apple: apples){
			calculate(appleTree, apple);
		}
		
	}
	
	public void processOranges(int[] oranges){
		for (int orange: oranges){
			calculate(orangeTree, orange);
		}
	}

	public int  getTotalNearHouseAppleTree() {
		return this.inHouseTrees.get(appleTree);
	}

	public int getTotalNearHouseOrangeTree() {
		return this.inHouseTrees.get(orangeTree);
	}	
}
