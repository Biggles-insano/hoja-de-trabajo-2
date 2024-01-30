import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            // Cambia la implementación de la pila según tus necesidades
            Stack<Integer> stack = new VectorStack<>();
            ICalculator calculator = new Calculator(stack);

            // Lee expresiones desde un archivo de texto
            ArrayList<String> expressions = readExpressionsFromFile("datos.txt");

            // Evalúa cada expresión
            for (String expression : expressions) {
                int result = calculator.solve(calculator.read(expression));
                System.out.println("Expresión: " + expression + " Resultado: " + result);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static ArrayList<String> readExpressionsFromFile(String filePath) throws Exception {
        ArrayList<String> expressions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                expressions.add(line.trim());
            }
        }
        return expressions;
    }
}

class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("La pila está vacía");
    }
}
