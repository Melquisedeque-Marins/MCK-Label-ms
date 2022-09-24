package com.melck.label.label.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.melck.label.label.entities.Label;
import com.melck.label.label.repositories.LabelRepository;
import com.melck.label.label.services.exceptions.IntegrityViolation;
import com.melck.label.label.services.exceptions.ResourceNotFoundException;

@Service
public class LabelService {

    @Autowired
    private LabelRepository repository;

    @Transactional
    public Label insert(Label label) {
        return repository.save(label);
    }

    @Transactional
    public List<Label> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Label findById(Long labelId) {
        return repository.findById(labelId)
                .orElseThrow(() -> new ResourceNotFoundException("Label with id: " + labelId + " must be founded"));
    }

    public void delete(Long labelId) {
        Label label = findById(labelId);
        try {
            repository.delete(label);
        } catch (DataIntegrityViolationException e) {
            throw new IntegrityViolation("the entity with id: " + label.getLabelId() + " cannot be deleted");
        }
    }

    @Transactional
    public Label update(Long labelId, Label label) {
        Label actualLabel = findById(labelId);
        actualLabel.setCode(label.getCode());
        actualLabel.setDescription(label.getDescription());
        return repository.save(actualLabel);
    }
    
}
