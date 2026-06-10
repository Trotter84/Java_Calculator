import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    public void run() throws IOException {
        int results = 0;
        int x = getInput("Give me your first number.");
        int operation = getInput("What operation would you like to do?\n1. Add\n2. Subtract\n3. Multiply\n4. Divide");
        int y = getInput("Give me your second number.");
        switch (operation) {
            case 1:
                results = Calculator.add(x, y);
                break;
            case 2:
                results = Calculator.subtract(x, y);
                break;
            case 3:
                results = Calculator.multiply(x, y);
                break;
            case 4:
                results = Calculator.divide(x, y);
                break;
            default:
                run();
        }
        System.out.println(results);
    }

    private int getInput(String prompt) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(prompt + "\n>");
            String response = br.readLine();
            try {
                if (!response.isEmpty()) {
                    return Integer.valueOf(response);
                }
            } catch (IllegalArgumentException iae) {
                System.out.println("You entered an invalid option.");
            }
        } while (true);

    }
}
