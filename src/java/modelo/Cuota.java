/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DAW212
 */
public class Cuota {
    int numeroCuota;
    double importeCuota;
    double capital;
    double intereses;

    public Cuota(int numeroCuota, double importeCuota, double capital, double intereses) {
        this.numeroCuota = numeroCuota;
        this.importeCuota = importeCuota;
        this.capital = capital;
        this.intereses = intereses;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getImporteCuota() {
        return importeCuota;
    }

    public void setImporteCuota(double importeCuota) {
        this.importeCuota = importeCuota;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }
}
