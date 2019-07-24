/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.montpellier.ReciboImposto.Singleton;

import br.com.montpellier.ReciboImposto.View.ViewBuscaCliente;
import br.com.montpellier.ReciboImposto.View.ViewLogin;
import br.com.montpellier.ReciboImposto.View.ViewPrincipal;
import br.com.montpellier.ReciboImposto.View.ViewCliente;
import br.com.montpellier.ReciboImposto.View.ViewCadastroCliente;
import br.com.montpellier.ReciboImposto.View.ViewComanda;
import br.com.montpellier.ReciboImposto.View.ViewEditarCliente;
import br.com.montpellier.ReciboImposto.View.ViewNovaComanda;


/**
 *
 * @author santos
 */
public class GerenciadorDeTelas {
    
     private static final GerenciadorDeTelas instanse = new GerenciadorDeTelas();
    
    public static GerenciadorDeTelas getInstanse(){
    return instanse;
    }
     private ViewLogin viewLogin = null;
     private ViewPrincipal viewPrincipal = null;
     private ViewCliente viewCliente = null;
     private ViewCadastroCliente viewCadastroCliente = null;
     private ViewEditarCliente viewEditarCliente = null;
     private ViewNovaComanda viewNovaComanda = null;
     private ViewComanda viewComanda = null;
     private ViewBuscaCliente viewBuscaCliente = null;
     
     
    
     
    public ViewBuscaCliente getViewBuscaCliente() {
        if(viewBuscaCliente == null){
            viewBuscaCliente = new ViewBuscaCliente();
        }
        return viewBuscaCliente;
    }
    public ViewLogin getViewLogin() {
        if(viewLogin == null){
            viewLogin = new ViewLogin();
        }
        return viewLogin;
    }
    
    public ViewPrincipal getViewPricipal() {
        if(viewPrincipal == null){
            viewPrincipal = new ViewPrincipal();
        }
        return viewPrincipal;
    }
    
    public ViewCliente getViewCliente() {
        if(viewCliente == null){
            viewCliente = new ViewCliente();
        }
        return viewCliente;
    }
    public ViewCadastroCliente getViewCadastroCliente() {
        if(viewCadastroCliente == null){
            viewCadastroCliente = new ViewCadastroCliente();
        }
        return viewCadastroCliente;
    }
    public ViewEditarCliente getViewEditarCliente() {
        if(viewEditarCliente == null){
            viewEditarCliente = new ViewEditarCliente();
        }
        return viewEditarCliente;
    }
    public ViewNovaComanda getViewNovaComanda() {
        if(viewNovaComanda == null){
            viewNovaComanda = new ViewNovaComanda();
        }
        return viewNovaComanda;
    }
    public ViewComanda getViewComanda() {
        if(viewComanda == null){
            viewComanda = new ViewComanda();
        }
        return viewComanda;
    }
  
}
