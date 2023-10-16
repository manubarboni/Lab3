import java.io.Serializable;

public class Echipament implements Serializable {
    private String denumire;
    private int nr_inv;
    private int pret;
    private String zona_mag;
    private String stare_produs;
    private Tip_produs tip;

    public Echipament(String denumire, int nr_inv, int pret, String zona_mag, String stare_produs, Tip_produs tip) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare_produs = stare_produs;
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Echipament{" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", stare_produs=" + stare_produs +
                ", tip=" + tip + " ";
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public void setStare_produs(String stare_produs) {
        this.stare_produs = stare_produs;

    }

    public String getStare_produs() {
        return stare_produs;
    }
}
