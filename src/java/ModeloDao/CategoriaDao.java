package ModeloDao;

import Modelo.Categoria;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDao {
    private static final String LISTAR = "select * from categoria order by idcategoria";
    private static final String BUSCARPORID = "select * from categoria where idcategoria = ?";
   
   
    public ArrayList<Categoria> listar() throws SQLException, ClassNotFoundException{
       ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        //conexão
       Connection conexao = Conexao.getConexao();
       //criar comando SQL
       PreparedStatement pstmt = conexao.prepareStatement(LISTAR);
       //executa
       ResultSet rs = pstmt.executeQuery();
       
       while (rs.next()){
           //a cada loop           
            Categoria novaCategoria = new Categoria();
            novaCategoria.setIdCategoria(rs.getInt("idcategoria"));                        
            novaCategoria.setNome(rs.getString("nome"));
                     
           listaCategoria.add(novaCategoria);           
       }
       return listaCategoria;
   } //FIM LISTAR    
    
    public ArrayList<Categoria> listarPorId(int idCategoria)throws SQLException, ClassNotFoundException {
        //conexão
        Connection conexao = null;
        //Instancia de Array
        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        
        try{
            
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(BUSCARPORID);
            pstmt.setInt(1,idCategoria);
            ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
        //a cada loop
            Categoria novaCategoria = new Categoria();
            novaCategoria.setIdCategoria(rs.getInt("idCategoria"));
            novaCategoria.setNome(rs.getString("nome"));
                     
           
           listaCategoria.add(novaCategoria);           
        }
       return listaCategoria;
            
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
       
}
