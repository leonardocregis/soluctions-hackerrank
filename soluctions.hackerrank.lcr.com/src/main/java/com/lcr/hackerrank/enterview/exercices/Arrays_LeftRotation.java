package com.lcr.hackerrank.enterview.exercices;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arrays_LeftRotation implements Runnable {
	
	private int numberOfIntegers;
	private int numberOfRotations;
	private List<Integer> listInts = new ArrayList<>();
	private List<Integer> destinyList = new ArrayList<>();
	
	public static void main(String[] args) {

		Arrays_LeftRotation leftRot = new Arrays_LeftRotation();
		Thread t = new Thread(leftRot);
		t.start();
	}

	@Override
	public void run() {
		try (Scanner in  = new Scanner(new File("input-leftrotation"),"utf-8")) {
			numberOfIntegers = in.nextInt();
			numberOfRotations = in.nextInt();
			colectInts(in);
			moveResultingInts();
			printInts();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void printInts() {
		this.destinyList.forEach((value) -> System.out.print(" "+ value));
	}

	private void moveResultingInts() {
		for (int i = 0 ; i < this.listInts.size() ; i ++ ) {
			int positionToGetTheNumber  = (i + this.numberOfRotations) % this.numberOfIntegers;
			this.destinyList.set( i , this.listInts.get(positionToGetTheNumber));
		}
	}

	private void colectInts(Scanner in) {
		for (int i = 0 ; i < numberOfIntegers; i++) {
			this.listInts .add(in.nextInt());
			this.destinyList.add(0);
		}
	}
}
