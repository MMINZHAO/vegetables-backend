package com.vageables.shop.service;

import com.vageables.shop.entity.Userinfo;

/**
 * @author : hello
 * @date : 2020/4/8 12:30
 * @description : --UserinfoService类描述--
 */

public interface UserinfoService {
    //注册
    Object AddUser(Userinfo userinfo);
    //删除
    void DeleteUser(Userinfo userinfo);
    //
}
