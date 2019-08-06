
package Controle;

import Modelo.Usuario;

public class ControleDeAcesso {
    
    
    public String pagina(Usuario usuario){
        String page;   
        
        if(usuario.getCredencial().equals("Administrador")){
            page = "administrador.jsp";              
        }else{
            page ="index.jsp";
        }
            
        return page;
    }
    
    public String mensagem(Usuario usuario){
        String msg;     
        if(usuario==null){
            msg="Usuario ou senha incorretos .";
        }else if(usuario.getAtivo()==false){
                msg="Para acessar, verifique seu e-mail para validar seu cadastro .";
            }else{
                msg = " Bem vindo, "+usuario.getUsuario(); 
            }
    
        
        return msg;
    }
    
    public String credencial(Usuario usuario){    
        String c = usuario.getCredencial();            
        return c;
    }
}
