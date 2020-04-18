package com.vageables.shop.controller;

import com.vageables.shop.config.ControllerAutowiredService;
import com.vageables.shop.entity.Address;
import com.vageables.shop.entity.Userinfo;
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
 * @date : 2020/4/8 14:46
 * @description : --AddressController类描述--
 */
@CrossOrigin
@RestController
@RequestMapping("address")
public class AddressController extends ControllerAutowiredService {
    //添加地址
    @PostMapping("/add")
    public Object AddAddress(Address address){
        return addressService.AddAddress(address);
    }

    //删除地址
    @PostMapping("/delete")
    public void DeleteAddress(Address address){
        addressService.DeleteAddress(address);
    }

    //编辑地址
    @PostMapping("/edit")
    public Object EditAddress(Address address){
        return addressService.EditAddress(address);
    }

    //查看地址
    @PostMapping("/view")
    public List<Address> ViewAddress(Userinfo userinfo){
        return addressService.ViewAddress(userinfo);
    }

    //购物车获取地址列表
    @PostMapping("/view2")
    public Object ViewAddress2(Userinfo userinfo){
        List<Address> addresses = addressService.ViewAddress(userinfo);
        List<Object> list = new ArrayList<>();
        addresses.forEach(address -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", address.getId());
            map.put("value", "收货人:"+address.getConsignee()+"  电话:"+address.getTelphone()+"地址:" +address.getProvince()+
                    address.getCity()+address.getCounty()+address.getDetail());
            list.add(map);
        });
        return list;
    }
}