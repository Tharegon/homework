package com.codecool.controller;

import com.codecool.service.DatabaseService;
import com.codecool.service.RestAPIService;
import com.codecool.view.View;

import java.util.*;

public class Controller {

    private View view;
    private RestAPIService service;

    public Controller(View view, RestAPIService service) {
        Objects.requireNonNull(view);
        this.view = view;
        Objects.requireNonNull(service);
        this.service = service;
    }

    private String readLine() {
        System.out.print("Type here ->");
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextLine();
    }

    public void menu() {
        view.menuTitle();
        try {
            readCommand(readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void readCommand(String command) throws Exception {
        switch (command) {
            case "report":
                view.showReports();
                readCommand(readLine());
            case "database":
                DatabaseService databaseService = new DatabaseService();
                databaseService.generateDB(service);
                readCommand(readLine());
            case "exit":
                break;
            default:
                System.out.println("invalid input");
                readCommand(readLine());
        }
    }
}
