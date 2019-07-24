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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oweltonsantos
 */
public class ControllerCliente {

    public void create(ModelCliente u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbcliente (nome, cpf, cnpj, rua, bairro, cidade, estado, telefone, email )VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCpf());
            stmt.setString(3, u.getCnpj());
            stmt.setString(4, u.getRua());
            stmt.setString(5, u.getBairro());
            stmt.setString(6, u.getCidade());
            stmt.setString(7, u.getEstado());
            stmt.setString(8, u.getTelefone());
            stmt.setString(9, u.getEmail());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void update(ModelCliente u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbcliente SET nome = ?,cpf = ?,cnpj = ?,cidade = ?,estado = ?, rua = ?, bairro = ?, telefone = ?, email = ? WHERE codigo = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCpf());
            stmt.setString(3, u.getCnpj());
            stmt.setString(4, u.getCidade());
            stmt.setString(5, u.getEstado());
            stmt.setString(6, u.getRua());
            stmt.setString(7, u.getBairro());
            stmt.setString(8, u.getTelefone());
            stmt.setString(9, u.getEmail());
            stmt.setInt(10, u.getCodigo());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(ModelCliente u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbcliente WHERE codigo = ?");
            stmt.setInt(1, u.getCodigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<ModelCliente> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelCliente> clients = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcliente");
            rs = stmt.executeQuery();

            
            while (rs.next()) {
                
                ModelCliente client = new ModelCliente();
                client.setCodigo(rs.getInt("codigo"));
                client.setNome(rs.getString("nome"));
                client.setCpf(rs.getString("cpf"));
                client.setCnpj(rs.getString("cnpj"));
                client.setTelefone(rs.getString("telefone"));
                client.setEmail(rs.getString("email"));
                client.setCidade(rs.getString("cidade"));
                client.setEstado(rs.getString("estado"));

                clients.add(client);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clients;

    }
    public List<ModelCliente> readForNome(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelCliente> clients = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcliente WHERE nome LIKE ?");
            stmt.setString(1,"%"+nome+"%");
            rs = stmt.executeQuery();

            
            while (rs.next()) {
                
                ModelCliente client = new ModelCliente();
                client.setCodigo(rs.getInt("codigo"));
                client.setNome(rs.getString("nome"));
                client.setCpf(rs.getString("cpf"));
                client.setCnpj(rs.getString("cnpj"));
                client.setTelefone(rs.getString("telefone"));
                client.setEmail(rs.getString("email"));
                client.setCidade(rs.getString("cidade"));
                client.setEstado(rs.getString("estado"));

                clients.add(client);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clients;

    }

    public List<ModelCliente> readQuery(String cliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModelCliente> clients = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcliente WHERE nome LIKE '?%'");
            stmt.setString(1, cliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ModelCliente client = new ModelCliente();
                client.setCodigo(rs.getInt("codigo"));
                client.setNome(rs.getString("nome"));
                client.setCpf(rs.getString("cpf"));
                client.setCnpj(rs.getString("cnpj"));
                client.setCidade(rs.getString("cidade"));
                client.setEstado(rs.getString("estado"));
                client.setTelefone(rs.getString("telefone"));
                client.setEmail(rs.getString("email"));

                clients.add(client);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clients;

    }
    public ModelCliente queryClientePorCodigo(String codCliente) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ModelCliente client = new ModelCliente();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcliente WHERE codigo = ?");
            stmt.setString(1, codCliente);
            rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                client.setCodigo(rs.getInt("codigo"));
                client.setNome(rs.getString("nome"));
                client.setCpf(rs.getString("cpf"));
                client.setCnpj(rs.getString("cnpj"));
                client.setCidade(rs.getString("cidade"));
                client.setEstado(rs.getString("estado"));
                client.setRua(rs.getString("rua"));
                client.setBairro(rs.getString("bairro"));
                client.setTelefone(rs.getString("telefone"));
                client.setEmail(rs.getString("email"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return client;

    }
    
    

}
