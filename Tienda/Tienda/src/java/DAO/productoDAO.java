/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.productoBeans;
import conexionBD.conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author L
 */
public class productoDAO {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public productoBeans listarId(int id){
        String sql="select * from productos where id=" + id;
        productoBeans p=new productoBeans();
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setFoto(rs.getBinaryStream("foto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    public List listar(){
        String sql="select * from productos";
        List<productoBeans> productos=new ArrayList();
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                productoBeans p=new productoBeans();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setFoto(rs.getBinaryStream("foto"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
               
                productos.add(p);
            }
        } catch (Exception e) {
        }
        return productos;
    }
    
    public void listarImg(int id, HttpServletResponse response){
        String sql="select * from productos where id="+id;
        InputStream intputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        response.setContentType("image/*");
        
        try {
            outputStream=response.getOutputStream();
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            if (rs.next()) {
                intputStream=rs.getBinaryStream("foto");
            }
            
            bufferedInputStream=new BufferedInputStream(intputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            
            while ((i= bufferedInputStream.read())!=-1) {                
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }
}
