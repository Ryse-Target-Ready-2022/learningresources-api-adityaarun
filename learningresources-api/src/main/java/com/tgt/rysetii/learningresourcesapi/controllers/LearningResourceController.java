package com.tgt.rysetii.learningresourcesapi.controllers;


import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LearningResourceController {

    private final LearningResourceService learningResourceService;

    public LearningResourceController(LearningResourceService learningResourceService){
        this.learningResourceService=learningResourceService;
    }

    @GetMapping(path="/learningresources")
    public List<LearningResource> getAllLearningResources(){
        return learningResourceService.getLearningResources();
    }

    @GetMapping("/learningresources/{id}")
    LearningResource getLearningResourceById(@PathVariable Integer id){
        return learningResourceService.getLearningResourceById(id);
    }

    @PostMapping(value = "/learningresources")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLearningResources(@RequestBody List<LearningResource> learningResources){
        learningResourceService.saveLearningResources(learningResources);
    }


    @DeleteMapping("/learningresources/{id}")
    public void deleteResource(@PathVariable Integer id){
        learningResourceService.deleteLearningResourceById(id);
    }
}
