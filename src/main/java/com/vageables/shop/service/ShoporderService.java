package com.vageables.shop.service;

import com.vageables.shop.entity.Confirmorder;
import com.vageables.shop.entity.Shoporder;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 12:30
 * @description : --ShoporderService类描述--
 */

public interface ShoporderService {
    Object AddShoporder(Shoporder shoporder);
    void DeleteShoporder(Integer id);
    List<Shoporder> ViewByOrderid(Integer id);
    void BatchDeleteShoporder(List<Integer> ids);
}
