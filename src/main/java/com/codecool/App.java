package com.codecool;


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
