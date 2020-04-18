package com.vageables.shop.service;

import com.vageables.shop.entity.Shopcar;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 12:30
 * @description : --ShopcarService类描述--
 */

public interface ShopcarService {
    Object Addshopcar(Shopcar shopcar);
    void DeleteShopcar(Integer id);
    void BatchDeleteShopcar(List<Integer> ids);
    List<Shopcar> ViewByUserID(Integer userid);
}
