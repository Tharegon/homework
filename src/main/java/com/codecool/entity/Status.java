package com.codecool.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Status {

    @Id
    private Integer statusId;
    private String statusName;

    public Status(@JsonProperty("id") Integer statusId,
                  @JsonProperty("status_name") String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }
}
