/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Alexa
 */
public class Cliente {
    private String nroCuenta;
    private String nombre;
    private String apellido;
    private String tipoTransaccion;
    private double monto;

    public Cliente(String nroCuenta, String nombre, String apellido, String tipoTransaccion, double monto) {
        this.nroCuenta = nroCuenta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoTransaccion = tipoTransaccion;
        this.monto = monto;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public double getMonto() {
        return monto;
    }
    
    
}
