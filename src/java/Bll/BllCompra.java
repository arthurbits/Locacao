
package Bll;

import Modelo.Compra;
import Modelo.ItemDeCompra;
import ModeloDao.CompraDao;
import ModeloDao.ItemDeCompraDao;
import java.sql.SQLException;


public class BllCompra {
    public void cadastroCompra(Compra compra) throws SQLException, ClassNotFoundException{
        ItemDeCompraDao idao = new ItemDeCompraDao();
        CompraDao cdao = new CompraDao();
        cdao.cadastrar(compra);
        compra = cdao.buscarCompra(compra.getCliente(), compra.getDataCompra(), compra.getCarrinho());
        for (ItemDeCompra item : compra.getCarrinho().getItens()){
            idao.cadastrarItem(item, compra);
        }
    }
}
