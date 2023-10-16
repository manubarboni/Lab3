import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void scrie(Object o, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Object citeste(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws FileNotFoundException {
        List<Echipament> produse = new ArrayList<Echipament>();
        Scanner flux_in = new Scanner(new File("electronice.txt"));
        while(flux_in.hasNextLine()) {
            String linie = flux_in.nextLine();
            String[] campuri = linie.split(";");
            switch(campuri[5]) {
                case "imprimanta": produse.add(new Imprimanta(campuri[0],Integer.parseInt(campuri[1]),Integer.parseInt(campuri[2])
                        ,campuri[3],campuri[4],Tip_produs.IMPRIMANTA,Integer.parseInt(campuri[6]),campuri[7],Integer.parseInt(campuri[8]),campuri[9]));
                break;
                case "copiator": produse.add(new Copiator(campuri[0],Integer.parseInt(campuri[1]),Integer.parseInt(campuri[2])
                        ,campuri[3],campuri[4],Tip_produs.COPIATOR,Integer.parseInt(campuri[6]),campuri[7]));
                break;
                case "sistem de calcul": produse.add(new SistemDeCalcul(campuri[0]
                        ,Integer.parseInt(campuri[1]), Integer.parseInt(campuri[2])
                        ,campuri[3],campuri[4],Tip_produs.SISTEM_DE_CALCUL,campuri[6],Float.parseFloat(campuri[7])
                        ,Integer.parseInt(campuri[8]),Sistem_operare.valueOf(campuri[9].toUpperCase())));
                break;
                default:
                    System.out.println("Produsul nu exista");
                    break;
            }
        }
        int optiune;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("0.Afisare toate");
            System.out.println("1.Afisare Imprimante");
            System.out.println("2.Afisare Copiatoare");
            System.out.println("3.Afisare Sisteme");
            System.out.println("4.Modificare stare echipament");
            System.out.println("5.Setare mod scriere");
            System.out.println("6.Setare format copiere");
            System.out.println("7.Instalare sistem operare");
            System.out.println("8.Afisare vandute");
            System.out.println("9.Scriere/Citire serializate");
            System.out.println("10.Exit");
            System.out.println("Optiune:");
            optiune = in.nextInt();
            switch (optiune) {
                case 0:
                    System.out.println("Toate echipamentele:");
                    for (Echipament echipament : produse) {
                        System.out.println(echipament);
                    }
                    break;
                case 1:
                    System.out.println("Imprimante:");
                    for (Echipament echipament : produse) {
                        if (echipament.getClass() == Imprimanta.class)
                            System.out.println(echipament);
                    }
                    break;
                case 2:
                    System.out.println("Copiatoare:");
                    for (Echipament echipament : produse) {
                        if (echipament.getClass() == Copiator.class)
                            System.out.println(echipament);
                    }
                    break;
                case 3:
                    System.out.println("Sisteme:");
                    for (Echipament echipament : produse) {
                        if (echipament.getClass() == SistemDeCalcul.class)
                            System.out.println(echipament);
                    }
                    break;
                case 4:

                    System.out.println("La ce echipament modificati starea(nr inventar) ");
                    in.nextLine();
                    int prod = Integer.parseInt(in.nextLine());
                    System.out.println("In ce modificati starea ");
                    String rasp = in.nextLine();
                    for (Echipament echipament : produse) {
                        if (echipament.getNr_inv() == prod)
                            echipament.setStare_produs(rasp);
                    }
                    break;
                case 5:
                    System.out.println("La ce imprimanta modificati modul de scriere(nr inventar) ");
                    in.nextLine();
                    prod = Integer.parseInt(in.nextLine());
                    System.out.println("In ce modificati modul ");
                    rasp = in.nextLine();
                    for (Echipament echipament : produse) {
                        if (echipament.getNr_inv() == prod)
                            ((Imprimanta) echipament).setMod_tiparire(rasp);
                    }
                    break;
                case 6:
                    System.out.println("La ce copiator modificati formatul(nr inventar) ");
                    in.nextLine();
                    prod = Integer.parseInt(in.nextLine());
                    System.out.println("In ce modificati formatul ");
                    rasp = in.nextLine();
                    for (Echipament echipament : produse) {
                        if (echipament.getNr_inv() == prod)
                            ((Copiator) echipament).setFormat(rasp);
                    }
                    break;
                case 7:
                    System.out.println("La ce sistem modificati sist de operare(nr inventar) ");
                    in.nextLine();
                    prod = Integer.parseInt(in.nextLine());
                    System.out.println("In ce modificati sistemul de operare ");
                    rasp = in.nextLine();
                    for (Echipament echipament : produse) {
                        if (echipament.getNr_inv() == prod)
                            ((SistemDeCalcul) echipament).setSist_operare(Sistem_operare.valueOf(rasp.toUpperCase()));
                    }
                case 8:
                    System.out.println("Produse vandute:");
                    for (Echipament echipament : produse) {
                        if (echipament.getStare_produs().equalsIgnoreCase("VANDUT"))
                            System.out.println(echipament);
                    }
                    break;
                case 9:
                    scrie(produse,"echip.bin");
                    List<Echipament> q;
                    q = (List<Echipament>) citeste("echip.bin");
                    for (Echipament e : q)
                        System.out.println(e);
                    break;
                case 10:break;
                default:
                    System.out.println("Optiune invalida");
                    break;
            }
        }while(optiune!=10);
    }
}
