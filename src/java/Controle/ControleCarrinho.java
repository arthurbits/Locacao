
package Controle;

import Bll.BllCarrinho;
import Modelo.CarrinhoDeCompra;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControleCarrinho", urlPatterns = {"/ControleCarrinho"})
public class ControleCarrinho extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acao = request.getParameter("acao");             
            HttpSession sessao = request.getSession();      
            CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
            BllCarrinho bll = new BllCarrinho();
            
            if(acao.equals("FinalizaLocacao")){              
                response.sendRedirect( bll.getPagina() );                
            }    
            
            if(acao.equals("VerificaCarrinho")){
                bll.VerrificarCarrinho(carrinho);
                response.sendRedirect(bll.getPagina());
            }
            
            if (acao.equals("addProduto")) {
               int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                carrinho = bll.AddProduto(carrinho, idProduto);
                sessao.setAttribute("carrinho", carrinho);
                response.sendRedirect("carrinho.jsp");      
            }    
            
            if (acao.equals("diminuiProduto")) {              
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));       
               carrinho = bll.DiminuiProduto(carrinho, idProduto);                
                carrinho = bll.AtualizarCarrinho(carrinho,idProduto);
                sessao.setAttribute("carrinho", carrinho);
                bll.VerrificarCarrinho(carrinho);
                response.sendRedirect(bll.getPagina()); 
            }
             
            if (acao.equals("removeProduto")) {           
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));    
                carrinho = bll.RemoveProduto(carrinho, idProduto);
                sessao.setAttribute("carrinho",carrinho);             
                bll.VerrificarCarrinho(carrinho);
                response.sendRedirect(bll.getPagina());   
            } 
            
            if (acao.equals("cancelaCompra")) {                                    
               sessao.removeAttribute("carrinho");
                response.sendRedirect("index.jsp");
            }
            
            
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
}
