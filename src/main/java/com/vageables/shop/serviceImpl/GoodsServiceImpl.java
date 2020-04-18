package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Category;
import com.vageables.shop.entity.Goods;
import com.vageables.shop.repository.GoodsRepository;
import com.vageables.shop.requestBody.PriceBody;
import com.vageables.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 14:03
 * @description : --GoodsServiceImpl类描述--
 */

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Object AddGoods(Goods goods) {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        goods.setGoodscode(df.format(new Date()));
        return goodsRepository.save(goods);
    }

    @Override
    public void DeleteGoods(Goods goods) {
        goodsRepository.deleteById(goods.getId());
    }

    @Override
    public List<Goods> ViewGoods() {
        return goodsRepository.findAll();
    }

    @Override
    public List<Goods> ViewGoodsByCate(Category category) {
        return goodsRepository.findAllByCateid(category.getId());
    }

    @Override
    public List<Goods> ViewByCateAsc(Category category) {
        return goodsRepository.findGoodsByCateidOrderByGoodspriceAsc(category.getId());
    }

    @Override
    public List<Goods> ViewGoodsByPrice(PriceBody priceBody) {
        return goodsRepository.findGoodsByGoodspriceBetween(priceBody.getPrice1(), priceBody.getPrice2());
    }

    @Override
    public List<Goods> ViewGoodsByPriceAsc() {
        return goodsRepository.findAll(Sort.by(Sort.Direction.ASC,"goodsprice"));
    }

    @Override
    public List<Goods> ViewGoodsByPriceDesc() {
        return goodsRepository.findAll(Sort.by(Sort.Direction.DESC,"goodsprice"));
    }

    @Override
    public List<Goods> getMaxID() {
        return goodsRepository.getMaxID();
    }
}
