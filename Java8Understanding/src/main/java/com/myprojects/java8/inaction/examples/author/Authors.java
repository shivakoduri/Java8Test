package com.myprojects.java8.inaction.examples.author;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Authors {

	Author[] value();
}
