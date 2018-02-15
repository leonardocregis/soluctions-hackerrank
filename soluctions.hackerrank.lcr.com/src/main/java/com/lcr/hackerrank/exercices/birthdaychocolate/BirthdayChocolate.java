package com.lcr.hackerrank.exercices.birthdaychocolate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BirthdayChocolate {

	public static void main(String[] args) {
	 	try (Scanner in  = new Scanner(new File("input-birthdaychocolate-1"),"utf-8")) {
	        int chocolatePieces = in.nextInt();
	        int[] chocolate = new int[chocolatePieces];
	        for(int a_i = 0; a_i < chocolatePieces; a_i++){
	            chocolate[a_i] = in.nextInt();
	        }
	        int n = in.nextInt();
	        int d = in.nextInt();
	        List<Integer> result = new ArrayList<>(chocolatePieces);
	        for ( int i = 0; i < chocolatePieces; i++) {
	        	int j = 0;
	        	IntStream.iterate(j ++, chocolate).
	        	for (j = i + 1; j < n; j++ ) {
	        		
	        	}
	        	n += j;
	        }
	 	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
