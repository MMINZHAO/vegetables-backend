package com.vageables.shop.serviceImpl;

import com.vageables.shop.entity.Category;
import com.vageables.shop.repository.CategoryRepository;
import com.vageables.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hello
 * @date : 2020/4/8 13:21
 * @description : --CategoryServiceImpl类描述--
 */

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Object AddCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void DeleteCategory(Category category) {
        categoryRepository.deleteById(category.getId());
    }
}
