/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;

/**
 *
 * @author L
 */
public class comprasBeans {
    private int id;
    private int cliente;
    private int idPago;
    private String fecha;
    private double monto;
    private String estado;
    
    private List<carritoBeans>detalleCompras;

    public comprasBeans() {
    }

    public comprasBeans(int cliente, int idPago, String fecha, double monto, String estado, List<carritoBeans> detalleCompras) {
        this.cliente = cliente;
        this.idPago = idPago;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
        this.detalleCompras = detalleCompras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<carritoBeans> getDetalleCompras() {
        return detalleCompras;
    }

    public void setDetalleCompras(List<carritoBeans> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }
    
    
}
