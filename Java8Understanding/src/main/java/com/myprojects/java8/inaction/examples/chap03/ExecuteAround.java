package com.myprojects.java8.inaction.examples.chap03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.myprojects.java8.inaction.examples.spec.BufferedReaderProcessor;

public class ExecuteAround {

	public static void main(String[] args) throws IOException {
		// method we want to refactor to make more flexible
		String result = processFileLimited();
		System.out.println(result);

		System.out.println("------------------------");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		System.out.println("------------------------");

		String twoLines = processFile((BufferedReader b) -> b.readLine()
				+ b.readLine());
		System.out.println(twoLines);

	}
	
	public static String processFileLimited() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("data/chap03/data.txt"))) {
			return br.readLine();
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("data/chap03/data.txt"))) {
			return p.process(br);
		}

	}

}
