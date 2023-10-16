public class SistemDeCalcul extends Echipament{
    private String tip;
    private float vit_proc;
    private int c_hdd;
    private Sistem_operare sist_operare;

    public SistemDeCalcul(String denumire, int nr_inv, int pret, String zona_mag, String stare_produs, Tip_produs tip, String tip1, float vit_proc, int c_hdd, Sistem_operare sist_operare) {
        super(denumire, nr_inv, pret, zona_mag, stare_produs, tip);
        this.tip = tip1;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sist_operare = sist_operare;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tip='" + tip + '\'' +
                ", vit_proc=" + vit_proc +
                ", c_hdd=" + c_hdd +
                ", sist_operare='" + sist_operare + '\'' +
                '}';
    }

    public void setSist_operare(Sistem_operare sist_operare) {
        this.sist_operare = sist_operare;
    }
}
