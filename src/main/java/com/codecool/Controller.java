package com.codecool;

import com.codecool.dao.LocationDao;
import com.codecool.dao.MarketplaceDao;
import com.codecool.dao.PlantOrderDao;
import com.codecool.dao.StatusDao;
import com.codecool.entity.Location;
import com.codecool.entity.Marketplace;
import com.codecool.entity.PlantOrder;
import com.codecool.entity.Status;
import com.codecool.pojo.LocationPojo;
import com.codecool.pojo.PlantOrderPojo;

import java.text.SimpleDateFormat;
import java.time.Instant;
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
                break;
            case "database":
                List<PlantOrderPojo> orders = service.generatePlantOrderPOJO();
                List<LocationPojo> locations = service.generateLocationPOJO();
                List<Status> statuses = service.generateStatusPOJO();
                List<Marketplace> marketplaces = service.generateMarketplacePOJO();
                MarketplaceDao marketplaceDao = new MarketplaceDao();
                StatusDao statusDao = new StatusDao();

                marketplaces.forEach(marketplaceDao::saveMarketplace);
                statuses.forEach(statusDao::saveStatus);


                HashMap<UUID, LocationPojo> locationsMap = new HashMap<>();

                for (LocationPojo location : locations) {
                    locationsMap.put(location.getLocationId(), location);
                }
                List<PlantOrder> orderList = new ArrayList<>();
                PlantOrderDao plantOrderDao = new PlantOrderDao();
                LocationDao locationDao = new LocationDao();
                Set<Location> locationsSet=new HashSet<>();

                String empty = null;
                for (PlantOrderPojo orderPojo : orders) {
                    if (locationsMap.containsKey(orderPojo.getInventoryItemLocationId())) {
                        LocationPojo locationPojo = locationsMap.getOrDefault(orderPojo.getInventoryItemLocationId(), null);

                        Location location = new Location(locationPojo.getLocationId().toString(),
                                locationPojo.getManagerName(),
                                locationPojo.getPhone(),
                                locationPojo.getAddressPrimary(),
                                locationPojo.getAddressSecondary(),
                                locationPojo.getCountry(),
                                locationPojo.getTown(),
                                locationPojo.getPostalCode());

                        locationsSet.add(location);

                        PlantOrder order = new PlantOrder(orderPojo.getOrderId().toString(),
                                orderPojo.getTitle(),
                                orderPojo.getDescription(),
                                location,
                                orderPojo.getListingPrice(),
                                orderPojo.getCurrency(),
                                orderPojo.getQuantity(),
                                StatusDao.getStatusById(orderPojo.getListingStatus()),
                                marketplaceDao.getMarketplaceById(orderPojo.getMarketplace()),

                                null != orderPojo.getUploadTime() ? new SimpleDateFormat("dd/MM/yyyy").parse(orderPojo.getUploadTime()) : Date.from(Instant.now()),
                                orderPojo.getOwnerEmailAddress());
                        orderList.add(order);
                    }
                }
                locationsSet.forEach(locationDao::saveLocation);
                orderList.forEach(plantOrderDao::saveOrder);


                /*PlantOrderDao plantOrderDao = new PlantOrderDao();
                LocationDao locationDao = new LocationDao();

                orders.forEach(s -> plantOrderDao.saveOrder(s));
                locations.forEach(x -> locationDao.saveLocation(x));
                marketplaces.forEach(c->marketplaceDao.saveMarketplace(c));
                statuses.forEach(y->statusDao.saveStatus(y));*/


                readCommand(readLine());
            case "exit":
                break;
            default:
                System.out.println("invalid input");
                readCommand(readLine());
        }
    }
}
