package com.vageables.shop.controller;

import com.vageables.shop.config.ControllerAutowiredService;
import com.vageables.shop.entity.Goods;
import com.vageables.shop.entity.Goodsimage;
import com.vageables.shop.entity.Shopcar;
import com.vageables.shop.entity.Userinfo;
import com.vageables.shop.requestBody.ClearShopcar;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : @author
 * @date : 2020/4/8 14:47
 * @description : --Shopcar类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("shopcar")
public class ShopcarController extends ControllerAutowiredService {
    //加入购物车
    @PostMapping("/add")
    public Object Addshopcar(Shopcar shopcar) {
        return shopcarService.Addshopcar(shopcar);
    }

    //移除购物车
    @PostMapping("/delete")
    public void DeleteShopcar(Shopcar shopcar) {
        shopcarService.DeleteShopcar(shopcar.getId());
    }

    //批量移除购物车
    @PostMapping("/batchDel")
    public void BatchDeleteShopcar(ClearShopcar shopcar) {
        shopcarService.BatchDeleteShopcar(shopcar.getIds());
    }

    //查看购物车
    @PostMapping("/view")
    public Object ViewByUserID(Userinfo userinfo) {
        List<Shopcar> shopcars = shopcarService.ViewByUserID(userinfo.getId());
        List<Object> list = new ArrayList<>();
        for (Shopcar shopcar:shopcars){
            Map<String, Object> map = new HashMap<>();
            Goods goods = goodsRepository.findById(shopcar.getGoodsid()).get();
            Goodsimage goodsimage = goodsimageRepository.findAllByGoodsid(goods.getId()).get(0);
            map.put("id", shopcar.getId());
            map.put("goodsid", shopcar.getGoodsid());
            map.put("userid", shopcar.getUserid());
            map.put("goodsamount", shopcar.getGoodsamount());
            map.put("goodscount", shopcar.getGoodscount());
            map.put("goodsimage", goodsimage.getImagepath());
            map.put("goodsname",goods.getGoodsname());
            map.put("goodsweight",goods.getGoodsweight());
            map.put("goodsprice",goods.getGoodsprice());
            list.add(map);
        }
        return list;
    }
}
