package com.recipeorganizer.dao;

import com.recipeorganizer.model.Ingredients;
import com.recipeorganizer.model.Instructions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInstructionsDao implements InstructionsDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcInstructionsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Instructions> findAllByRecipeId(int recipId) {
        List<Instructions> instructions = new ArrayList<>();
        String sql = "SELECT *\n" +
                "\tFROM public.instructions\n" +
                "\tWHERE recipe_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recipId);

        while (result.next()) {
            Instructions instruction = mapRowToInstructions(result);
            instructions.add(instruction);
        }
        return instructions;
    }

    @Override
    public Instructions getInstructionsById(int instructionId) {
        Instructions instruction = new Instructions();
        String sql = "SELECT *\n" +
                  "\tFROM public.instructions\n" +
                  "\tWHERE instruction_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, instructionId);
        if (result.next()) {
               instruction = mapRowToInstructions(result);
           }
        return instruction;
    }

    @Override
    public Instructions updateInstructions(Instructions instruction) {
        String sql = "UPDATE instructions " +
                "SET instruction = ?, instruction_number = ? " +
                "WHERE instruction_id = ?;";
        jdbcTemplate.update(sql, instruction.getInstruction(), instruction.getInstructionNumber(), instruction.getInstructionId());
        return instruction;
    }

    @Override
    public Instructions createInstruction(Instructions newInstruction) {
        String sql = "INSERT INTO instructions (recipe_id, instruction, instruction_number) " +
                "VALUES (?, ?, ?) RETURNING instruction_id; ";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                newInstruction.getRecipeId(), newInstruction.getInstruction(), newInstruction.getInstructionNumber());
        return getInstructionsById(newId);
    }


    private Instructions mapRowToInstructions(SqlRowSet rs) {
        Instructions instructions = new Instructions();
        instructions.setInstructionId(rs.getInt("instruction_id"));
        instructions.setRecipeId(rs.getInt("recipe_id"));
        instructions.setInstruction(rs.getString("instruction"));
        instructions.setInstructionNumber(rs.getInt("instruction_number"));
        return instructions;
    }
}
