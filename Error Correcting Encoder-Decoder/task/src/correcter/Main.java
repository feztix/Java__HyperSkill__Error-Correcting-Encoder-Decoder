package correcter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ErrorGenerator errorGenerator = new ErrorGenerator();

        String input = scanner.nextLine();
        int groupOfCharacters = 3;
        System.out.println(errorGenerator.generateErrors(input, groupOfCharacters));
    }
}
