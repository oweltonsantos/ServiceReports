/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.montpellier.ReciboImposto.Controller;

import br.com.montpellier.ReciboImposto.Connection.ConnectionFactory;
import br.com.montpellier.ReciboImposto.Model.ModelCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author santos
 */
public class ControllerClienteOLD implements IDAO<Object> {

    @Override
    public void inserir(Object objeto) throws Exception {
        //Conexao c = new Conexao();
        ConnectionFactory conf = new ConnectionFactory();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        //ResultSet rs = null;
        
        String sql = "INSERT INTO TBCLIENTE (NOME, CPF, CNPJ, RUA, BAIRRO, CIDADE, ESTADO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(sql);
//        stmt.setString(1, ModelCliente.getNome());
//        stmt.setString(2, ModelCliente.getCpf());
//        stmt.setString(3, ModelCliente.getCnpj());
//        stmt.setString(4, ModelCliente.getRua());
//        stmt.setString(5, ModelCliente.getBairro());
//        stmt.setString(6, ModelCliente.getCidade());
//        stmt.setString(7, ModelCliente.getEstado());
        stmt.execute();
       conf.confirmar();
       
       
       
       ConnectionFactory.closeConnection(con, stmt);
       
       JOptionPane.showMessageDialog(null, "Cliente Salvo com Sucesso!");
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object recuperar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
