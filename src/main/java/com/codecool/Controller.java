package com.codecool;

import java.util.Objects;
import java.util.Scanner;

public class Controller {

    private View view;
    private RestAPIService service;

    public Controller(View view, RestAPIService service) {
        Objects.requireNonNull(view);
        this.view = view;
        Objects.requireNonNull(service);
        this.service = service;
    }

    private String readLine(){
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }

    public void menu(){
        view.menuTitle();
        try {
            readCommand(readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void readCommand(String command) throws Exception{
        switch (command){
            case "report":
                view.showReports();
                break;
            case "database":
                view.printList(service.generatePOJO());
                break;
            case "exit":
                break;
            default:
                System.out.println("invalid input");
                readCommand(readLine());
        }
    }
}
