
package Controle;

import Modelo.CarrinhoDeCompra;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.ItemDeCompra;
import Modelo.Produto;
import Modelo.Usuario;
import ModeloDao.LocacaoDao;
import ModeloDao.ProdutoDao;
import java.io.IOException;
import java.io.PrintWriter;
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
            Usuario usuario = (Usuario)sessao.getAttribute("usuario");
            Cliente cliente = (Cliente) sessao.getAttribute("cliente");
            Endereco endereco = (Endereco) sessao.getAttribute("endereco");
            CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
            LocacaoDao ldao = new LocacaoDao();
            
            if(acao.equals("FinalizaLocacao")){ 
                
                if (carrinho.getItens()==null | carrinho.getItens().size()==0){
                    String msg = " Carrinho vazio !!";
                    sessao.setAttribute("msg", msg);
                    response.sendRedirect("index.jsp");
                }else if(usuario == null){ 
                        System.out.println("Usuario também é nulo ");
                        String usuarioMsg = " Para Finalizar a locação é necessário entrar na conta !";
                        sessao.setAttribute("usuarioMsg", usuarioMsg);
                        response.sendRedirect("cadastro.jsp");
                }else if ( endereco==null | endereco.getIdEndereco() == 0 ){
                    System.out.println("Vai ir para o lobby !");
                    String msg = " Cadastre seu endereço para entrega  ";
                    sessao.setAttribute("msg", msg);
                    response.sendRedirect("ControleCliente?acao=ChecarCliente");
                }else{
                    response.sendRedirect("finalizarLocacao.jsp");
                }
            } 
           
            
            if(acao.equals("VerificaCarrinho")){
                if(carrinho==null){       
                    response.sendRedirect("carrinhoVazio.jsp");
                }else{
                    response.sendRedirect("carrinho.jsp");
                }
            }           
            
            
            if (acao.equals("addProduto")) {
                //recupera o id do produto que deve ser add no carrinho
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                
                //flag para controle de inserção de novos produtos no carrinho
                boolean existe = false;        
                
                //verifica se já exista um carrinho na sessao
                if (carrinho == null) {                                                                                       
                    carrinho = new CarrinhoDeCompra();
                    sessao.setAttribute("carrinho",carrinho);                    
                }
                
                // verifica se o produto existe no carrinho e se existe aumenta +1
                if (carrinho.getItens()!=null){
                    for(ItemDeCompra item : carrinho.getItens()){
                        if(item.getProduto().getIdProduto()==idProduto){
                            //incrementa a quantidade
                            item.setQuantidade(item.getQuantidade()+1);
                            existe = true;
                        }                    
                    }
                }
                
                //Se não existe o item ou produto se cria um novo
                if(existe==false){
                    //encontra o produto no banco
                    Produto produto = new ProdutoDao().listarPorId(idProduto);
                    //cria um novo item
                    ItemDeCompra novoItem = new ItemDeCompra();
                    novoItem.setProduto(produto);
                    novoItem.setQuantidade(1);
                    //adiciona novo item
                    carrinho.addNovoItem(novoItem);                
                }               
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
                
                
            }//fim addProduto       
            
            
            
                       
            if (acao.equals("diminuiProduto")) {
                //recupera o id do produto que deve ser add no carrinho
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                //flag para controle de inserção de novos produtos no carrinho
                boolean existe = false;
                //recupera a sessão pertencente ao request
                sessao = request.getSession();         
                
                //recupera um carrinho de produtos da sessão
                //se não exite um carrinho na sessão o valor será igual a null
                
                //verifica se já exista um carrinho na sessao
                if (carrinho == null) {
                    //cria um carrinho                                                                      
                    carrinho = new CarrinhoDeCompra();
                    sessao.setAttribute("carrinho",carrinho);
                }
                // verifica se o produto existe no carrinho
                if (carrinho.getItens()!=null){
                    for(ItemDeCompra item : carrinho.getItens()){
                        if(item.getProduto().getIdProduto()==idProduto){
                            //incrementa a quantidade
                            item.setQuantidade(item.getQuantidade()-1);
                            existe = true;
                        }                    
                    }
                }
                //Se não existe o item ou produto se cria um novo
                if(existe==false){
                    //encontra o produto no banco
                    Produto produto = new ProdutoDao().listarPorId(idProduto);
                    //cria um novo item
                    ItemDeCompra novoItem = new ItemDeCompra();
                    novoItem.setProduto(produto);
                    novoItem.setQuantidade(1);
                    //adiciona novo item
                    carrinho.addNovoItem(novoItem);                
                }
                sessao.setAttribute("carrinho", carrinho);
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/carrinho.jsp").forward(request, response);                
                //response.sendRedirect("carrinho.jsp");
            }//fim diminuiProduto
            
            if (acao.equals("removeProduto")) {       
                
                //recupera um carrinho de produtos da sessão
                //recupera o id do produto
                int idProduto = Integer.parseInt(request.getParameter("idProduto"));
                ItemDeCompra itemRemove = new ItemDeCompra();
                Produto prodRemove = new Produto();
                prodRemove.setIdProduto(idProduto);
                itemRemove.setProduto(prodRemove);
                carrinho.removerItem(itemRemove); 
                
                sessao.setAttribute("carrinho", carrinho);
                //carrega a pagina do carrinho de compras
                request.getRequestDispatcher("/carrinho.jsp").forward(request, response);
                
                
               // response.sendRedirect("carrinho.jsp");
                
                
            } if (acao.equals("cancelaCompra")) {               
                //recebe o usuario da sessao e revalida a mesma     
                
                //remove o carrinho da sessão
                sessao.removeAttribute("carrinho");
                //remove mensagem de disponibilidade
                sessao.removeAttribute("msgCheck");                
                //redireciona para pagina principal
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
