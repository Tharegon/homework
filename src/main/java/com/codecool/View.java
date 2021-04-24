package com.codecool;

import com.codecool.entity.PlantOrder;

import java.util.List;

public class View {

    public void menuTitle() {
        System.out.println("This is the menu");
    }

    public void linePrinter(String line){
        System.out.println(line);
    }

    public void showReports(){
        System.out.println("1.option");
        System.out.println("2.option");
        System.out.println("3.option");
    }

    public void printList(List<Object> POJO) {
        for (Object item: POJO
             ) {
            System.out.println(item);
        }
    }
}
