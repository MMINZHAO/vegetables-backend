package com.vageables.shop.controller;

import com.vageables.shop.config.ControllerAutowiredService;
import com.vageables.shop.entity.Userinfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : @author
 * @date : 2020/4/8 14:48
 * @description : --UserinfoController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("userInfo")
public class UserinfoController extends ControllerAutowiredService {
    @PostMapping("/add")
    public Object AddUser(Userinfo userinfo) {
        return userinfoService.AddUser(userinfo);
    }
}
