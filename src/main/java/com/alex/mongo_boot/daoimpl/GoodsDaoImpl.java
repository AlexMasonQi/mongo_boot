package com.alex.mongo_boot.daoimpl;

import com.alex.mongo_boot.dao.GoodsDao;
import com.alex.mongo_boot.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class GoodsDaoImpl implements GoodsDao
{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Goods findGoodsByGoodName(String goodsName)
    {
        Query query = new Query(Criteria.where("goodsName").is(goodsName));
        return mongoTemplate.findOne(query, Goods.class);
    }

    @Override
    public void addGoods(Goods goods)
    {
        mongoTemplate.save(goods);
    }

    @Override
    public void updateGoods(Goods goods)
    {
        Query query = new Query(Criteria.where("goodsId").is(goods.getGoodsId()));
        Update update = new Update().set("goodsName", goods.getGoodsName()).set("shopPrice", goods.getShopPrice());

        //更新结果返回第一条
        mongoTemplate.updateFirst(query, update, Goods.class);

        //更新结果返回所有
//        mongoTemplate.updateMulti(query, update, Goods.class);
    }

    @Override
    public void deleteGoods(Integer goodsId)
    {
        Query query = new Query(Criteria.where("goodsId").is(goodsId));
        mongoTemplate.remove(query, Goods.class);
    }
}
