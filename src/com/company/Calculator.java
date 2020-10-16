package com.company;

import java.util.Arrays;

public class Calculator {
    private String string;

    public Calculator(String string) {
        this.string = string;


    }

    public void calculate() {
        String[] parts = string.split(" ");
        Number n1 = new Number(parts[0]);
        Number n2 = new Number(parts[2]);
        if (n1.isRoman() != n2.isRoman()) {
            throw new NumberFormatException();
        }
        int a = n1.getValue();
        int b = n2.getValue();
        Number c = null;
        switch (parts[1]) {
            case "+":
                c = new Number(a + b);
                break;
            case "-":
                c = new Number(a - b);
                break;
            case "*":
                c = new Number(a * b);
                break;
            case "/":
                c = new Number(a / b);
        }
        if (c == null) {
            throw new ArithmeticException("Wrong operation: " + parts[1]);
        }
        if (n1.isRoman()) {
            System.out.println(c.getRomanValue());
        } else {
            System.out.println(c.getValue());
        }

    }
}
