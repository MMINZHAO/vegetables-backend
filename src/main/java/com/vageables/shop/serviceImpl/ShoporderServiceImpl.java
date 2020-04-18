package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Confirmorder;
import com.vageables.shop.entity.Shoporder;
import com.vageables.shop.repository.ShoporderRepository;
import com.vageables.shop.service.ShoporderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 14:38
 * @description : --ShoporderServiceImpl类描述--
 */

@Service
public class ShoporderServiceImpl implements ShoporderService {
    @Autowired
    private ShoporderRepository shoporderRepository;
    @Override
    public Object AddShoporder(Shoporder shoporder) {
        return shoporderRepository.save(shoporder);
    }

    @Override
    public void DeleteShoporder(Integer id) {
        shoporderRepository.deleteById(id);
    }

    @Override
    public List<Shoporder> ViewByOrderid(Integer id) {
        return shoporderRepository.findAllByOrderid(id);
    }

    @Override
    public void BatchDeleteShoporder(List<Integer> ids) {
        ids.forEach(id -> shoporderRepository.deleteById(id));
    }
}
