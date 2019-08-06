
package Controle;

import Modelo.CarrinhoDeCompra;
import Modelo.Cliente;
import Modelo.Endereco;
import Modelo.ItemDeCompra;
import Modelo.Locacao;
import Modelo.Usuario;
import ModeloDao.ItemDeCompraDao;
import ModeloDao.LocacaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PcLorD
 */
@WebServlet(name = "ControleLocacao", urlPatterns = {"/ControleLocacao"})
public class ControleLocacao extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acao = request.getParameter("acao");             
            HttpSession sessao = request.getSession(); 
            Usuario usuario = (Usuario)sessao.getAttribute("usuario");
            Cliente cliente = (Cliente) sessao.getAttribute("cliente");
            Endereco endereco = (Endereco) sessao.getAttribute("endereco");
            CarrinhoDeCompra carrinho = (CarrinhoDeCompra) sessao.getAttribute("carrinho");
            LocacaoDao ldao = new LocacaoDao();
            
             if(acao.equals("Finalizar Pedido")){                   
                System.out.println("Entrou em finalizar pepdido");
                String diTela = request.getParameter("dataInicial");
                String dfTela = request.getParameter("dataFinal");
                String forma = request.getParameter("forma");
                double  valor = carrinho.calculaTotal();               
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
                String dia = diTela.substring(8,10);
                String mes = diTela.substring(5,7);
                String ano = diTela.substring(0,4);
                String dataFormatadaInicial = ano+"-"+mes+"-"+dia;
                dia = dfTela.substring(8,10);
                mes = dfTela.substring(5,7);
                ano = dfTela.substring(0,4);
                String dataFormatadaFinal = ano+"-"+mes+"-"+dia;
                Date dataInicial = formato.parse(dataFormatadaInicial);
                Date dataFinal = formato.parse(dataFormatadaFinal); 
                
                
                /* COLOCAR NO DIAGRAMA DE SEQUÊNCIA */
                ItemDeCompraDao idao = new ItemDeCompraDao ();                
                boolean sinalverde = false;
                String msgCheck = "Os itens : ";
                java.sql.Date dataSqli = new java.sql.Date(dataInicial.getTime());
                java.sql.Date dataSqlf = new java.sql.Date(dataFinal.getTime());
                
                for (ItemDeCompra item : carrinho.getItens()){                  
                   boolean aux = idao.itemDisponivel(item, dataSqli);                
                   if (aux == true){
                       sinalverde = true;
                       msgCheck = msgCheck + " "+item.getProduto().getNome()+",";
                   }
                }
                if (sinalverde == false ){
                    for (ItemDeCompra item : carrinho.getItens()){                  
                   boolean aux = idao.itemDisponivel(item, dataSqlf);                
                   if (aux == true){
                       sinalverde = true;
                       msgCheck = msgCheck + " "+item.getProduto().getNome()+",";
                   }
                }
                }
                msgCheck = msgCheck+" Não estão disponíveis para locação nestas datas.";
                
                
                if(sinalverde == false){
                    Locacao locacao = new Locacao();
                    locacao.setDataInicial(dataInicial);
                    locacao.setDataFinal(dataFinal);
                    locacao.setChequeCalcao(true);
                    locacao.setFormaDePagamento(forma);
                    locacao.setPago(true);
                    locacao.setValor(valor);
                    locacao.setCliente(cliente);  

                    ldao.cadastrarLocacao(locacao);                
                    java.sql.Date dataSql = new java.sql.Date(locacao.getDataInicial().getTime());
                    locacao = ldao.localizarLocacao(dataSql, cliente);                

                    for (ItemDeCompra item : carrinho.getItens()){                  
                        idao.cadastrarItem(item, locacao);
                    }


                    /* COLOCAR NO DIAGRAMA DE SEQUÊNCIA */
                    sessao.removeAttribute("carrinho"); 
                    sessao.removeAttribute("msgCheck");

                    String msg = "Locação feita com sucesso";                
                    sessao.setAttribute("msg", msg);
                    response.sendRedirect("index.jsp");
                }else {
                    sessao.setAttribute("msgCheck", msgCheck);
                    response.sendRedirect("finalizarLocacao.jsp");
                }
            }  
            
            
        } catch (Exception erro) {
            request.setAttribute("erro", erro);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
        
    }

    

}
