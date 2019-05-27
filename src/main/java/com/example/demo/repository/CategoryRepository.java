package com.example.demo.repository;

import com.example.demo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "from Category where c_id = ?1")
    Category findByC_id(Integer c_id);

    @Query(value = "select * from Category ", nativeQuery = true)
    List<Category> findAll();

    @Query(value = "select * from Category limit ?,?", nativeQuery = true)
    List<Category> findAllByPage(int start, int end);
}
