/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Max
 */
    public class CustoE extends Custo{
    
    private int Qtd;
    private Double Preco;
    
    
    public CustoE() {
    }

    public CustoE(int Qtd, Double Preco) {
        this.Qtd = Qtd;
        this.Preco = Preco;
    }

    public CustoE(int Qtd, Double Preco, int Id, String Data, String Nome) {
        super(Id, Data, Nome);
        this.Qtd = Qtd;
        this.Preco = Preco;
    }


   
    public int getQtd() {
        return Qtd;
    }

    public void setQtd(int Qtd) {
        this.Qtd = Qtd;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double Preco) {
        this.Preco = Preco;
    }

    
    
  
}
