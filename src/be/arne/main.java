package be.arne;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) throws ScriptException {
        calculate();
    }

    private static void calculate() throws ScriptException {
        int operand1, operand2, operand3, operand4;
        char operator1, operator2, operator3, operator4;
        Random random = new Random();
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        char[] operators = new char[]{'+', '-', '/', '*'};
        int result = 0;
        String operation = ""; // this will hold all the operands and operators
        List<Integer> operands = Arrays.asList(1,3,4,6);
        while (result != 24) {
            Collections.shuffle(operands);
            operand1 = operands.get(0);
            operand2 = operands.get(1);
            operand3 = operands.get(2);
            operand4 = operands.get(3);
            operator1 = operators[random.nextInt(3)];
            operator2 = operators[random.nextInt(3)];
            operator3 = operators[random.nextInt(3)];

            /*So here is where it got a bit tricky and you can go different ways about this.
             I went the easy way and used the built-in Javascript engine.*/
            operation = String.valueOf(operand1) + operator1 + String.valueOf(operand2) + operator2 + String.valueOf(operand3) + operator3 + String.valueOf(operand4);
            System.out.println(operation);
            result = (int) Double.parseDouble(engine.eval(operation).toString());

        }
        System.out.println(operation + "= 24");
    }
}
