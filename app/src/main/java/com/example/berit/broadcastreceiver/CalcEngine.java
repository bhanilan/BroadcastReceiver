package com.example.berit.broadcastreceiver;

public class CalcEngine {
    //Arvutustehe
    public String calculate(double n1, double n2, String op) {
        double calc = 0;

        if (op.equals("+")) {
            calc = n1 + n2;
        } else if (op.equals("-")) {
            calc = n1 - n2;
        } else if (op.equals("÷")) {
            if(n2==0){
                return "Nulliga ei saa jagada";
            } else {
                calc = n1 / n2;
            }
        } else if (op.equals("×")) {
            calc = n1 * n2;
        }
        return String.valueOf(calc);
    }
}