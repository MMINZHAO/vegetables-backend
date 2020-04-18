package com.vageables.shop.controller;

import com.vageables.shop.config.ControllerAutowiredService;
import com.vageables.shop.entity.Userinfo;
import com.vageables.shop.requestBody.LoginBody;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : @author
 * @date : 2020/4/8 14:48
 * @description : --LoginController类描述--
 */

@CrossOrigin
@RestController
@RequestMapping("login")
public class LoginController extends ControllerAutowiredService {

    @PostMapping("/login")
    public Object Login(LoginBody loginBody) {
        return loginService.Login(loginBody);
    }
}
