/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.montpellier.ReciboImposto.Controller;

import br.com.montpellier.ReciboImposto.Connection.ConnectionFactory;
import br.com.montpellier.ReciboImposto.Model.ModelComanda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author santos
 */
public class ControllerComanda {
    
    
    
    public void imprimeComanda(ModelComanda c){
        String dataF = "dd/MM/yyyy";
        String horaF = "HH:mm";
        String data, hora;
        //CapturandoData
        java.util.Date dataAtual = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(dataF);
        //CapturandoHora
        formata = new SimpleDateFormat(horaF);
        hora = formata.format(dataAtual);
        
        String conteudoImprimir = "";
        
    };

    public void createComanda(ModelComanda u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbcomanda (Cliente,Descricaoservico)VALUES(?,?)");
            stmt.setInt(1, u.getCodCliente());
            stmt.setString(2, u.getServico());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean testaClientePorCodigo(String codCliente) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcliente WHERE codigo = ?");
            stmt.setString(1, codCliente);
            rs = stmt.executeQuery();
            if (rs.next()) {
//                String teste = rs.getString(1);
//                System.out.println("Login: " + teste);
                check = true;

            };

        } catch (SQLException ex) {
            Logger.getLogger(ControllerComanda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }

    public boolean testaClientePorNome(String nomeCliente) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcliente WHERE nome LIKE = ?");
            stmt.setString(1, '%' + nomeCliente + '%');
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;
            };

        } catch (SQLException ex) {
            Logger.getLogger(ControllerComanda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }

}
