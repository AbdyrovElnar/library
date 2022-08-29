package com.example.library.service.impl;

import com.example.library.dto.CategoryDTO;
import com.example.library.repository.CategoryRepository;
import com.example.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryDTO::from).collect(Collectors.toList());
    }
}
