package com.codecool;


import com.codecool.controller.Controller;
import com.codecool.service.RestAPIService;
import com.codecool.view.View;

public class App
{
    public static void main( String[] args )
    {
        View view = new View();
        RestAPIService service = new RestAPIService();
        Controller controller = new Controller(view,service);
        controller.menu();
    }
}
