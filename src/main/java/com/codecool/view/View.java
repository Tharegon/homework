package com.codecool.view;


public class View {

    public void menuTitle() {

        System.out.println("Menu");
        System.out.println("Type database first to fill up your database");
        System.out.println("Type report to show report options");
        System.out.println("Type exit to exit");
    }

    public void linePrinter(String line) {
        System.out.println(line);
    }

    public void showReports() {
        System.out.println("Report are not implemented yet.");
    }
}

