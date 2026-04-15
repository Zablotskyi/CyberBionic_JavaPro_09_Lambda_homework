import java.util.Scanner;

//Завдання 4
//Напишіть основні арифметичні дії калькулятора, використовуючи лямбда-вирази
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Operation add = (a, b) -> a + b;
        Operation sub = (a, b) -> a - b;
        Operation mul = (a, b) -> a * b;
        Operation div = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Ділення на нуль заборонено!");
            return a / b;
        };

        try {
            System.out.println("Ведіть перше число: ");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.println("Введіть друге число: ");
            double b = Double.parseDouble(scanner.nextLine());
            System.out.println("Виберіть операцію (+, -, *, /): ");
            String operation = scanner.nextLine().trim();

            double result;
            switch (operation) {
                case "+":
                    result = add.apply(a, b);
                    break;
                case "-":
                    result = sub.apply(a, b);
                    break;
                case "*":
                    result = mul.apply(a, b);
                    break;
                case "/":
                    result = div.apply(a, b);
                    break;
                default:
                    throw new IllegalArgumentException("Невідома операція: " + operation);
            }

            System.out.println("Результат: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Введено не число: ");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("помилка: " + e.getMessage());
        }
    }
}
