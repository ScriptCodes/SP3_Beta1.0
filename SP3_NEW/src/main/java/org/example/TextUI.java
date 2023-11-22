package org.example;
import java.util.Scanner;

public class TextUI {
    private Scanner scan = new Scanner(System.in);

    public String displayMsg(String msg){

        System.out.println(msg);

        return msg;

    }
    public String getInput(String msg){

        return scan.nextLine();
    }

    public int getIntInput(String msg){

        System.out.println(msg);
        return scan.nextInt();
    }
}
