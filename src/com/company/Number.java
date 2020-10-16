package com.company;

public class Number {
    private int value;
    private boolean isRoman;


    public Number(String number) {
        try {
            value = Integer.parseInt(number);
            isRoman = false;
        } catch (NumberFormatException e) {
            value = romanToInt(number);
            isRoman = true;
        }
        if (value < 1 || value > 10) {
            throw new NumberFormatException("Wrong number: " + value);
        }

    }

    public Number(int value) {
        this.value = value;
    }

    public boolean isRoman() {
        return isRoman;
    }

    public int getValue() {
        return value;
    }
    public String getRomanValue() {
        if (value == 100) {
            return "C";
        }
        String roman = "";
        if (value > 9) {
            roman = digitToRoman(value / 10, 'X', 'L', 'C');
        }
        roman += digitToRoman(value % 10, 'I', 'V', 'X');
        return roman;
    }

    private String digitToRoman(int digit, char min, char med, char max) {
        String roman = "";
        if (digit % 5 == 4) {
            roman += min;
        }
        if (digit >= 4 && digit <= 8) {
            roman += med;
        }
        if (digit == 9) {
            roman += max;
        }
        if (digit % 5 < 4) {
            for (int i = 0; i < digit % 5; i++) {
                roman += min;
            }
        }
        return roman;
    }

    private int charToInt(char c) {
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        return -1;
    }

    private int romanToInt(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            int n = charToInt(string.charAt(i));
            if (i < string.length() - 1 && n < charToInt(string.charAt(i + 1))) {
                n *= -1;
            }
            sum += n;
        }
        return sum;
    }
}
