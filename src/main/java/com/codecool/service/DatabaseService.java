package com.codecool.service;

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
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.*;

@NoArgsConstructor
public class DatabaseService {

    public void generateDB(RestAPIService service) throws Exception{

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
        Set<Location> locationsSet = new HashSet<>();

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
                if (orderPojo.getUploadTime() != null && orderPojo.getListingStatus()>=1 && orderPojo.getListingStatus()<=3 && orderPojo.getListingStatus() != null) {
                    PlantOrder order = new PlantOrder(orderPojo.getOrderId().toString(),
                            orderPojo.getTitle(),
                            orderPojo.getDescription(),
                            location,
                            orderPojo.getListingPrice(),
                            orderPojo.getCurrency(),
                            orderPojo.getQuantity(),
                            StatusDao.getStatusById(orderPojo.getListingStatus()),
                            marketplaceDao.getMarketplaceById(orderPojo.getMarketplace()),
                            new SimpleDateFormat("dd/MM/yyyy").parse(orderPojo.getUploadTime()),
                            orderPojo.getOwnerEmailAddress());
                    orderList.add(order);
                }
            }
        }
        locationsSet.forEach(locationDao::saveLocation);
        orderList.forEach(plantOrderDao::saveOrder);
    }
}
