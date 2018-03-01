package com.myprojects.java8.inaction.examples.chap02;

public class RunnableExample {

	public final int value = 4;

	@SuppressWarnings("unused")
	public void doIt() {
		int value = 6;
		Runnable r = new Runnable() {
			public final int value = 5;

			@Override
			public void run() {
				int value = 10;
				System.out.println(this.value);
			}
		};
		r.run();
	}
	
	public static void main(String[] args) {
		RunnableExample m = new RunnableExample();
		m.doIt();

	}

}
