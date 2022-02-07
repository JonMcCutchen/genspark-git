package com.parts_directory.service;

import com.parts_directory.dao.PartDAO;
import com.parts_directory.entity.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceIMPL implements PartService {
    private final PartDAO partDAO;

    @Autowired
    public PartServiceIMPL(PartDAO employeeDAO) {
        this.partDAO = employeeDAO;
    }


    @Override
    public List<Part> findAll() {
        return partDAO.findAll();
    }

    @Override
    public Part findById(int partId) {
        return partDAO.findById(partId);
    }

    @Override
    public void saveOrUpdate(Part thePart) {
        partDAO.saveOrUpdate(thePart);
    }

    @Override
    public void deleteById(int partId) { partDAO.deleteById(partId);
    }


}
