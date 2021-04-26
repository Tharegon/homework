package com.codecool.pojo;

import com.codecool.entity.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PlantOrderPojo {

    @Id
    @NotNull
    private UUID orderId;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private UUID inventoryItemLocationId;
    @NotNull
    private Double listingPrice;
    @NotNull
    private String currency;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer listingStatus;
    @NotNull
    private Integer marketplace;
    @NonNull
    private String uploadTime;
    @NotNull
    private String ownerEmailAddress;

    public PlantOrderPojo(@JsonProperty("id") UUID orderId,
                      @JsonProperty("title") String title,
                      @JsonProperty("description") String description,
                      @JsonProperty("location_id") UUID inventoryItemLocation,
                      @JsonProperty("listing_price") Double listingPrice,
                      @JsonProperty("currency") String currency,
                      @JsonProperty("quantity") Integer quantity,
                      @JsonProperty("listing_status") Integer listingStatus,
                      @JsonProperty("marketplace") Integer marketplace,
                      @JsonProperty("upload_time") String uploadTime,
                      @JsonProperty("owner_email_address") String ownerEmailAddress) {
        this.orderId = orderId;
        this.title = title;
        this.description = description;
        this.inventoryItemLocationId = inventoryItemLocation;
        this.listingPrice = listingPrice;
        this.currency = currency;
        this.quantity = quantity;
        this.listingStatus = listingStatus;
        this.marketplace = marketplace;
        this.uploadTime = uploadTime;
        this.ownerEmailAddress = ownerEmailAddress;
    }
}