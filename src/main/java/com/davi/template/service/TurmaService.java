package com.davi.template.service;

import com.davi.template.entity.Turma;

import java.util.List;

public interface TurmaService {
    List<Turma> getAllTurmas();
    Turma getTurmaById(Long id);
    Turma createTurma(Turma turma);
    Turma updateTurma(Long id, Turma turmaDetails);
    boolean deleteTurma(Long id);
}
