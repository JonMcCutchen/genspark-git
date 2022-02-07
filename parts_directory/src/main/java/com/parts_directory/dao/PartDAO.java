package com.parts_directory.dao;

import com.parts_directory.entity.Part;

import java.util.List;

public interface PartDAO {
    List<Part> findAll();
    Part findById(int theId);
    void saveOrUpdate(Part thePart);
    void deleteById(int theId);
}
