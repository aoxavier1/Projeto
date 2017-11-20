package model;


public class RelatM extends Relatorio{


    private int Kmi;

    private int Kmf;

    private int Perc;

    public RelatM(int Kmi, int Kmf, int Perc, int Id, String Data) {
        super(Id, Data);
        this.Kmi = Kmi;
        this.Kmf = Kmf;
        this.Perc = Perc;
    }

    

    public RelatM() {
        
    }

    /**
     *
     * @return
     */
   
    public int getKmi() {
        return Kmi;
    }

    public void setKmi(int Kmi) {
        this.Kmi = Kmi;
    }

    public int getKmf() {
        return Kmf;
    }

    public void setKmf(int Kmf) {
        this.Kmf = Kmf;
    }

    public int getPerc() {
        return Perc;
    }

    public void setPerc(int Perc) {
        this.Perc = Perc;
    }

    
}

    
