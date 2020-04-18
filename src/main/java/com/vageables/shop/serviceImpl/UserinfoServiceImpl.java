package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Userinfo;
import com.vageables.shop.repository.UserinfoRepository;
import com.vageables.shop.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hello
 * @date : 2020/4/8 13:18
 * @description : --UserinfoServiceImpl类描述--
 */

@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoRepository userinfoRepository;
    @Override
    public Object AddUser(Userinfo userinfo) {
        return userinfoRepository.save(userinfo);
    }

    @Override
    public void DeleteUser(Userinfo userinfo) {
        userinfoRepository.deleteById(userinfo.getId());
    }
}
