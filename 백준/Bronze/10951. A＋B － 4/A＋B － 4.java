import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] numArr = input.split(" ");
            System.out.println(Integer.parseInt(numArr[0]) + Integer.parseInt(numArr[1]));
        }
    }
}