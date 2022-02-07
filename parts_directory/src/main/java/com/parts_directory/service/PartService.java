package com.parts_directory.service;

import com.parts_directory.entity.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();
    Part findById(int partId);
    void saveOrUpdate(Part thePart);
    void deleteById(int partId);
}
