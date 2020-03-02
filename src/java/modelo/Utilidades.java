/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author DAW212
 */
public class Utilidades {
    public static ArrayList<String> getMeses() {
        ArrayList <String> meses = new ArrayList <String> ();
        for (int i = 1; i <= 15; i++){
            meses.add(String.valueOf(i*12));
        }
        return meses;
    }
    
    public static ArrayList<Cuota> listCuotas (int numCuotas, double imptot) {
        
        ArrayList <Cuota> cuotas = new ArrayList <Cuota> ();
        double inteCuota, capCuota;
        double impCuota = imptot / numCuotas;
        
        for (int i = 1; i <= numCuotas; i++) {
            inteCuota  = impCuota - impCuota*(i-1)/numCuotas;
            capCuota = impCuota - inteCuota;
            Cuota miCuota = new Cuota(i, impCuota, capCuota, inteCuota);
            cuotas.add(miCuota);
        }
        return cuotas;
    }
}
