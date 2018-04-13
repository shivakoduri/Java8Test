package com.myprojects.java8.inaction.examples.chap08;

public class StrategyMain {

    public static void main(String... args){
        //Imperative way
        Validator v1 = new Validator(new IsNumeric());
        System.out.println(v1.validate("aaa"));
        Validator v2 = new Validator(new IsAllLowerCase());
        System.out.println(v2.validate("bbb"));

        //Declarative way
        Validator v3 = new Validator((String s) -> s.matches("\\d+"));
        System.out.println(v3.validate("aaaa"));

        Validator v4 = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(v4.validate("bbbb"));

    }

    interface ValidationStrategy{
        public boolean execute(String s);
    }

    static private class IsAllLowerCase implements ValidationStrategy{

        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    static private class IsNumeric implements  ValidationStrategy{

        @Override
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

    static private class Validator{
        private final ValidationStrategy strategy;
        public Validator(ValidationStrategy v){
            this.strategy =v;
        }

        public boolean validate(String s){
            return strategy.execute(s);
        }
    }
}
