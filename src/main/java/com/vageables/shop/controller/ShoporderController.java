package com.vageables.shop.controller;

import com.vageables.shop.config.ControllerAutowiredService;
import com.vageables.shop.entity.Confirmorder;
import com.vageables.shop.entity.Shoporder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : @author
 * @date : 2020/4/8 14:47
 * @description : --ShoporderController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("shoporder")
public class ShoporderController extends ControllerAutowiredService {
    //结算时从购物车移动到shoporder表同时删除购物车表中数据 一般是多选
    @PostMapping("/add")
    public Object AddShoporder() {
        return null;
    }
    @PostMapping("/delete")
    public void DeleteShoporder(Shoporder shoporder){
        shoporderService.DeleteShoporder(shoporder.getId());
    }
    @PostMapping("/view")
    public List<Shoporder> ViewByOrderid(Confirmorder confirmorder){
        return shoporderService.ViewByOrderid(confirmorder.getId());
    }
    @PostMapping("/batchDel")
    public void BatchDeleteShoporder(List<Integer> ids){
        shoporderService.BatchDeleteShoporder(ids);
    }
}
