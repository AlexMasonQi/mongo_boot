package com.alex.mongo_boot.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Document(collection = "goods")
public class Goods implements Serializable
{
    @Field("_id")
    private String id;

    @Field("goods_id")
    private Integer goodsId;

    @Field("cat_id")
    private Integer catId;

    @Field("goods_name")
    private String goodsName;

    @Field("goods_number")
    private Integer goodsNumber;

    @Field("click_count")
    private Integer clickCount;

    @Field("shop_price")
    private Double shopPrice;

    @Field("add_time")
    private Long addTime;
}
