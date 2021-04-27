package com.codecool.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table()
public class PlantOrder {

    @Id
    @NotNull
    private String orderId;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Location inventoryItemLocation;
    @NotNull
    private Double listingPrice;
    @NotNull
    private String currency;
    @NotNull
    private Integer quantity;
    @NotNull
    @ManyToOne
    private Status listingStatus;
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Marketplace marketplace;
    @NotNull
    private Date uploadTime;
    @NotNull
    private String ownerEmailAddress;

    public PlantOrder(@JsonProperty("id") String orderId,
                      @JsonProperty("title") String title,
                      @JsonProperty("description") String description,
                      @JsonProperty("location_id") Location inventoryItemLocation,
                      @JsonProperty("listing_price") Double listingPrice,
                      @JsonProperty("currency") String currency,
                      @JsonProperty("quantity") Integer quantity,
                      @JsonProperty("listing_status") Status listingStatus,
                      @JsonProperty("marketplace")Marketplace marketplace,
                      @JsonProperty("upload_time") Date uploadTime,
                      @JsonProperty("owner_email_address")String ownerEmailAddress) {
        this.orderId = orderId;
        this.title = title;
        this.description = description;
        this.inventoryItemLocation = inventoryItemLocation;
        this.listingPrice = listingPrice;
        this.currency = currency;
        this.quantity = quantity;
        this.listingStatus = listingStatus;
        this.marketplace = marketplace;
        this.uploadTime = Objects.requireNonNull(uploadTime);
        this.ownerEmailAddress = ownerEmailAddress;
    }
}
