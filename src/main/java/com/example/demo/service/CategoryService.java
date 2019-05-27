package com.example.demo.service;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Page;

public interface CategoryService {

    Category preUpdate(int c_id);

    boolean updateCategory(Category category);

    boolean deleteCategory(int c_id);

    boolean addCategory(Category category);

    Page searchCategory(int currentPage);
}
