package ModeloDao;

import Modelo.Produto;
import Util.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ProdutoDao {
    private static final String LISTAR = "select * from produto order by idproduto";
    private static final String BUSCARPORID = "select * from produto where idproduto = ?";
   
   
    public ArrayList<Produto> listar() throws SQLException, ClassNotFoundException{
       ArrayList<Produto> listaProduto = new ArrayList<Produto>();
        //conexão
       Connection conexao = Conexao.getConexao();
       //criar comando SQL
       PreparedStatement pstmt = conexao.prepareStatement(LISTAR);
       //executa
       ResultSet rs = pstmt.executeQuery();
       
       while (rs.next()){
           //a cada loop           
            Produto novoProduto = new Produto();
            novoProduto.setIdProduto(rs.getInt("idProduto"));                        
            novoProduto.setNome(rs.getString("nome"));
            novoProduto.setValorCompra(rs.getDouble("valorCompra"));
            novoProduto.setValorLocacao(rs.getDouble("valorLocacao"));
            novoProduto.setValorDano(rs.getDouble("valorDano"));
            novoProduto.setImagem(rs.getString("imagem"));
            novoProduto.setLocado(rs.getBoolean("locado"));
            novoProduto.setReservado(rs.getBoolean("reservado"));         
            listaProduto.add(novoProduto);           
       }
       return listaProduto;
   } //FIM LISTAR    
    
    public Produto listarPorId(int idProduto)throws SQLException, ClassNotFoundException {
        //conexão
        Connection conexao = null;
        //Instancia de Array
        Produto produto = new Produto();
        
        try{
            
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(BUSCARPORID);
            pstmt.setInt(1,idProduto);
            ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            //a cada loop           
            produto.setIdProduto(rs.getInt("idProduto"));                        
            produto.setNome(rs.getString("nome"));
            produto.setValorCompra(rs.getDouble("valorCompra"));
            produto.setValorLocacao(rs.getDouble("valorLocacao"));
            produto.setValorDano(rs.getDouble("valorDano"));
            produto.setImagem(rs.getString("imagem"));
            produto.setLocado(rs.getBoolean("locado"));
            produto.setReservado(rs.getBoolean("reservado"));      
                     
        }
       return produto;
            
        }catch(Exception e ){
            throw new RuntimeException(e);
        }finally{
            try{
                conexao.close();
            }catch (SQLException ex){
                    throw new RuntimeException(ex);
            
                }            
            } 
    }//FIM BUSCARPORID
     
}//FIM PRODUTODAO