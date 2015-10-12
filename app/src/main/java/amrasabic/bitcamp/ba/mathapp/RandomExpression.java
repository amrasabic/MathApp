package amrasabic.bitcamp.ba.mathapp;

import java.util.Random;

/**
 * Created by stvorenje on 10/12/15.
 */
public class RandomExpression {

    private static final int MIN = 1;
    private static final int MAX = 20;

    private static char[] operators = new char[] {
            '+', '-', '*', '/'
    };

    private int a;
    private int b;
    private char operator;
    private int mResult;

    public RandomExpression() {
        //  rand.nextInt((max - min) + 1) + min;
        Random rand = new Random();
        a = rand.nextInt((MAX - MIN) + 1) + MIN;
        b = rand.nextInt((MAX - MIN) + 1) + MIN;

        operator = operators[rand.nextInt(3)];

        if(operator == '+'){
            mResult = a + b;
        } else if(operator == '-'){
            mResult = a - b;
        } else if(operator == '*'){
            mResult = a * b;
        } else if(operator == '/'){
            mResult = a / b;
        }
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getResult() {
        return mResult;
    }

    public void setResult(int result) {
        mResult = result;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
