package com.lcr.hackerrank.exercices.applesandorange;

class House {
	int startRange;
	int endRange;
	
	public House(int startRange, int endRange) {
		super();
		this.startRange = startRange;
		this.endRange = endRange;
	}


	public boolean checkRange(int fallActualLocation){
		System.out.print(" real Distance "+fallActualLocation);
		boolean inhouse = (startRange <= fallActualLocation) && (fallActualLocation <= endRange);
		System.out.println(" "+inhouse);
		return inhouse;
	}
}