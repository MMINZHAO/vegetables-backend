package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Goodsimage;
import com.vageables.shop.repository.GoodsimageRepository;
import com.vageables.shop.service.GoodsimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 14:20
 * @description : --GoodsimageServiceImpl类描述--
 */

@Service
public class GoodsimageServiceImpl implements GoodsimageService {
    @Autowired
    private GoodsimageRepository goodsimageRepository;

    @Override
    public Object AddGoodsimage(Goodsimage goodsimage) {
        return goodsimageRepository.save(goodsimage);
    }

    @Override
    public void DeleteGoodsimage(Goodsimage goodsimage) {
        goodsimageRepository.deleteById(goodsimage.getId());
    }

    @Override
    public String getImagePath(Integer goodsID) {
        List<Goodsimage> list = goodsimageRepository.findAllByGoodsid(goodsID);
        return list.size()>0?list.get(0).getImagepath():"";
    }

    @Override
    public void deleteImageBygood(Integer goodid) {
        goodsimageRepository.deleteAllByGood(goodid);
    }
}
