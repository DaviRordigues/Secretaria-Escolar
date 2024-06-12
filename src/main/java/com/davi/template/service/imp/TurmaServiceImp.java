package com.davi.template.service.imp;

import com.davi.template.entity.Turma;
import com.davi.template.repositorio.TurmaRepository;
import com.davi.template.service.TurmaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurmaServiceImp implements TurmaService {

    private final TurmaRepository turmaRepository;

    @Override
    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma getTurmaById(Long id) {
        return turmaRepository.findById(id).orElse(null);
    }

    @Override
    public Turma createTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma updateTurma(Long id, Turma turmaDetails) {
        Turma existingTurma = turmaRepository.findById(id).orElse(null);
        if (existingTurma == null) {
            return null;
        }
        existingTurma.setSala(turmaDetails.getSala());
        existingTurma.setHorario(turmaDetails.getHorario());
        existingTurma.setUc(turmaDetails.getUc());
        return turmaRepository.save(existingTurma);
    }

    @Override
    public boolean deleteTurma(Long id) {
        if (!turmaRepository.existsById(id)) {
            return false;
        }
        turmaRepository.deleteById(id);
        return true;
    }
}
