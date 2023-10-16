public class Imprimanta extends Echipament{
    private int ppm;
    private String rezolutie;
    private int p_car;
    private String mod_tiparire;

    public Imprimanta(String denumire, int nr_inv, int pret, String zona_mag, String stare_produs, Tip_produs tip, int ppm, String rezolutie, int p_car, String mod_tiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare_produs, tip);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod_tiparire = mod_tiparire;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ppm=" + ppm +
                ", rezolutie='" + rezolutie + '\'' +
                ", p_car=" + p_car +
                ", mod_tiparire='" + mod_tiparire + '\'' +
                '}';
    }

    public void setMod_tiparire(String mod_tiparire) {
        this.mod_tiparire = mod_tiparire;
    }
}
