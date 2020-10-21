package com.fascalsj.clienttest.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StoreDto {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;
}
