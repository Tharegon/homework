package com.codecool.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Location {

    @Id
    private UUID id;
    private String managerName;
    private String phone;
    private String addressPrimary;
    private String addressSecondary;
    private String country;
    private String town;

    public Location(@JsonProperty("id") UUID id,
                    @JsonProperty("manager_name") String managerName,
                    @JsonProperty("phone") String phone,
                    @JsonProperty("address_primary") String addressPrimary,
                    @JsonProperty("address_secondary") String addressSecondary,
                    @JsonProperty("country") String country,
                    @JsonProperty("town") String town,
                    @JsonProperty("postal_code") String postalCode) {
        this.id = id;
        this.managerName = managerName;
        this.phone = phone;
        this.addressPrimary = addressPrimary;
        this.addressSecondary = addressSecondary;
        this.country = country;
        this.town = town;
        this.postalCode = postalCode;
    }

    private String postalCode;

}
