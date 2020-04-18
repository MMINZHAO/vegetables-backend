package com.vageables.shop.controller;

import com.vageables.shop.config.ControllerAutowiredService;
import com.vageables.shop.entity.Goods;
import com.vageables.shop.entity.Goodsimage;
import com.vageables.shop.requestBody.PriceBody;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : @author
 * @date : 2020/4/8 14:47
 * @description : --GoodsController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("goods")
public class GoodsController extends ControllerAutowiredService {

    @GetMapping("/view")
    public Object ViewGoods() {
        List<Goods> goods = goodsService.ViewGoods();
        List<HashMap<String, Object>> list = new ArrayList<>();
        for(Goods good:goods){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",good.getId());
            map.put("goodsname",good.getGoodsname());
            map.put("goodscode",good.getGoodscode());
            map.put("goodsweight",good.getGoodsweight());
            map.put("goodsprice",good.getGoodsprice());
            map.put("goodsinfo",good.getGoodsinfo());
            map.put("goodsstate",good.getGoodsstate());
            map.put("goodsimage",goodsimageService.getImagePath(good.getId()));
            list.add(map);
        }
        return list;
    }

    @PostMapping("/delete")
    public void DeleteGoods(Goods goods) {
        goodsService.DeleteGoods(goods);
        goodsimageService.deleteImageBygood(goods.getId());
    }

    @PostMapping("/add")
    public Object SaveGoods(Goods goods) {
        return goodsService.AddGoods(goods);
    }

    @GetMapping("/sortAsc")
    public Object SortGoodsAsc() {
        List<Goods> goods =  goodsService.ViewGoodsByPriceAsc();
        goods.removeIf(item -> "已下架".equals(item.getGoodsstate()));
        List<HashMap<String, Object>> list = new ArrayList<>();
        for(Goods good:goods){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",good.getId());
            map.put("goodsname",good.getGoodsname());
            map.put("goodscode",good.getGoodscode());
            map.put("goodsweight",good.getGoodsweight());
            map.put("goodsprice",good.getGoodsprice());
            map.put("goodsinfo",good.getGoodsinfo());
            map.put("goodsstate",good.getGoodsstate());
            map.put("goodsimage",goodsimageService.getImagePath(good.getId()));
            list.add(map);
        }
        return list;
    }

    @GetMapping("/sortDesc")
    public Object SortGoodsDesc() {
        List<Goods> goods =  goodsService.ViewGoodsByPriceDesc();
        goods.removeIf(item -> "已下架".equals(item.getGoodsstate()));
        List<HashMap<String, Object>> list = new ArrayList<>();
        for(Goods good:goods){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",good.getId());
            map.put("goodsname",good.getGoodsname());
            map.put("goodscode",good.getGoodscode());
            map.put("goodsweight",good.getGoodsweight());
            map.put("goodsprice",good.getGoodsprice());
            map.put("goodsinfo",good.getGoodsinfo());
            map.put("goodsstate",good.getGoodsstate());
            map.put("goodsimage",goodsimageService.getImagePath(good.getId()));
            list.add(map);
        }
        return list;
    }

    @PostMapping("/shaixuan")
    public Object ShaiXuan(PriceBody priceBody) {
        List<Goods> goods = goodsService.ViewGoodsByPrice(priceBody);
        goods.removeIf(item -> "已下架".equals(item.getGoodsstate()));
        List<HashMap<String, Object>> list = new ArrayList<>();
        for(Goods good:goods){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",good.getId());
            map.put("goodsname",good.getGoodsname());
            map.put("goodscode",good.getGoodscode());
            map.put("goodsweight",good.getGoodsweight());
            map.put("goodsprice",good.getGoodsprice());
            map.put("goodsinfo",good.getGoodsinfo());
            map.put("goodsstate",good.getGoodsstate());
            map.put("goodsimage",goodsimageService.getImagePath(good.getId()));
            list.add(map);
        }
        return list;
    }

    @GetMapping("/views")
    public Object ViewGoods2() {
        List<Goods> goods = goodsService.ViewGoods();
        goods.removeIf(item -> "已下架".equals(item.getGoodsstate()));
        List<HashMap<String, Object>> list = new ArrayList<>();
        for(Goods good:goods){
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",good.getId());
            map.put("goodsname",good.getGoodsname());
            map.put("goodscode",good.getGoodscode());
            map.put("goodsweight",good.getGoodsweight());
            map.put("goodsprice",good.getGoodsprice());
            map.put("goodsinfo",good.getGoodsinfo());
            map.put("goodsstate",good.getGoodsstate());
            map.put("goodsimage",goodsimageService.getImagePath(good.getId()));
            list.add(map);
        }
        return list;
    }
}
