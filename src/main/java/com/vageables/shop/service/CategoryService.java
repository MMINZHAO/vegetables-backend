package com.vageables.shop.service;

import com.vageables.shop.entity.Category;

/**
 * @author : hello
 * @date : 2020/4/8 13:20
 * @description : --CategoryService类描述--
 */

public interface CategoryService {
    Object AddCategory(Category category);

    void DeleteCategory(Category category);
}
