
package Bll;

import Modelo.Email;
import Modelo.Usuario;
import ModeloDao.UsuarioDao;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BllUsuario {    
    UsuarioDao udao = new UsuarioDao();  
    
    public String Cadastrar(Usuario usuario) throws SQLException, ClassNotFoundException, MessagingException, AddressException, InterruptedException, Exception{
        String usuarioMsg = "";
        if (udao.emailExiste(usuario.getEmail())==true){
                     usuarioMsg="E-mail existente, favor cadastrar com outro e-mail";                
        }else{                
            udao.cadastrar(usuario);
            usuario = udao.logar(usuario.getUsuario(),usuario.getSenha());        
            Email email = new Email();              
            email.enviaEmail(usuario.getEmail());
            usuarioMsg = "Usuario cadastrado com sucesso. Um e-mail para ativação da conta foi enviado!";                 
        }
        return usuarioMsg;
    }

    public String pagina(String  usuario, String senha) throws SQLException, ClassNotFoundException{        
        boolean flag = udao.usuarioExiste(usuario,senha); 
        Usuario user = udao.logar(usuario, senha);
        String page ="";     
        if (flag == true && user.getCredencial().equals("Administrador")){            
                page = "administrador.jsp";              
        }else{
                page = "index.jsp";  
        }       
        System.out.println("BLL Pagina = "+page);
        return page;
    }

    public String mensagem(String  usuario, String senha) throws SQLException, ClassNotFoundException{
        String msg;     
        boolean flag = udao.usuarioExiste(usuario,senha);    
        Usuario user = udao.logar(usuario, senha);
        if(flag==false){
            msg="Usuario ou senha incorretos .";
        }else if(user.getAtivo()==false){
                    msg="Para acessar, verifique seu e-mail para validar seu cadastro .";
                }else{
                    msg = " Bem vindo, "+user.getUsuario(); 
        }     
        System.out.println("BLL Mensagem = "+msg);
        return msg;
    }
    
    
    
}
