




import Modelo.CarrinhoDeCompra;
import Modelo.Cliente;
import Modelo.Email;
import Modelo.ItemDeCompra;
import Modelo.Produto;
import Modelo.Tipo;
import ModeloDao.UsuarioDao;
import Util.Conexao;
import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
 
public class TestesJavaSimples{
 
    public static void main(String[] args) throws SQLException, ClassNotFoundException  {    
        java.sql.Timestamp dataSql = new java.sql.Timestamp(new Date().getTime());  
        System.out.println(dataSql);
        
}}

