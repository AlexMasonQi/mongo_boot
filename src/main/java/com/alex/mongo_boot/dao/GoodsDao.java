package com.alex.mongo_boot.dao;

import com.alex.mongo_boot.entity.Goods;

public interface GoodsDao
{
    //查询
    Goods findGoodsByGoodName(String goodsName);

    //增加
    void addGoods(Goods goods);

    //修改
    void updateGoods(Goods goods);

    //删除
    void deleteGoods(Integer goodsId);
}
