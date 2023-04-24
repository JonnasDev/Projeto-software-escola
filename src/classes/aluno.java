/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Laboratorio EEQS 03
 */
public class aluno {
    private String matricula;
    private String dnasc;
    private String cpf;
    private String turma;
    private String nome;

    public aluno() {
    }

    public aluno(String matricula, String dnasc, String cpf) {
        this.matricula = matricula;
        this.dnasc = dnasc;
        this.cpf = cpf;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the turma
     */
    public String getdnasc() {
        return getDnasc();
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(String dnasc) {
        this.setDnasc(dnasc);
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dnasc
     */
    public String getDnasc() {
        return dnasc;
    }

    /**
     * @param dnasc the dnasc to set
     */
    public void setDnasc(String dnasc) {
        this.dnasc = dnasc;
    }

    /**
     * @return the turma
     */
    public String getTurma() {
        return turma;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
