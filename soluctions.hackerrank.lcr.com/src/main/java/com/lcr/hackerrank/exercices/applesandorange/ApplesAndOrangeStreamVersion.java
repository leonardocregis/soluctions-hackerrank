package com.lcr.hackerrank.exercices.applesandorange;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;


public class ApplesAndOrangeStreamVersion {

	public static void main(String[] args) {
		
	 	try (Scanner in  = new Scanner(new File("input-applesoranges-4"),"utf-8")) {
	 		int s = in.nextInt();
	 		int t = in.nextInt();
	 		int a = in.nextInt();
	 		int b = in.nextInt();
	 		int m = in.nextInt();
	 		int n = in.nextInt();
	 		long appleHits = IntStream.generate(()->in.nextInt())
	 				.limit(m)
	 				.filter(d -> d+a>=s && d+a<=t)
	 				.count();
	 		long orangeHits = IntStream.generate(()->in.nextInt())
	 				.limit(n)
	 				.filter(d -> d+b>=s && d+b<=t)
	 				.count();
	 		
	 		System.out.println(appleHits);
	 		System.out.println(orangeHits);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
