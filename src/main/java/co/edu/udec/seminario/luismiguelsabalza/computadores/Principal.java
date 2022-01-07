/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udec.seminario.luismiguelsabalza.computadores;

import co.edu.udec.seminario.luismiguelsabalza.computadores.ventanas.VentanaPrincipal;

/**
 *
 * @author EQUIPO
 */
public class Principal {
    public static void main(String xyz[]) {
        System.out.println("Ok, funcionando...");
        VentanaPrincipal miVentana = new VentanaPrincipal();
        miVentana.setTitle("APP DESKTOP MVC CON JAVA");
        miVentana.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
        miVentana.setVisible(true);
    }
    
}
