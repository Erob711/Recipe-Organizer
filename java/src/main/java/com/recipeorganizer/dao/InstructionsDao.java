package com.recipeorganizer.dao;

import com.recipeorganizer.model.Ingredients;
import com.recipeorganizer.model.Instructions;

import java.util.List;

public interface InstructionsDao {
    List<Instructions> findAllByRecipeId(int recipeId);

    Instructions getInstructionsById(int instructionId);

    Instructions updateInstructions(Instructions instruction);

    Instructions createInstruction(Instructions newInstruction);
}
