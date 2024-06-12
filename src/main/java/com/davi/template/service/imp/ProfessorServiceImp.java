package com.davi.template.service.imp;

import com.davi.template.entity.Professor;
import com.davi.template.repositorio.ProfessorRepository;
import com.davi.template.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorServiceImp implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @Override
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor updateProfessor(Long id, Professor professorDetails) {
        Professor existingProfessor = professorRepository.findById(id).orElse(null);
        if (existingProfessor == null) {
            return null;
        }
        existingProfessor.setNome(professorDetails.getNome());
        existingProfessor.setMatricula(professorDetails.getMatricula());
        existingProfessor.setCpf(professorDetails.getCpf());
        existingProfessor.setUc(professorDetails.getUc());
        return professorRepository.save(existingProfessor);
    }

    @Override
    public boolean deleteProfessor(Long id) {
        if (!professorRepository.existsById(id)) {
            return false;
        }
        professorRepository.deleteById(id);
        return true;
    }
}
