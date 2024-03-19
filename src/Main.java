import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите математическое выражение:");
        String needToCalculate = scanner.nextLine();
        System.out.println(Calculate.calc(needToCalculate));
    }
}