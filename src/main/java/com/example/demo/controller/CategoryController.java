package com.example.demo.controller;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Page;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/category")
    public String showCategory(@RequestParam(value = "page") int currentPage, Model model) {
        Page page = categoryService.searchCategory(currentPage);

        model.addAttribute("page", page);
        return "category-list";
    }

    /**
     * 使用单独的方法连接两个ftl，必要时可能会传参数进来
     * @return
     */
    @RequestMapping("/category/toCategoryAdd")
    public String showCategoryAdd(Category category) {

        return "category-add";
    }

    @RequestMapping("/category/add")
    public String add(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category-add";
        }
        boolean addCategory = categoryService.addCategory(category);
        return "category-add";
    }

    /**
     * 使用url向controller传递参数c_id，使用@RequestParam
     * @param c_id
     * @param model
     * @return
     */
    @RequestMapping("/category/toCategoryUpdate")
    public String preUpdate(@RequestParam(value = "c_id") int c_id, Model model, Category category) {

        Category category1 = categoryService.preUpdate(c_id);
        model.addAttribute("category", category1);

        return "category-update";
    }

    /**
     * 优化参数传递，包装成一个bean对象
     */
    @PostMapping(value = "/category/update")
    public String update(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category-update";
        }
        boolean updateCategory = categoryService.updateCategory(category);

        return "redirect:/category?page=1";
    }

    @RequestMapping("/category/delete")
    public String delete(@RequestParam(value = "c_id") int c_id) {

        boolean deleteCategory = categoryService.deleteCategory(c_id);

        return "redirect:/category?page=1";
    }

    /**
     * 可以通过专门的页面跳转方法来跳转到指定页面
     */
//    @RequestMapping("/{page}")
//    public String showPage(@PathVariable String page) {
//        return page;
//    }
}
