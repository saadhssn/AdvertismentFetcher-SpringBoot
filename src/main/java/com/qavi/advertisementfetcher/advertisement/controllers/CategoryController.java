package com.qavi.advertisementfetcher.advertisement.controllers;

import com.qavi.advertisementfetcher.advertisement.entities.Advertisement;
import com.qavi.advertisementfetcher.advertisement.entities.Category;
import com.qavi.advertisementfetcher.advertisement.services.AdvertisementService;
import com.qavi.advertisementfetcher.advertisement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    //Get all advertisements
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    //Get advertisement by id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getAdvertisement(@PathVariable Long id) {
        Category category = categoryService.getCategory(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    //Post category
    @PostMapping("/add-category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    //update Controller.
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable long id) {
        categoryService.updateCategory(category, id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    // Delete Advertisement
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Long id) {
        Boolean deletedCategory = categoryService.deleteCategory(id);
        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
    }
}
