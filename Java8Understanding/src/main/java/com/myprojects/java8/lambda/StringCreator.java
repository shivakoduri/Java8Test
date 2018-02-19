package com.myprojects.java8.lambda;

public class StringCreator {

	public static void main(String[] args) {
		
		FuncIf fi = String::new;

        char[] charArray = {'s','p','e','a','k','i','n','g','c','s'};

        System.out.println(fi.strFunc(charArray));

	}

}
