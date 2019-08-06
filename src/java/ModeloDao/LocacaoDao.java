package ModeloDao;

import Modelo.Cliente;
import Modelo.Locacao;
import Util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LocacaoDao {    
    private static final String CADASTRARLOCACAO = "insert into locacao(datainicial,datafinal,chequecalcao,pago,valor,formadepagamento,idclientefk) values (?,?,?,?,?,?,?)";
    private static final String ATUALIZAR = "update locacao set  datainicial=?,datafinal=?,chequecalcao=?,pago=?,valor=?,formadepagamento=? where idclientefk";
    private static final String LOCALIZARLOCACAO = "select * from locacao where datainicial = ? and idclientefk = ? ";  
    
    
    public void cadastrarLocacao(Locacao locacao){
       Connection conexao = null;
       try{
            conexao = Conexao.getConexao();                         
            java.sql.Date dISql = new java.sql.Date(locacao.getDataInicial().getTime());
            java.sql.Date dFSql = new java.sql.Date(locacao.getDataFinal().getTime());
          
            PreparedStatement pstmt = conexao.prepareStatement(CADASTRARLOCACAO);        
            pstmt.setDate(1 , dISql);
            pstmt.setDate( 2 , dFSql);
            pstmt.setBoolean( 3 , locacao.isChequeCalcao() );
            pstmt.setBoolean( 4 , locacao.isPago() );
            pstmt.setDouble( 5 , locacao.getValor() );
            pstmt.setString( 6 , locacao.getFormaDePagamento() );            
            pstmt.setInt( 7 , locacao.getCliente().getIdCliente() );    
           
            pstmt.execute();
           
       }catch (Exception e ){
           
           throw new RuntimeException(e);
           
       }finally{
           
           try{conexao.close();
           
           }catch (SQLException ex){
               
               throw new RuntimeException (ex);
           }
    }
   }//FIM CADASTRAR LOCACAO   
    
    public Locacao localizarLocacao(Date data , Cliente cliente) throws SQLException, ClassNotFoundException, ParseException{
       //conexão
       Connection conexao = Conexao.getConexao();
       //criar comando SQL
       PreparedStatement pstmt = conexao.prepareStatement(LOCALIZARLOCACAO);     
        Locacao locacao = new Locacao();   
        pstmt.setDate(1, data);
        pstmt.setInt(2,cliente.getIdCliente());
        
       //executa
        ResultSet rs = pstmt.executeQuery();       
        while (rs.next()){              
            locacao.setIdLocacao(rs.getInt("idlocacao"));
            
            Date datasqli = (rs.getDate("dataInicial"));
            Date datasqlf = (rs.getDate("dataFinal"));
            java.util.Date dti = datasqli;
            java.util.Date dtf = datasqlf;
            locacao.setDataInicial(dti);
            locacao.setDataFinal(dtf);
            locacao.setChequeCalcao(rs.getBoolean("chequecalcao"));
            locacao.setPago(rs.getBoolean("pago"));
            locacao.setValor(rs.getDouble("valor"));
            locacao.setFormaDePagamento(rs.getString("formadepagamento"));
            locacao.setCliente(cliente);            
        }
       return locacao;
   } //FIM LOCALIZAR LOCACAO 
    
    public void atualizar(Locacao locacao){
        Connection conexao = null;
        try {
            conexao = Conexao.getConexao();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
            String dataInicial,dataFinal;
            dataInicial = formato.format(locacao.getDataInicial());
            dataFinal = formato.format(locacao.getDataFinal());        
            PreparedStatement pstmt = conexao.prepareStatement(ATUALIZAR);        
            pstmt.setString( 1 , dataInicial);
            pstmt.setString( 2 , dataFinal);
            pstmt.setBoolean( 3 , locacao.isChequeCalcao() );
            pstmt.setBoolean( 4 , locacao.isPago() );
            pstmt.setDouble( 5 , locacao.getValor() );
            pstmt.setString( 6 , locacao.getFormaDePagamento() );            
            pstmt.setInt( 7 , locacao.getCliente().getIdCliente() );             
            pstmt.execute();
           
        }catch (Exception e ){
           
           throw new RuntimeException(e);
           
        }finally{
           
           try{conexao.close();
           
        }catch (SQLException ex){
               
               throw new RuntimeException (ex);
        }
        }
    }//FIM ATUALIZAR    
    
    
}
