package com.davi.template.service.imp;

import com.davi.template.entity.Horario;
import com.davi.template.repositorio.HorarioRepository;
import com.davi.template.service.HorarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HorarioServiceImp implements HorarioService {

    private final HorarioRepository horarioRepository;

    @Override
    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario getHorarioById(Long id) {
        return horarioRepository.findById(id).orElse(null);
    }

    @Override
    public Horario createHorario(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public Horario updateHorario(Long id, Horario horarioDetails) {
        Horario existingHorario = horarioRepository.findById(id).orElse(null);
        if (existingHorario == null) {
            return null;
        }
        existingHorario.setDiaSemana(horarioDetails.getDiaSemana());
        existingHorario.setHorarioInicio(horarioDetails.getHorarioInicio());
        existingHorario.setHorarioTermino(horarioDetails.getHorarioTermino());
        return horarioRepository.save(existingHorario);
    }

    @Override
    public boolean deleteHorario(Long id) {
        if (!horarioRepository.existsById(id)) {
            return false;
        }
        horarioRepository.deleteById(id);
        return true;
    }
}
