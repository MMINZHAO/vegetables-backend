package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Userinfo;
import com.vageables.shop.repository.UserinfoRepository;
import com.vageables.shop.requestBody.LoginBody;
import com.vageables.shop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : hello
 * @date : 2020/4/8 12:47
 * @description : --LoginServiceImpl类描述--
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserinfoRepository userinfoRepository;

    @Override
    public Object Login(LoginBody loginBody) {
        List<Userinfo> userinfos = userinfoRepository.findAllByUsernameAndPasswordAndUsertype(loginBody.getUsername(), loginBody.getPassword(), loginBody.getUsertype());
        Map<String, Object> map = new HashMap<>();
        if (userinfos.size() > 0) {
            map.put("state", "success");
            map.put("data", userinfos.get(0));
        }else {
            map.put("state","failed");
            map.put("data", "用户名或密码错误！");
        }
        return map;
    }

    @Override
    public Object Logout(LoginBody loginBody) {
        return null;
    }
}
