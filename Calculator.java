import java.util.ArrayList;

public class Calculator implements ICalculator {
    private PostfixCalculator postfixCalculator;

    public Calculator(Stack<Integer> stack) {
        this.postfixCalculator = new PostfixCalculator(stack);
    }

    @Override
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    @Override
    public int substraction(int n1, int n2) {
        return n1 - n2;
    }

    @Override
    public int multiplication(int n1, int n2) {
        return n1 * n2;
    }

    @Override
    public int division(int n1, int n2) throws Exception {
        if (n2 == 0) {
            throw new ArithmeticException("División entre cero");
        }
        return n1 / n2;
    }

    @Override
    public int residue(int n1, int n2) throws Exception {
        if (n2 == 0) {
            throw new ArithmeticException("División entre cero");
        }
        return n1 % n2;
    }

    @Override
    public ArrayList<String> read(String charactersString) throws Exception {
        // Lógica para leer caracteres y convertirlos en una lista de elementos

        String[] tokens = charactersString.split(" ");
        ArrayList<String> elements = new ArrayList<>();
        for (String token : tokens) {
            elements.add(token);
        }
        return elements;
    }

    @Override
    public int solve(ArrayList<String> elements) throws Exception {
        // Usa el ADT PostfixCalculator para evaluar la expresión POSTFIX
        return postfixCalculator.evaluateExpression(elements);
    }
}
