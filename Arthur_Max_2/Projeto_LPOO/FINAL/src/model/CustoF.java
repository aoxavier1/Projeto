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
public class CustoF extends Custo{
    
    private String Prd;
    private Double Preco;
    
    public CustoF (){
        
    }

    public CustoF(String Prd, Double Preco) {
        this.Prd = Prd;
        this.Preco = Preco;
    }

    public CustoF(String Prd, Double Preco, int Id, String Data, String Nome) {
        super(Id, Data, Nome);
        this.Prd = Prd;
        this.Preco = Preco;
    }

    public String getPrd() {
        return Prd;
    }

    public void setPrd(String Prd) {
        this.Prd = Prd;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double Preco) {
        this.Preco = Preco;
    }

     
    
}
    
