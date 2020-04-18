package com.vageables.shop.controller;

import com.vageables.shop.config.ControllerAutowiredService;
import com.vageables.shop.entity.*;
import com.vageables.shop.requestBody.AddOrder;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : @author
 * @date : 2020/4/8 14:47
 * @description : --ConfirmorderController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("order")
public class ConfirmorderController extends ControllerAutowiredService {

    @GetMapping("/view")
    public Object ViewOrder() {
        List<Object> list = new ArrayList<>();
        List<Confirmorder> confirmorders = confirmorderService.ViewConfirmorders();
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        for(Confirmorder confirmorder : confirmorders){
            Map<String , Object> map = new HashMap<>();
            map.put("id", confirmorder.getId());
            map.put("ordernum", confirmorder.getOrdernum());
            Userinfo userinfo = userinfoRepository.findById(confirmorder.getUserid()).get();
            map.put("username",userinfo.getUsername());
            Address address = addressRepository.findById(confirmorder.getAddressid()).get();
            map.put("address",address.getProvince()+address.getCity()+address.getCounty()+address.getDetail());
            map.put("totalprice",confirmorder.getTotalprice());
            map.put("paystate",confirmorder.getPaystate());
            if(null!=confirmorder.getPaytime()) {
                map.put("paytime", df.format(confirmorder.getPaytime()));
            }
            list.add(map);
        }
        return list;
    }

    @PostMapping("/customView")
    public Object CustomView(Userinfo userinfo) {
        Userinfo user= userinfoRepository.findById(userinfo.getId()).get();
        List<Object> list = new ArrayList<>();
        List<Confirmorder> confirmorders = confirmorderService.ViewConfirmorders(user);
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        for(Confirmorder confirmorder : confirmorders){
            Map<String , Object> map = new HashMap<>();
            map.put("id", confirmorder.getId());
            map.put("ordernum", confirmorder.getOrdernum());
            Address address = addressRepository.findById(confirmorder.getAddressid()).get();
            map.put("username",address.getConsignee());//收货人
            map.put("address",address.getProvince()+address.getCity()+address.getCounty()+address.getDetail());
            map.put("totalprice",confirmorder.getTotalprice());
            map.put("paystate",confirmorder.getPaystate());
            if(null!=confirmorder.getPaytime()) {
                map.put("paytime", df.format(confirmorder.getPaytime()));
            }
            List<Shoporder> shoporders = shoporderService.ViewByOrderid(confirmorder.getId());
            map.put("shoporders", shoporders);
            list.add(map);
        }
        return list;
    }

    @PostMapping("/save") //编辑保存支付调用
    public Object SaveOrder(Confirmorder confirmorder) {
        Confirmorder order = confirmorderRepository.findById(confirmorder.getId()).get();
        if("已支付".equals(order.getPaystate()) || !"已支付".equals(confirmorder.getPaystate())){
            order.setPaytime(null);
        }
        order.setPaystate(confirmorder.getPaystate());
        return confirmorderService.AddConfirmorder(order);
    }

    @PostMapping("/confirm") //编辑保存支付调用
    public Object ConfirmOrder(Confirmorder confirmorder) {
        Confirmorder order = confirmorderRepository.findById(confirmorder.getId()).get();
        Date date = new Date();
        order.setPaytime(date);
        order.setPaystate("已支付");
        return confirmorderService.AddConfirmorder(order);
    }

    @PostMapping("/cancel") //编辑保存支付调用
    public Object CancelOrder(Confirmorder confirmorder) {
        Confirmorder order = confirmorderRepository.findById(confirmorder.getId()).get();
        order.setPaytime(null);
        order.setPaystate("已取消");
        return confirmorderService.AddConfirmorder(order);
    }

    @PostMapping("/add") //结算用
    public Object AddOrder(AddOrder order) {
        Confirmorder confirmorder = new Confirmorder();
        int id = 1;
        List<Confirmorder> confirmorders = confirmorderService.getMaxID();
        if(confirmorders.size()>0){
            id = confirmorders.get(0).getId()+1;
        }
        confirmorder.setId(id);
        int userId = order.getUserId();
        int addressId = order.getAddressId();
        confirmorder.setUserid(userId);
        confirmorder.setAddressid(addressId);
        confirmorder.setPaystate("待支付");
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String ordernum = df.format(date);
        confirmorder.setOrdernum(ordernum);
        //confirmorder.setPaytime(date);
        BigDecimal totalPrice = new BigDecimal("0");
        List<Integer> ids = order.getShopcars();
        List<Shopcar> shopcars = shopcarRepository.findAllById(ids);
        for(Shopcar shopcar : shopcars){
            Shoporder shoporder = new Shoporder();
            shoporder.setUserid(userId);
            shoporder.setOrderid(id);
            shoporder.setGoodsid(shopcar.getGoodsid());
            shoporder.setGoodscount(shopcar.getGoodscount());
            shoporder.setGoodsamount(shoporder.getGoodsamount());
            Goods goods = new Goods();
            if(goodsRepository.findById(shopcar.getGoodsid()).isPresent()){
               goods = goodsRepository.findById(shopcar.getGoodsid()).get();
            }
            shoporder.setGoodsprice(goods.getGoodsprice());
            shoporderService.AddShoporder(shoporder);
            //从购物车移动到shoporder
            shopcarService.DeleteShopcar(shopcar.getId());
            totalPrice = totalPrice.add(shopcar.getGoodsamount());
        }
        confirmorder.setTotalprice(totalPrice);
        return confirmorderService.AddConfirmorder(confirmorder);
    }
}
