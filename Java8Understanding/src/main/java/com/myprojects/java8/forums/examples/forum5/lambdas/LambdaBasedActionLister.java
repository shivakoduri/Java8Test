package com.myprojects.java8.forums.examples.forum5.lambdas;

import javax.swing.*;

public class LambdaBasedActionLister extends JFrame {

    private int clicks = 0;

    public LambdaBasedActionLister() {
        JButton btn = new JButton("0");
        btn.setSize(50, 50);
        add(btn);

        // lambda magic goes here:
        btn.addActionListener(e -> {
            btn.setText(Integer.toString(clicks++));
        });

        setSize(100, 100);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new LambdaBasedActionLister();
    }
}
