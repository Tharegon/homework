package com.codecool.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class PlantOrder {

    private UUID id;
    private String title;
    private String description;
    private UUID inventoryItemLocationId;
    private Double listingPrice;
    private String currency;
    private Integer quantity;
    private Integer listingStatus;
    private Integer marketplace;
    private String uploadTime;
    private String ownerEmailAddress;

    public PlantOrder(@JsonProperty("id") UUID id,
                      @JsonProperty("title") String title,
                      @JsonProperty("description") String description,
                      @JsonProperty("location_id") UUID inventoryItemLocationId,
                      @JsonProperty("listing_price") Double listingPrice,
                      @JsonProperty("currency") String currency,
                      @JsonProperty("quantity") Integer quantity,
                      @JsonProperty("listing_status") Integer listingStatus,
                      @JsonProperty("marketplace")Integer marketplace,
                      @JsonProperty("upload_time") String uploadTime,
                      @JsonProperty("owner_email_address")String ownerEmailAddress) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.inventoryItemLocationId = inventoryItemLocationId;
        this.listingPrice = listingPrice;
        this.currency = currency;
        this.quantity = quantity;
        this.listingStatus = listingStatus;
        this.marketplace = marketplace;
        this.uploadTime = uploadTime;
        this.ownerEmailAddress = ownerEmailAddress;
    }
}
