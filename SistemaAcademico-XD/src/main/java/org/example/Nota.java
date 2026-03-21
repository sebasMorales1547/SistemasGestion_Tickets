/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author Familia
 */
public class Nota {

    // Atributos
    private Estudiante estudiante;
    private Asignatura asignatura;
    private double valor;
    private String periodo;

    // Constructor vacio
    public Nota() {
    }

    // Constructor con sus debidos parametros
    public Nota(Estudiante estudiante, Asignatura asignatura, double valor, String periodo) {
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.valor = valor;
        this.periodo = periodo;
    }

    // Debido Getter
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public double getValor() {
        return valor;
    }

    public String getPeriodo() {
        return periodo;
    }

    // Debido Setter
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    
    @Override
    public String toString() {
        return "Nota{" +
                "estudiante=" + estudiante +
                ", asignatura=" + asignatura +
                ", valor=" + valor +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
