package com.codecool;



import com.codecool.entity.PlantOrder;
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
import java.util.Collections;
import java.util.List;


public class RestAPIService {

    public List<PlantOrder> generatePOJO() throws Exception{


            /*HttpGet request = new HttpGet("https://my.api.mockaroo.com/listing?key=63304c70");

            PlantOrder response = client.execute(request, httpResponse ->
                    mapper.readValue(httpResponse.getEntity().getContent().toString(), PlantOrder.class));
            */
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            InputStream input = new FileInputStream("src/main/java/com/codecool/json/order.json");

            //PlantOrder plantOrder = objectMapper.readValue(input, PlantOrder.class);
            List<PlantOrder> plantOrder = objectMapper.readValue(input, new TypeReference<List<PlantOrder>>() {
            });
            //System.out.println(plantOrder);
            return plantOrder;
    }
    }

