package com.vageables.shop.repository;

import com.vageables.shop.entity.Userinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 13:08
 * @description : --UserinfoRepository类描述--
 */

@Repository
public interface UserinfoRepository extends JpaRepository<Userinfo, Integer> {
    //登录用
    List<Userinfo> findAllByUsernameAndPasswordAndUsertype(String username, String password, String usertype);
}
