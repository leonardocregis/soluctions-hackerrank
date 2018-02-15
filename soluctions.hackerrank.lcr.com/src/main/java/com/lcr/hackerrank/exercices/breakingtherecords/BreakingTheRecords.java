package com.lcr.hackerrank.exercices.breakingtherecords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BreakingTheRecords {

	static Integer maxScore = null;
	static Integer minScore = null;
	static int increase = 0;
	static int decrease = 0;

	public static void main(String[] args) {
	 	try (Scanner in  = new Scanner(new File("input-breakingtherecords-1"),"utf-8")) {
	 		final int gameSize = in.nextInt();
	 		minScore = in.nextInt();
	 		maxScore = minScore;
	 		increase = 0;
	 		decrease = 0;
	 		List<Integer> gameScores = IntStream.generate(() -> in.nextInt()).
	 											 limit(gameSize-1).
	 											 boxed().collect(Collectors.toList());
	 		gameScores.forEach(e-> System.out.println(e));
	 		gameScores.forEach(score -> {
	 			if (maxScore < score) {
	 				maxScore = score;
	 				increase++;
	 			}
	 			if (minScore > score) { 
	 				minScore = score;
	 				decrease++;
	 			}
	 		});
	 		
	 		System.out.println(increase + " " + decrease);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}

	
}
