
package Modelo;

import java.util.Date;

public class Locacao {
    private int idLocacao;
    private Date dataInicial;
    private Date dataFinal;
    private boolean chequeCalcao;
    private boolean pago;
    private double valor;
    private String formaDePagamento;
    private Cliente cliente;


    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isChequeCalcao() {
        return chequeCalcao;
    }

    public void setChequeCalcao(boolean chequeCalcao) {
        this.chequeCalcao = chequeCalcao;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    

    
    
    

    
  
    
    
    
}
