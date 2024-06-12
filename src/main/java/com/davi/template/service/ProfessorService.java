package com.davi.template.service;

import com.davi.template.entity.Professor;

import java.util.List;

public interface ProfessorService {
    List<Professor> getAllProfessores();
    Professor getProfessorById(Long id);
    Professor createProfessor(Professor professor);
    Professor updateProfessor(Long id, Professor professorDetails);
    boolean deleteProfessor(Long id);
}
