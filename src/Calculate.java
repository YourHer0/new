import java.util.Map;

public class Calculate {
    private static final Map<String, Integer> number = Map.ofEntries(
            Map.entry("I", 1),
            Map.entry("II", 2),
            Map.entry("III", 3),
            Map.entry("IV", 4),
            Map.entry("V", 5),
            Map.entry("VI", 6),
            Map.entry("VII", 7),
            Map.entry("VIII", 8),
            Map.entry("IX", 9),
            Map.entry("X", 10)
    );

    public static String calc(String input) {
        String result = null;
        Integer firstNumber = -1;
        Integer secondNumber = -1;
        Integer calculate = -1;
        String[] values = input.split(" ");
        if(values.length < 3) {
            throw new IllegalArgumentException("Строка не является математической операцией.");
        } else if (values.length > 3) {
            throw  new IllegalArgumentException("Введено некорректное выражение.");
        }
        int romanNumerals = 0;
        if (number.containsKey(values[0])) {
            firstNumber = number.get(values[0]);
            romanNumerals++;
        }
        if (number.containsKey(values[2])) {
            secondNumber = number.get(values[2]);
            romanNumerals++;
        }


        if (romanNumerals == 0) {
            try {
                Double firstNumberCheck = Double.valueOf(values[0]);
                Double secondNumberCheck = Double.valueOf(values[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Введено некорретное выражение.");
            }
            try {
                firstNumber = Integer.valueOf(values[0]);
                secondNumber = Integer.valueOf(values[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Калькулятор работает только с целыми числами.");
            }
            if (firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) {
                throw new IllegalArgumentException("Калькулятор работает только с числами от 1 до 10.");
            }


            if (values[1].equals("+")) {
                calculate = firstNumber + secondNumber;
            } else if (values[1].equals("-")) {
                calculate = firstNumber - secondNumber;
            } else if (values[1].equals("*")) {
                calculate = firstNumber * secondNumber;
            } else if (values[1].equals("/")) {
                calculate = firstNumber / secondNumber;
            }
            result = String.valueOf(calculate);

        } else if (romanNumerals == 2) {
            if (values[1].equals("+")) {
                calculate = firstNumber + secondNumber;
            } else if (values[1].equals("-")) {
                calculate = firstNumber - secondNumber;
                if (calculate < 1) {
                    throw new IllegalStateException("Результатом работы калькулятора с римскими числами могут быть только положительные числа.");
                }

            } else if (values[1].equals("*")) {
                calculate = firstNumber * secondNumber;
            } else if (values[1].equals("/")) {
                calculate = firstNumber / secondNumber;
            }
            result = ArabicToRoman.convert(calculate);
        } else {
            try {
                if (firstNumber == -1) {
                    Integer.valueOf(values[0]);
                }
                if (secondNumber == -1) {
                    Integer.valueOf(values[2]);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Введено некорректное выражение.");
            }
            throw new IllegalArgumentException("Используются одновременно разные системы счисления.");
        }
        return result;
    }
}



