package com.alex.mongo_boot.controller;

import com.alex.mongo_boot.dao.GoodsDao;
import com.alex.mongo_boot.entity.Goods;
import com.alex.mongo_boot.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@RequestMapping("/v1")
public class GoodsController
{
    @Autowired
    private GoodsDao goodsDao;

    @GetMapping("/goods/{goodsName}")
    public Goods findGoodsByGoodsName(@PathVariable String goodsName)
    {
        return goodsDao.findGoodsByGoodName(goodsName);
    }

    @GetMapping("/goods/addGoods")
    public Boolean addGoods()
    {
        Boolean tag = false;
        Goods goods = new Goods();
        goods.setId(UUIDUtil.getRandomUUID());
        goods.setGoodsId(33);
        goods.setCatId(6);
        goods.setGoodsName("Surface Laptop 2");
        goods.setGoodsNumber(21);
        goods.setClickCount(40);
        goods.setShopPrice(16400.0);
        goods.setAddTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)));

        goodsDao.addGoods(goods);
        tag = true;

        return tag;
    }

    @GetMapping("/goods/updateGoods")
    public Boolean updateGoods()
    {
        Boolean tag = false;
        Goods goods = new Goods();
        goods.setId(UUIDUtil.getRandomUUID());
        goods.setGoodsId(33);
        goods.setCatId(6);
        goods.setGoodsName("Surface Studio 2");
        goods.setGoodsNumber(21);
        goods.setClickCount(40);
        goods.setShopPrice(19900.0);
        goods.setAddTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)));

        goodsDao.updateGoods(goods);
        tag = true;

        return tag;
    }

    @GetMapping("/goods/deleteGoods/{goodsId}")
    public Boolean deleteGoodsByGoodsId(@PathVariable Integer goodsId)
    {
        Boolean tag = false;

        goodsDao.deleteGoods(goodsId);
        tag = true;

        return tag;
    }
}
