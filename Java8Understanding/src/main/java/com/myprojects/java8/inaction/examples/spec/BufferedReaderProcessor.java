package com.myprojects.java8.inaction.examples.spec;

import java.io.BufferedReader;
import java.io.IOException;

public interface BufferedReaderProcessor {

	public String process(BufferedReader b) throws IOException;
}
