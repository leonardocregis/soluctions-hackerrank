package com.lcr.hackerrank.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessor implements IArgumentProcessor{
	
	private File file ;
	private List<List<String>> results;
	
	public FileProcessor(String filename){
		file = new File(filename);
	}
	
	public FileProcessor(File file) {
		this.file = file;
	}
	
	public void mapToArgs() throws IOException {
		results = Files.lines(file.toPath()).map(line -> {
			String[] result = line.split(" ");
			return Arrays.asList(result);
		}).collect(Collectors.toList());
	}

	public List<List<String>> getResults() {
		return Collections.unmodifiableList(results);
	}

	public static void main(String[] args) {
		FileProcessor fileProcessor = new FileProcessor("input-apples");
		try {
			fileProcessor.mapToArgs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
