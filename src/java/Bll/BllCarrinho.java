package Bll;
import Modelo.CarrinhoDeCompra;
import Modelo.Usuario;
import Modelo.Endereco;
import Modelo.ItemDeCompra;
import Modelo.Produto;
import ModeloDao.ProdutoDao;
import java.sql.SQLException;

public class BllCarrinho {
    
    public String FinalizarLocacao(CarrinhoDeCompra carrinho , Usuario usuario, Endereco endereco){    
        String send = "";
        if (carrinho.getItens()==null | carrinho.getItens().size()==0){                  
                send = "carrinhoVazio.jsp";
            }else if(usuario == null){              
                    send="cadastro.jsp";
            }else if ( endereco==null | endereco.getIdEndereco() == 0 ){                    
                send="ControleCliente?acao=ChecarCliente";
            }else{
                send="finalizarLocacao.jsp";
            }
        return send;
    }

    public String VerrificarCarrinho(CarrinhoDeCompra carrinho){
        String send = "";
        if(carrinho==null){       
            send="carrinhoVazio.jsp";
        }else{
            send="carrinho.jsp";
        }
        return send;
    }

    public CarrinhoDeCompra AddProduto(CarrinhoDeCompra carrinho, int idProduto) throws SQLException, ClassNotFoundException{           
                
                //flag para controle de inserção de novos produtos no carrinho
                boolean existe = false;        
                
                //verifica se já exista um carrinho na sessao
                if (carrinho == null) {                                                                                       
                    carrinho = new CarrinhoDeCompra();                                      
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
                return carrinho;
            }          
                    
                    
                    
                    
}
