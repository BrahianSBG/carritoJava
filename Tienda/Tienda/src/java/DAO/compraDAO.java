/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexionBD.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class compraDAO {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;
    
    public int GenerarCompra(int compra){
        String sql="insert into compras(idCliente,fechaCompras,monto,estado,idPago)values(?,?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, compra.getCliente.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
