package com.vageables.shop.controller;

import com.vageables.shop.config.ControllerAutowiredService;
import com.vageables.shop.entity.Goods;
import com.vageables.shop.entity.Goodsimage;
import com.vageables.shop.entity.imageUp;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author : @author
 * @date : 2020/4/8 14:47
 * @description : --GoodsimageController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("image")
public class GoodsimageController extends ControllerAutowiredService {

    @PostMapping("/upload")
    public Object UploadImage(imageUp imageUp) throws Exception {
        MultipartFile file = imageUp.getFile();
        String suffix = imageUp.getName().substring(imageUp.getName().indexOf("."));
        String id = UUID.randomUUID().toString();
        String fileName = id + suffix;
        String path = "D:/image/" +fileName;
        File newFile = new File(path);
        file.transferTo(newFile);
        List<Goods> list = goodsService.getMaxID();
        int goodID = 1;
        if (list.size() > 0) {
            goodID = list.get(0).getId() + 1;
        }
        Goodsimage image = new Goodsimage();
        image.setGoodsid(goodID);
        image.setImagepath("http://localhost:8700/image/" + fileName);
        return goodsimageService.AddGoodsimage(image);
    }

    @PostMapping("/upload2")
    public Object UploadHeadImage(imageUp imageUp) throws Exception {
        MultipartFile file = imageUp.getFile();
        String suffix = imageUp.getName().substring(imageUp.getName().indexOf("."));
        String id = UUID.randomUUID().toString();
        String fileName = id + suffix;
        String path = "D:/image/" +fileName;
        File newFile = new File(path);
        file.transferTo(newFile);
        Map<String, String> map = new HashMap<>();
        map.put("imagepath", "http://localhost:8700/image/" + fileName);
        return map;
    }

}
