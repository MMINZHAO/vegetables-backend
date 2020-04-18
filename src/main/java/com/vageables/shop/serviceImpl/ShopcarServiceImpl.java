package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Shopcar;
import com.vageables.shop.repository.ShopcarRepository;
import com.vageables.shop.service.ShopcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 14:26
 * @description : --ShopcarServiceImpl类描述--
 */

@Service
public class ShopcarServiceImpl implements ShopcarService {
    @Autowired
    private ShopcarRepository shopcarRepository;

    @Override
    public Object Addshopcar(Shopcar shopcar) {
        return shopcarRepository.save(shopcar);
    }

    @Override
    public void DeleteShopcar(Integer id) {
        shopcarRepository.deleteById(id);
    }

    @Override
    public void BatchDeleteShopcar(List<Integer> ids) {
        ids.forEach(id -> shopcarRepository.deleteById(id));
    }

    @Override
    public List<Shopcar> ViewByUserID(Integer userid) {
        return shopcarRepository.findAllByUserid(userid);
    }
}
