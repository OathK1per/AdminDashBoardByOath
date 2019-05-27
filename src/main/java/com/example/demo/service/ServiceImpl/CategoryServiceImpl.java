package com.example.demo.service.ServiceImpl;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Page;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean addCategory(Category category) {

        Category category1 = categoryRepository.save(category);
        if (category1 != null) {
            return true;
        }
        return false;
    }

    @Override
    public Page searchCategory(int currentPage) {

        Page page = new Page();
        int totalCount = (int)categoryRepository.count();
        int totalPage = (int) Math.ceil(1.0 * totalCount / page.getCURRENT_COUNT());
        int start = (currentPage - 1) * page.getCURRENT_COUNT();
        int end = Math.min(currentPage * page.getCURRENT_COUNT(), totalCount);
        List<Category> list = categoryRepository.findAllByPage(start, end);

        page.setCurrentPage(currentPage);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        page.setCategoryList(list);
        return page;
    }

    @Override
    public Category preUpdate(int c_id) {

        Category category = categoryRepository.findByC_id(c_id);
        return category;
    }

    @Override
    public boolean updateCategory(Category category) {

        Category category1 = categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean deleteCategory(int c_id) {

        categoryRepository.deleteById(c_id);
        return true;
    }
}
