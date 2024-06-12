package com.davi.template.service.imp;

import com.davi.template.entity.Aluno;
import com.davi.template.repositorio.AlunoRepository;
import com.davi.template.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }

    @Override
    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno updateAluno(Long id, Aluno alunoDetails) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setNome(alunoDetails.getNome());
            aluno.setCpf(alunoDetails.getCpf());
            aluno.setMatricula(alunoDetails.getMatricula());
            aluno.setIdade(alunoDetails.getIdade());
            return alunoRepository.save(aluno);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAluno(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
