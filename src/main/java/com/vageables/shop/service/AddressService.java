package com.vageables.shop.service;

import com.vageables.shop.entity.Address;
import com.vageables.shop.entity.Userinfo;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 12:29
 * @description : --AddressService类描述--
 */

public interface AddressService {
    //添加地址
    Object AddAddress(Address address);

    //删除地址
    void DeleteAddress(Address address);

    //编辑地址
    Object EditAddress(Address address);

    //查看地址
    List<Address> ViewAddress(Userinfo userinfo);
}
