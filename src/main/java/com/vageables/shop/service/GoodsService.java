package com.vageables.shop.service;

import com.vageables.shop.entity.Category;
import com.vageables.shop.entity.Goods;
import com.vageables.shop.requestBody.PriceBody;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 12:29
 * @description : --GoodsService类描述--
 */

public interface GoodsService {
    Object AddGoods(Goods goods);

    void DeleteGoods(Goods goods);

    List<Goods> ViewGoods();

    List<Goods> ViewGoodsByCate(Category category);

    List<Goods> ViewByCateAsc(Category category);

    List<Goods> ViewGoodsByPrice(PriceBody priceBody);

    List<Goods> ViewGoodsByPriceAsc();

    List<Goods> ViewGoodsByPriceDesc();

    List<Goods> getMaxID();
}
