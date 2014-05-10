/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.st.monteseutreino.model;

/**
 *
 * @author Samuel
 */
public class Exercicio {
    
    private int id;
    private String nome;
    private String grupoMuscular;

    public Exercicio() {
        this.nome = "";
        this.grupoMuscular = "";
    }

    public Exercicio(String nomeExercicio,String grupoMuscular) {
        this.nome = nomeExercicio;
        this.grupoMuscular = grupoMuscular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    @Override
    public String toString() {
        return this.getNome(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
