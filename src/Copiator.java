public class Copiator extends Echipament {
    private int p_ton;
    private String format;

    public Copiator(String denumire, int nr_inv, int pret, String zona_mag, String stare_produs, Tip_produs tip, int p_ton, String format) {
        super(denumire, nr_inv, pret, zona_mag, stare_produs, tip);
        this.p_ton = p_ton;
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() +
                "p_ton=" + p_ton +
                ", format='" + format + '\'' +
                '}';
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
