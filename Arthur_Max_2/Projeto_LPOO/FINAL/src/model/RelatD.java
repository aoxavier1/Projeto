
package model;


/**
 *
 * @author Max
 */
public class RelatD extends Relatorio{
    private int Qtdv;
    private int Km;
    private int Qtdon;
    private Double  Lucro;

   

    public RelatD(int Qtdv, int Km, int Qtdon, Double Lucro, int Id, String Data) {
        super(Id, Data);
        this.Qtdv = Qtdv;
        this.Km = Km;
        this.Qtdon = Qtdon;
        this.Lucro = Lucro;
    }

    

    public RelatD() {
        
    }

    public int getQtdv() {
        return Qtdv;
    }

    public void setQtdv(int Qtdv) {
        this.Qtdv = Qtdv;
    }

    public int getKm() {
        return Km;
    }

    public void setKm(int Km) {
        this.Km = Km;
    }

    public int getQtdon() {
        return Qtdon;
    }

    public void setQtdon(int Qtdon) {
        this.Qtdon = Qtdon;
    }

    public Double getLucro() {
        return Lucro;
    }

    public void setLucro(Double Lucro) {
        this.Lucro = Lucro;
    }

    
}
