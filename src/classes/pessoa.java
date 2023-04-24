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
public class pessoa {
    
    
    private String cpf;
    private String nome;
    private String dnasc;
    private String login;
    private String senha;
    private int genero;

    public pessoa() {
    }

    public pessoa(String cpf, String nome, String dnasc, String login, String senha, int genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.dnasc = dnasc;
        this.login = login;
        this.senha = senha;
        this.genero = genero;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the genero
     */
    public int getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(int genero) {
        this.genero = genero;
    }
    
    
}
