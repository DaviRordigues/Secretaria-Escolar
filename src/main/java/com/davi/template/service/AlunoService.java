package com.davi.template.service;

import com.davi.template.entity.Aluno;

import java.util.List;
import java.util.Optional;

public interface AlunoService {
    Optional<Aluno> buscarAlunoPorId(Long id);
    List<Aluno> getAllAlunos();
    Aluno getAlunoById(Long id);
    Aluno createAluno(Aluno aluno, Long turmaId);
    Aluno updateAluno(Long id, Aluno alunoDetails);
    boolean deleteAluno(Long id);
}
