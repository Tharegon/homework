package com.codecool;

import java.util.Objects;
import java.util.Scanner;

public class Controller {

    private View view;

    public Controller(View view) {
        Objects.requireNonNull(view);
        this.view = view;
    }

    private String readLine(){
        Scanner myScanner = new Scanner(System.in);
        String command = myScanner.nextLine();
        return command;
    }

    public void menu(){
        view.menuTitle();
        readCommand(readLine());

    }

    private void readCommand(String command){
        switch (command){
            case "report":
                view.showReports();
                break;
            default:
                System.out.println("invalid input");
                break;
        }
    }
}
