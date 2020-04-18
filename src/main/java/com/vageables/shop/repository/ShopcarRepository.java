package com.vageables.shop.repository;

import com.vageables.shop.entity.Shopcar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : hello
 * @date : 2020/4/8 14:22
 * @description : --ShopcarRepository类描述--
 */

@Repository
public interface ShopcarRepository extends JpaRepository<Shopcar, Integer> {
    List<Shopcar> findAllByUserid(Integer userid);
}
