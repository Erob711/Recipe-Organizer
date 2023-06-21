package com.recipeorganizer.controller;


import com.recipeorganizer.dao.InstructionsDao;
import com.recipeorganizer.model.Instructions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//maps to the ingredients of each individual recipe by recipeId
@RequestMapping(path = "/recipes/{recipeId}/instructions")
@CrossOrigin
public class InstructionsController {

    private final InstructionsDao instructionsDao;

    public InstructionsController(InstructionsDao instructionsDao) {
        this.instructionsDao = instructionsDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/all", method = RequestMethod.GET)
    public List<Instructions> findAllByRecipeId(@PathVariable("recipeId") int recipeId) {
        List<Instructions> instructions = instructionsDao.findAllByRecipeId(recipeId);
        return instructions;
    }
}
