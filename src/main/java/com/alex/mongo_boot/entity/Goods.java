package com.alex.mongo_boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class Goods implements Serializable
{
    @Id
    private String id;

    private Integer goodsId;

    private Integer catId;

    private String goodsName;

    private Integer goodsNumber;

    private Integer clickCount;

    private Double shopPrice;

    private Long addTime;
}
