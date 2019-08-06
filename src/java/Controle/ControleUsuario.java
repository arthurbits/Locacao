package Controle;


import Modelo.Cliente;
import Modelo.Email;
import Modelo.Email;
import Modelo.Endereco;
import Modelo.Usuario;
import ModeloDao.ClienteDao;
import ModeloDao.EnderecoDao;
import ModeloDao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControleUsuario", urlPatterns = {"/ControleUsuario"})
public class ControleUsuario extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ControleDeAcesso controle = new ControleDeAcesso();
        HttpSession session = request.getSession();
        String acao = request.getParameter("acao");
        UsuarioDao udao = new UsuarioDao(); 
        try {
           if(acao.equals("emailAtivacao")){
                System.out.println("Entrou em ativação sem ser get "); 
                String email = request.getParameter("emailCliente");
                udao.ativarUsuario(email);
                response.sendRedirect("index.jsp");
            } 
           
           
        }catch(Exception e){
            request.setAttribute("erro",e);
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request,response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ControleDeAcesso controle = new ControleDeAcesso();
        HttpSession session = request.getSession();
        String acao = request.getParameter("acao");
        UsuarioDao udao = new UsuarioDao();      
        
        try{
            if (acao.equals("Entrar")){
                
                String usuario = request.getParameter("usuario");
                String senha = request.getParameter("senha");       
                    
                Usuario usuarioLogado = udao.logar(usuario, senha);    
                boolean existe = udao.usuarioExiste(usuario, senha);
                System.out.println("Pegou os valores e resposta pra Existe = "+existe);
                if (existe==true){
                    String page = controle.pagina(usuarioLogado);
                    String msg = controle.mensagem(usuarioLogado); 
                    ClienteDao cdao = new ClienteDao();
                    Cliente cliente = cdao.localizarIdUsuario(usuarioLogado);
                    EnderecoDao edao = new EnderecoDao();
                    Endereco endereco = edao.localizarPorUsuario(usuarioLogado);
                    session.setMaxInactiveInterval(-1);
                    session.setAttribute("cliente", cliente);
                    session.setAttribute("endereco", endereco);
                    session.setAttribute("usuario", usuarioLogado);
                    session.setAttribute("msg", msg);                 

                    System.out.println("Adicionou usuario, mensagem e página à sessão .");                    
                    response.sendRedirect(page);                              
                }else {
                    System.out.println("Usuario inválido ! ! ! ");
                    String msg = "Usuario ou Senha inválidos.";
                    session.setAttribute("msg", msg);
                    response.sendRedirect("index.jsp"); 
                }  
            }
            if(acao.equals("Cadastrar")){
                Usuario usuario = new Usuario();
                String usuariotxt = request.getParameter("usuario");
                String senhatxt = request.getParameter("senha");
                String emailtxt = request.getParameter("email");              
                usuario.setUsuario(usuariotxt);
                usuario.setSenha(senhatxt);
                usuario.setEmail(emailtxt);
                usuario.setAtivo(false);                
                usuario.setCredencial("Cliente");
                String usuarioMsg ="";
                
                if (udao.emailExiste(usuario.getEmail())==true){
                     usuarioMsg="E-mail existente, favor cadastrar com outro e-mail";                
                                   
                }else{                
                    udao.cadastrar(usuario);
                    usuario = udao.logar(usuariotxt, senhatxt);
                    String em = usuario.getEmail();
                    Email email = new Email();              
                    email.enviaEmail(em);
                    usuarioMsg = "Usuario cadastrado com sucesso. Um e-mail para ativação da conta foi enviado!";                 
                }
                session.setAttribute("usuarioMsg", usuarioMsg);
                response.sendRedirect("cadastro.jsp"); 
            }
            
            if (acao.equals("Reenviar E-mail")){          
           
                Usuario usuario =(Usuario) session.getAttribute("usuario");
                Email email = new Email();   
                String emailtxt = usuario.getEmail();
                email.enviaEmail(emailtxt);     
                
                
                String msg = "O email foi enviado com sucesso !";
                session.setAttribute("msg", msg);
                response.sendRedirect("index.jsp");  
                
                
            }
            
            if (acao.equals("Alterar Senha ")){
                Usuario usuarioLogado =(Usuario)session.getAttribute("usuario");
                String senhaAtual = request.getParameter("senhaAtual");
                String senhaNova = request.getParameter("senhaNova");
                String usuario = request.getParameter("usuario");
                String senhaMsg = "";       
                
                
                Usuario uChecando =udao.logar(usuario, senhaAtual);
                if(uChecando != null){
                    if (senhaAtual != senhaNova ){
                        senhaMsg = "A senha foi alterada com sucesso ! ";
                        usuarioLogado.setSenha(senhaNova);
                        udao.alterarSenha(usuarioLogado);
                    }else{
                        senhaMsg = "As senhas devem ser diferentes ! ";
                    }
                    
                    
                }else{
                   senhaMsg = "Usuario ou Senha Atual inválidos ! "; 
                }
                
                
                session.setAttribute("usuario", usuarioLogado);
                session.setAttribute("senhaMsg", senhaMsg);
                
                
                response.sendRedirect("alterarSenha.jsp");
            }
            
        }catch(Exception e){
            request.setAttribute("erro",e);
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request,response);
        }
    }

   
}
