package com.myprojects.java8.model;

public class Transaction_ {

	private final Currency currency;
	private final double value;

	public Transaction_(Currency currency, double value) {
		this.currency = currency;
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return currency + " " + value;
	}

}
