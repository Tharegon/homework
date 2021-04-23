package com.codecool;

import com.codecool.dao.PlantOrderDao;
import com.codecool.entity.PlantOrder;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

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
                List<PlantOrder> orders = service.generatePOJO();
                PlantOrderDao dao = new PlantOrderDao();
                orders.forEach(s -> dao.saveOrder(s));
                view.printList(dao.getOrders());
                readCommand(readLine());
            case "exit":
                break;
            default:
                System.out.println("invalid input");
                readCommand(readLine());
        }
    }
}
