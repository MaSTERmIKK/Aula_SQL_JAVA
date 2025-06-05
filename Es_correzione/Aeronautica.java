import java.util.ArrayList;

// ===== Classe Aereo =====
class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    public Aereo(String modello, int numeroPosti, String codice) {
        this.modello = modello;
        setNumeroPosti(numeroPosti); // Validazione con setter
        this.codice = codice;
    }

    public String getModello() { return modello; }
    public String getCodice() { return codice; }
    public int getNumeroPosti() { return numeroPosti; }

    public void setModello(String modello) { this.modello = modello; }
    public void setCodice(String codice) { this.codice = codice; }
    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Errore: numero posti deve essere positivo!");
        }
    }

    @Override
    public String toString() {
        return "Codice: " + codice + ", Modello: " + modello + ", Posti: " + numeroPosti;
    }
}

// ===== Classe Pilota =====
class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        setOreVolo(oreVolo); // Validazione con setter
    }

    public String getNome() { return nome; }
    public String getNumeroBrevetto() { return numeroBrevetto; }
    public int getOreVolo() { return oreVolo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setNumeroBrevetto(String numeroBrevetto) { this.numeroBrevetto = numeroBrevetto; }
    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Errore: le ore di volo devono essere maggiori di zero!");
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Brevetto: " + numeroBrevetto + ", Ore di volo: " + oreVolo;
    }
}

// ===== Classe CompagniaAerea =====
class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public void aggiungiAereo(Aereo a) {
        flotta.add(a);
    }

    public void aggiungiPilota(Pilota p) {
        piloti.add(p);
    }

    public void stampaInfo() {
        System.out.println("Compagnia: " + nome);
        System.out.println("--- Flotta ---");
        for (Aereo a : flotta) {
            System.out.println(a);
        }
        System.out.println("--- Piloti ---");
        for (Pilota p : piloti) {
            System.out.println(p);
        }
    }
}

// ===== Main di test =====
public class MainAeronautica {
    public static void main(String[] args) {
        // Crea la compagnia
        CompagniaAerea compagnia = new CompagniaAerea("SkyFly");

        // Crea e aggiungi aerei
        Aereo a1 = new Aereo("Boeing 737", 180, "AX100");
        Aereo a2 = new Aereo("Airbus A320", 160, "A220");
        compagnia.aggiungiAereo(a1);
        compagnia.aggiungiAereo(a2);

        // Crea e aggiungi piloti
        Pilota p1 = new Pilota("Laura Neri", "P123", 2500);
        Pilota p2 = new Pilota("Marco Bianchi", "P456", 1800);
        compagnia.aggiungiPilota(p1);
        compagnia.aggiungiPilota(p2);

        // Stampa le informazioni della compagnia
        compagnia.stampaInfo();
    }
}
