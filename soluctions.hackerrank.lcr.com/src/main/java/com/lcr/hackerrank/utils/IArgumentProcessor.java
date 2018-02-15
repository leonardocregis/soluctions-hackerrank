package com.lcr.hackerrank.utils;

import java.io.IOException;
import java.util.List;

public interface IArgumentProcessor {

	public List<List<String>> getResults();
	public void mapToArgs() throws IOException;

}