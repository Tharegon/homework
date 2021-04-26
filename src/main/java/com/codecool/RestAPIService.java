package com.codecool;



import com.codecool.entity.Location;
import com.codecool.entity.Marketplace;
import com.codecool.entity.PlantOrder;
import com.codecool.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class RestAPIService {

    public List<PlantOrder> generatePlantOrderPOJO() throws Exception{

            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            /*
            HttpGet request = new HttpGet("https://my.api.mockaroo.com/listing?key=63304c70");

            CloseableHttpClient client=  HttpClients.createDefault();
            PlantOrder[] response = client.execute(request, httpResponse ->{
                System.out.println(httpResponse.getCode());
                String body = httpResponse.getEntity().getContent().toString();
                System.out.println(body);
                return mapper.readValue(body, PlantOrder[].class);
                return Arrays.asList(response);
            });*/



            InputStream input = new FileInputStream("src/main/java/com/codecool/json/order.json");


            List<PlantOrder> plantOrder = mapper.readValue(input, new TypeReference<List<PlantOrder>>() {});
            return plantOrder;
    }

    public List<Location> generateLocationPOJO() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream input = new FileInputStream("src/main/java/com/codecool/json/location.json");
        List<Location> locations = objectMapper.readValue(input, new TypeReference<List<Location>>() {});
        return locations;
    }

    public List<Status> generateStatusPOJO() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream input = new FileInputStream("src/main/java/com/codecool/json/status.json");
        List<Status> statuses = objectMapper.readValue(input, new TypeReference<List<Status>>() {});
        return statuses;
    }

    public List<Marketplace> generateMarketplacePOJO() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream input = new FileInputStream("src/main/java/com/codecool/json/marketplace.json");
        List<Marketplace> marketplaces = objectMapper.readValue(input, new TypeReference<List<Marketplace>>() {});
        return marketplaces;
    }
    }

