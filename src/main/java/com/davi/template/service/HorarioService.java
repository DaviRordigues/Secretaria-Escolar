package com.davi.template.service;

import com.davi.template.entity.Horario;

import java.util.List;

public interface HorarioService {
    List<Horario> getAllHorarios();
    Horario getHorarioById(Long id);
    Horario createHorario(Horario horario);
    Horario updateHorario(Long id, Horario horarioDetails);
    boolean deleteHorario(Long id);
}
