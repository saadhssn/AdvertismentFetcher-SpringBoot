package com.qavi.advertisementfetcher.advertisement.services;

import com.qavi.advertisementfetcher.advertisement.entities.Category;
import com.qavi.advertisementfetcher.advertisement.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //Get All Categories
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll().stream().collect(Collectors.toList());
        return categories;
    }

    //Get One Category
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    //Post Category
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    //update Category
    public Category updateCategory(Category category, Long id) {
        Category existingAD = categoryRepository.findById(id).get();
        if (existingAD != null) {
            existingAD.setName( category.getName());
            return categoryRepository.save(existingAD);
        } else {
            return null;
        }
    }

    //Delete Category
    public Boolean deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
