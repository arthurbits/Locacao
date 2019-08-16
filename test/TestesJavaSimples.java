




import Modelo.CarrinhoDeCompra;
import Modelo.Cliente;
import Modelo.Email;
import Modelo.ItemDeCompra;
import Modelo.Locacao;
import Modelo.Produto;
import Modelo.Tipo;
import ModeloDao.LocacaoDao;
import ModeloDao.UsuarioDao;
import Util.Conexao;
import java.sql.SQLException;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
 
public class TestesJavaSimples{
 
    public static void main(String[] args) throws SQLException, ClassNotFoundException  {    
        /*
                LocacaoDao ldao = new LocacaoDao();
                Cliente c = new Cliente();
                c.setIdCliente(1);
                String dataf = "2019-06-20";
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
                Date data = formato.parse(dataf);
                java.sql.Date dataSql = new java.sql.Date(data.getTime());
                Locacao l = ldao.localizarLocacao(dataSql, c);

                 System.out.println("Data Inicial = "+l.getDataInicial());
                 System.out.println("Data Final   = "+l.getDataFinal());
        */
       
      UsuarioDao udao = new UsuarioDao();
      boolean a  = udao.emailExiste("asd");
        System.out.println("Email : "+a);
        boolean b = udao.usuarioExiste("arthur", "123asd");
        System.out.println("Usuario : "+b);
        
       
       
       
       
       
       
       
    }
}

