
package ModeloDao;

import Modelo.Funcionario;
import Modelo.Usuario;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDao {
    private static final String ATUALIZAR = "update funcionario set nome=?, rg=?,cpf=?,telefone=?,celular=?  WHERE idfuncionario=?";
    private static final String LISTAR = "select * from funcionario";
    private static final String CADASTRAR = "insert into funcionario (nome,rg,cpf,telefone,celular,idusuariofk) values (?,?,?,?,?,?) ";
    private static final String BUSCARPORID = "select * from funcionario where cpf = ?";
       
    
    public void cadastrar (Funcionario funcionario,Usuario usuario){
       Connection conexao = null;
       try{
            conexao = Conexao.getConexao();           
            PreparedStatement pstmt = conexao.prepareStatement(CADASTRAR);
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getRg());
            pstmt.setString(3, funcionario.getCpf());
            pstmt.setString(4, funcionario.getTelefone());
            pstmt.setString(5, funcionario.getCelular());
            pstmt.setInt(6,usuario.getIdUsuario());
            pstmt.execute();         
           
        }catch (Exception e ){
           
           throw new RuntimeException(e);
           
        }finally{
           
           try{conexao.close();
           
        }catch (SQLException ex){
               
               throw new RuntimeException (ex);
        }
        }
   }//FIM CADASTRAR
    
    public void atualizar(Funcionario funcionario){
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR);
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getRg());
            pstmt.setString(3, funcionario.getCpf());
            pstmt.setString(4, funcionario.getTelefone());
            pstmt.setString(5, funcionario.getCelular());      
            pstmt.setInt(6,funcionario.getIdFuncionario());
            pstmt.execute();
           
        }catch(Exception e ){
            throw new RuntimeException(e);
        }finally{
                try {
                    conexao.close();

                    }catch (SQLException ex){
                        throw new RuntimeException (ex);    
                    }
                }
    }//FIM ATUALIZAR    
    
    public ArrayList<Funcionario> listar() throws SQLException, ClassNotFoundException{
       ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        //conexão
       Connection conexao = Conexao.getConexao();
       //criar comando SQL
       PreparedStatement pstmt = conexao.prepareStatement(LISTAR);
       //executa
       ResultSet rs = pstmt.executeQuery();
       
       while (rs.next()){
           //a cada loop           
            Funcionario novoFuncionario = new Funcionario();
            novoFuncionario.setIdFuncionario(rs.getInt("idfuncionario"));
            novoFuncionario.setNome(rs.getString("nome"));
            novoFuncionario.setRg(rs.getString("rg"));
            novoFuncionario.setCpf(rs.getString("cpf"));
            novoFuncionario.setTelefone(rs.getString("telefone"));
            novoFuncionario.setCelular(rs.getString("celular"));
           
           
           
           listaFuncionario.add(novoFuncionario);
           
       }
       return listaFuncionario;
   } //FIM LISTAR    
    
    public ArrayList<Funcionario> verificar(String cpf)throws SQLException, ClassNotFoundException {
        //conexão
        Connection conexao = null;
        //Instancia de Array
        ArrayList<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
        
        try{
            
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(BUSCARPORID);
            pstmt.setString(1,cpf);
            ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
        //a cada loop
            Funcionario novoFuncionario = new Funcionario();
            novoFuncionario.setIdFuncionario(rs.getInt("idfuncionario"));
            novoFuncionario.setNome(rs.getString("nome"));
            novoFuncionario.setRg(rs.getString("rg"));
            novoFuncionario.setCpf(rs.getString("cpf"));
            novoFuncionario.setTelefone(rs.getString("telefone"));
            novoFuncionario.setCelular(rs.getString("celular"));          
           
           listaFuncionario.add(novoFuncionario);           
        }
       return listaFuncionario;
            
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
