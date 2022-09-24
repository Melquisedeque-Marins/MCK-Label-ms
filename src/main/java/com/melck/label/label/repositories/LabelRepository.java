package com.melck.label.label.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.melck.label.label.entities.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long>{
    
}
