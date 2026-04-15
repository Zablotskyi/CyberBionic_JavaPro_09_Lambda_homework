import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//Завдання 2
//Створити список та заповнити рандомними числами 10 осередків, потрібно вивести суму квадратів усіх елементів списку.
//Ми використовуємо метод map() для зведення квадрат кожного елемента, а потім застосовуємо метод reduce() для згортки
//всіх елементів в одне число.
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = random.ints(10, 0, 10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("== Створено список з 10 елементів і заповнено такими рандомними числами: " + list + " ==");

        int sumOfSquares = list.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);

        System.out.println("== Сума всіх квадратів чисел: " + sumOfSquares + " ==");
    }
}
