package Controle;


import Bll.BllUsuario;
import Modelo.Cliente;
import Modelo.Email;
import Modelo.Endereco;
import Modelo.Usuario;
import ModeloDao.ClienteDao;
import ModeloDao.EnderecoDao;
import ModeloDao.UsuarioDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControleUsuario", urlPatterns = {"/ControleUsuario"})
public class ControleUsuario extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        HttpSession session = request.getSession();
        String acao = request.getParameter("acao");
        UsuarioDao udao = new UsuarioDao();    
        EnderecoDao edao = new EnderecoDao();
        ClienteDao cdao = new ClienteDao();
        BllUsuario bll = new BllUsuario();
        
        try{
            if (acao.equals("Entrar")){                 
                String usuarioTxt = request.getParameter("usuario");
                String senhaTxt = request.getParameter("senha");
                Usuario usuarioLogado = udao.logar(usuarioTxt, senhaTxt);
                String msg = bll.mensagem(usuarioTxt, senhaTxt);        
                String page = bll.pagina(usuarioTxt, senhaTxt);   
                session.setAttribute("cliente", cdao.localizarIdUsuario(usuarioLogado));
                session.setAttribute("endereco", edao.localizarPorUsuario(usuarioLogado));
                session.setAttribute("usuario", usuarioLogado);
                session.setAttribute("msg", msg); 
                 response.sendRedirect(page);                              
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
                String usuarioMsg =bll.Cadastrar(usuario);          
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
                /*
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
                */
            }
            
        }catch(Exception e){
            request.setAttribute("erro",e);
            RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
            rd.forward(request,response);
        }
    }

   
}
