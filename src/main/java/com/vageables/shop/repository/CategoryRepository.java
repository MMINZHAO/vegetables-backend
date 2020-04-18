package com.vageables.shop.repository;

import com.vageables.shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : hello
 * @date : 2020/4/8 13:20
 * @description : --Category类描述--
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
