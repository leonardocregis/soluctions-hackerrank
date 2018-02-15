package com.lcr.hackerrank.exercices.betweentwosets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BetweenTwoSets {

	public static void main(String[] args) {
	 	try (Scanner in  = new Scanner(new File("input-betweentwosets-4"),"utf-8")) {
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i = 0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        int[] b = new int[m];
	        for(int b_i = 0; b_i < m; b_i++){
	            b[b_i] = in.nextInt();
	        }
	        int total = getTotalX(a, b);
	        System.out.println(total);
	 	} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static int getTotalX(int[] a, int[] b) {
		
		IntStream.of(a).forEach(i -> System.out.print(i + ","));
		int[] arr = IntStream.of(a).filter(
				val -> {
					return IntStream.of(a).filter(inner -> {
						int result = val % inner;
						boolean validated = result == 0;
						System.out.println(val+" % "+inner+" == 0 :" + result + "(" + validated + ")");
						return  validated;
					}).count() == a.length;
				}
		).toArray();
		
		IntStream.of(arr).forEach(a2 -> System.out.println(a2));
		
		return 0;
	}
	
}
