package com.vageables.shop.service;

import com.vageables.shop.entity.Goodsimage;

/**
 * @author : hello
 * @date : 2020/4/8 12:30
 * @description : --GoodsimageService类描述--
 */

public interface GoodsimageService {
    Object AddGoodsimage(Goodsimage goodsimage);

    void DeleteGoodsimage(Goodsimage goodsimage);

    String getImagePath(Integer goodsID);

    void deleteImageBygood(Integer goodid);
}
