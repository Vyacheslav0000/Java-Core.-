package ru.geerbrains;

/**
 * 1. Напишите метод, на вход которого подается двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 *
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит
 * символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 * – с детализацией, в какой именно ячейке лежат неверные данные.
 *
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения
 * MySizeArrayException и MyArrayDataException и вывести результат расчета.
 */

public class Main {

    public static void main(String[] args) {
        //String s = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; // OK
        //String s = "13 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; //  NOT 4x4 ARRAY Exception
          String s = "1 3 1 a\n2 3 2 2\n5 6 7 1\n3 3 1 0"; // NumberFormatException

        String[][] stringArray = convertStringToArray(s);
        System.out.println(calculate(stringArray));
    }

    static String[][] convertStringToArray(String s) {
        String tmp = s + "\n";
        for (int i = 0, space = 0, n = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ' ') space++;
            if (tmp.charAt(i) == '\n') {
                if (space == 3) space = 0;
                else throw new MyArraySizeException("размер матрицы, полученной из строки, не равен 4x4");
            }
        }

        int length = s.split("\n").length;
        String[][] result = new String[length][length];
        String[] clearN = s.split("\n");

        for (int i = 0; i < length; i++) {
            String[] clearSpaces = clearN[i].split(" ");
            for (int j = 0; j < length; j++) {
                result[i][j] = clearSpaces[j];
            }
        }

        return result;
    }
    class MyArrayDataException extends RuntimeException{
        int row, column;

        public MyArrayDataException(int row, int column) {
            super(row + " " + column);
            this.row = row;
            this.column = column;
        }
    }
    static double calculate(String[][] s) {
        int sum = 0;

        int i, j;

        for (i = 0; i < s.length; i++) {

            for (j = 0; j < s.length; j++) {
                try {
                    sum += Integer.parseInt (s[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("в " + sum + " ячейке полученной матрицы не число");
                    e.printStackTrace();
                }
            }
        }

        return sum / 2;
    }
}