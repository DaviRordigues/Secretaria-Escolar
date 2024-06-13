package com.davi.template.entity;

import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String matricula;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    // Construtores, getters e setters

    public Aluno() {
        // Construtor vazio necessário para o JPA
    }

    public Aluno(String nome, String cpf, String matricula, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.idade = idade;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Turma getTurma() { // Método getTurma corrigido
        return turma;
    }

    public void setTurma(Turma turma) { // Método setTurma corrigido
        this.turma = turma;
    }
}
