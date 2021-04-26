package com.codecool.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table
@Entity
public class Marketplace {

    @Id
    private Integer marketplaceId;
    private String marketplaceName;

    public Marketplace(@JsonProperty("id") Integer marketplaceId,
                       @JsonProperty("marketplace_name") String marketplaceName) {
        this.marketplaceId = marketplaceId;
        this.marketplaceName = marketplaceName;
    }
}
