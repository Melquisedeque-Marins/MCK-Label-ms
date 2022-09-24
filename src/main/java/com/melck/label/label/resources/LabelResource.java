package com.melck.label.label.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.melck.label.label.entities.Label;
import com.melck.label.label.services.LabelService;

@RestController
@RequestMapping("/labels")
public class LabelResource {

    @Autowired
    private LabelService service;

    @PostMapping
    public ResponseEntity<Label> insert(@RequestBody Label label){
        Label newLabel = service.insert(label);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newLabel.getLabelId()).toUri();
        return ResponseEntity.created(uri).body(newLabel);

    }

    @GetMapping("/{labelId}")
    public ResponseEntity<Label> findById(@PathVariable Long labelId){
        Label label = service.findById(labelId);
        return ResponseEntity.ok().body(label);
    }
    
    @GetMapping
    public ResponseEntity<List<Label>> findAll(){
        List<Label> labels = service.findAll();
        return ResponseEntity.ok().body(labels);
    }

    @DeleteMapping("/{labelId}")
    public ResponseEntity<Label> delete (@PathVariable Long labelId){
        service.delete(labelId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{labelId}")
    public ResponseEntity<Label> update(@PathVariable Long labelId, @RequestBody Label label){
        Label updatedLabel = service.update(labelId, label);
        return ResponseEntity.ok().body(updatedLabel);
    }

    
}
