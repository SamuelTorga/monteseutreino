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
public class Treino {

    private int ordem = 1;
    private Exercicio exercicio;
    private int repeticoes = 1;
    private int series = 1;
    private String diaTreino = "";
    private String observacoes = "";

    public Treino() {
    }

    public Treino(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;

    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getDiaTreino() {
        return diaTreino;
    }

    public void setDiaTreino(String diaTreino) {
        this.diaTreino = diaTreino;

    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    

}
