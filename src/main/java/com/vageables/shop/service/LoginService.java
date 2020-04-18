package com.vageables.shop.service;

import com.vageables.shop.requestBody.LoginBody;

/**
 * @author : hello
 * @date : 2020/4/8 12:28
 * @description : --LoginService类描述--
 */

public interface LoginService {
    //登录
    Object Login(LoginBody loginBody);
    //退出
    Object Logout(LoginBody loginBody);
}
