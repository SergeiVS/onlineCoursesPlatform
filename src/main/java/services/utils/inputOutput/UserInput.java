package services.utils.inputOutput;

import java.util.Scanner;

public class UserInput {

    public static Integer insertInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }
    public static String insertString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
    public static Boolean insertBoolean(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextBoolean();
    }
    public static String insertChar(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

}
