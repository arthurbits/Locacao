
package ModeloDao;

import Modelo.CarrinhoDeCompra;
import Modelo.ItemDeCompra;
import Modelo.Locacao;
import Modelo.Produto;
import Util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


public class ItemDeCompraDao {
    private static final String CADASTRARITEM = "insert into itemdecompra (idproduto,quantidade,total,idlocacaofk) values (?,?,?,?)";
    private static final String LOCALIZARCARRINHO = "select * from itemdecompra where idlocacaofk = ? ";  
    private static final String ATUALIZAR = "update compra set quantidade=?,total=? where iditemdecompra=? ";
    private static final String DATADISPONIVEL = " select l.idlocacao , l.datainicial , l.datafinal , i.iditemdecompra , i.idproduto from locacao as l , itemdecompra as i where i.idlocacaofk = l.idlocacao and ? between l.datainicial and l.datafinal and i.idproduto = ? ";
    

    
    
    public void cadastrarItem(ItemDeCompra item, Locacao locacao){
       Connection conexao = null;
       try{
            conexao = Conexao.getConexao();              
            PreparedStatement pstmt = conexao.prepareStatement(CADASTRARITEM);        
            pstmt.setInt( 1 , item.getProduto().getIdProduto());
            pstmt.setInt( 2 , item.getQuantidade());
            pstmt.setDouble( 3 , item.getTotal());
            pstmt.setInt( 4 , locacao.getIdLocacao());            
           
            pstmt.execute();
           
       }catch (Exception e ){
           
           throw new RuntimeException(e);
           
       }finally{
           
           try{conexao.close();
           
           }catch (SQLException ex){
               
               throw new RuntimeException (ex);
           }
    }
   }//FIM CADASTRAR ITEM
    
    public CarrinhoDeCompra localizarItens(Locacao locacao) throws SQLException, ClassNotFoundException{
        CarrinhoDeCompra carrinho = new CarrinhoDeCompra();
        ProdutoDao pdao = new ProdutoDao();        
        //conexão
       Connection conexao = Conexao.getConexao();
       //criar comando SQL
       PreparedStatement pstmt = conexao.prepareStatement(LOCALIZARCARRINHO);     
        pstmt.setInt(1,locacao.getIdLocacao());
       //executa
       ResultSet rs = pstmt.executeQuery();     
      
       while (rs.next()){
            //a cada loop           
            int id = rs.getInt("idproduto");
            Produto produto = new Produto();
            produto = pdao.listarPorId(id);
            ItemDeCompra item = new ItemDeCompra();
            item.setIdItemDeCompra(rs.getInt("iditemdecompra"));
            item.setProduto(produto);            
            item.setQuantidade(rs.getInt("quantidade"));
            item.setTotal(rs.getDouble("total"));            
            carrinho.addNovoItem(item);         
        }
        
       return carrinho;
   } //FIM LOCALIZAR CARRINHO
    
    public void atualizaItem(ItemDeCompra item) throws SQLException, ClassNotFoundException, ParseException{
        //conexão
        Connection conexao = Conexao.getConexao();
        //criar comando SQL
        PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR);     
        pstmt.setInt( 1 , item.getQuantidade());
        pstmt.setDouble( 2 , item.getTotal());
        pstmt.setInt( 3 , item.getIdItemDeCompra());
        pstmt.execute();
   
        
       
   } //FIM ATUALIZAR
    
    public boolean itemDisponivel (ItemDeCompra item, Date dataSql )throws SQLException, ClassNotFoundException{
        boolean flag = false;
        Connection conexao = null;
        try{
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DATADISPONIVEL);
            pstmt.setDate(1, dataSql);
            pstmt.setInt(2,item.getProduto().getIdProduto());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
               flag = true;         
            }            
            
        }catch (Exception e ){           
           throw new RuntimeException(e);           
        }finally{           
           try{conexao.close();           
           }catch (SQLException ex){               
               throw new RuntimeException (ex);
           }
       }
        
        return flag;
        
    } //FIM DataDisponível
    
}

