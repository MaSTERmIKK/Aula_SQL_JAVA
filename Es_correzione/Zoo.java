import java.util.ArrayList;
import java.util.Scanner;

// ===== Classe base Animale =====
class Animale {
    protected String nome;
    protected int eta;

    public Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public void faiVerso() {
        System.out.println("Verso generico...");
    }

    public String getNome() { return nome; }
    public int getEta() { return eta; }
}

// ===== Sottoclasse Cane =====
class Cane extends Animale {
    public Cane(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Bau!");
    }
}

// ===== Sottoclasse Gatto =====
class Gatto extends Animale {
    public Gatto(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Miao!");
    }
}

// ===== Sottoclasse Pappagallo (terzo animale per lo Zoo) =====
class Pappagallo extends Animale {
    public Pappagallo(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Cip cip!");
    }
}

// ===== Classe Zoo =====
class Zoo {
    private ArrayList<Cane> cani = new ArrayList<>();
    private ArrayList<Gatto> gatti = new ArrayList<>();
    private ArrayList<Pappagallo> pappagalli = new ArrayList<>();

    public void aggiungiCane(Cane c) {
        cani.add(c);
    }
    public void aggiungiGatto(Gatto g) {
        gatti.add(g);
    }
    public void aggiungiPappagallo(Pappagallo p) {
        pappagalli.add(p);
    }

    public void stampaTutti() {
        System.out.println("--- Cani ---");
        for (Cane c : cani) {
            System.out.print("Nome: " + c.getNome() + ", Età: " + c.getEta() + ", Verso: ");
            c.faiVerso();
        }
        System.out.println("--- Gatti ---");
        for (Gatto g : gatti) {
            System.out.print("Nome: " + g.getNome() + ", Età: " + g.getEta() + ", Verso: ");
            g.faiVerso();
        }
        System.out.println("--- Pappagalli ---");
        for (Pappagallo p : pappagalli) {
            System.out.print("Nome: " + p.getNome() + ", Età: " + p.getEta() + ", Verso: ");
            p.faiVerso();
        }
    }
}

// ===== Main =====
public class MainEreditarieta {
    public static void main(String[] args) {
        // Prima parte: array misto di animali
        Animale[] animali = new Animale[2];
        animali[0] = new Cane("Fido", 3);
        animali[1] = new Gatto("Luna", 2);

        System.out.println("=== Animali base ===");
        for (Animale a : animali) {
            System.out.print("Nome: " + a.getNome() + ", Età: " + a.getEta() + ", Verso: ");
            a.faiVerso();
        }

        // Seconda parte: classe Zoo con input utente
        Scanner sc = new Scanner(System.in);
        Zoo zoo = new Zoo();

        System.out.println("\nInserisci animali per lo Zoo:");
        // Aggiunta Cani
        for (int i = 0; i < 2; i++) {
            System.out.print("Inserisci nome cane: ");
            String nome = sc.nextLine();
            System.out.print("Inserisci età cane: ");
            int eta = Integer.parseInt(sc.nextLine());
            zoo.aggiungiCane(new Cane(nome, eta));
        }
        // Aggiunta Gatti
        for (int i = 0; i < 2; i++) {
            System.out.print("Inserisci nome gatto: ");
            String nome = sc.nextLine();
            System.out.print("Inserisci età gatto: ");
            int eta = Integer.parseInt(sc.nextLine());
            zoo.aggiungiGatto(new Gatto(nome, eta));
        }
        // Aggiunta Pappagalli
        for (int i = 0; i < 2; i++) {
            System.out.print("Inserisci nome pappagallo: ");
            String nome = sc.nextLine();
            System.out.print("Inserisci età pappagallo: ");
            int eta = Integer.parseInt(sc.nextLine());
            zoo.aggiungiPappagallo(new Pappagallo(nome, eta));
        }

        System.out.println("\n=== Tutti gli animali dello Zoo ===");
        zoo.stampaTutti();

        sc.close();
    }
}
