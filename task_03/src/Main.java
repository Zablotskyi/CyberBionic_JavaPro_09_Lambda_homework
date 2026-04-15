import java.util.function.Predicate;

//Завдання 3
//Створити клас Book, зробити 3 поля та відповідні методи. Необхідно реалізувати замикання анонімного класу
//та лямбда-виразу.
public class Main {
    public static void main(String[] args) {
        final String prefix = "Книга: ";
        Book book = new Book("Clean Code", "Robert C. Martin", 2008);

        Printer printer = new Printer() {
            @Override
            public void print(Book book) {
                System.out.println(prefix + book.getTitle() + " (" + book.getYear() + ")");
            }
        };

        printer.print(book);

        int minYear = 2000;
        Predicate<Book> afterYear = b -> b.getYear() >= minYear;
        System.out.println("Рік >= " + minYear + " ? " + afterYear.test(book));
    }

}
