package com.codecool.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Table
@Entity
public class LocationPojo {


    @Id
    private UUID locationId;
    private String managerName;
    private String phone;
    private String addressPrimary;
    private String addressSecondary;
    private String country;
    private String town;
    private String postalCode;


    public LocationPojo(@JsonProperty("id") UUID locationId,
                    @JsonProperty("manager_name") String managerName,
                    @JsonProperty("phone") String phone,
                    @JsonProperty("address_primary") String addressPrimary,
                    @JsonProperty("address_secondary") String addressSecondary,
                    @JsonProperty("country") String country,
                    @JsonProperty("town") String town,
                    @JsonProperty("postal_code") String postalCode) {
        this.locationId = locationId;
        this.managerName = managerName;
        this.phone = phone;
        this.addressPrimary = addressPrimary;
        this.addressSecondary = addressSecondary;
        this.country = country;
        this.town = town;
        this.postalCode = postalCode;
    }


}