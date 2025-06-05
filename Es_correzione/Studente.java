import java.util.ArrayList;

// ===== Classe Studente =====
class Studente {
    private static int nextId = 1; // Statico: condiviso tra tutte le istanze
    private int id;                // Id univoco per ogni studente
    private String nome;
    private int voto;

    // Costruttore
    public Studente(String nome, int voto) {
        this.nome = nome;
        setVoto(voto);     // Usa il setter per validazione voto
        this.id = nextId++; // Auto-incrementa l'id
    }

    // Getter per il nome
    public String getNome() {
        return nome;
    }

    // Getter per il voto
    public int getVoto() {
        return voto;
    }

    // Getter per l'id
    public int getId() {
        return id;
    }

    // Setter per il voto (solo se valido)
    public void setVoto(int nuovoVoto) {
        if (nuovoVoto >= 0 && nuovoVoto <= 10) {
            this.voto = nuovoVoto;
        } else {
            System.out.println("Errore: voto non valido!");
        }
    }

    // Rappresentazione stringa per stampa
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Voto: " + voto;
    }
}

// ===== Main di test =====
public class MainIncapsulamento {
    // Metodo di utilità per cercare studente per nome
    public static Studente cercaPerNome(ArrayList<Studente> lista, String nome) {
        for (Studente s : lista) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Crea una lista di studenti
        ArrayList<Studente> studenti = new ArrayList<>();

        // Crea e aggiungi alcuni studenti
        Studente s1 = new Studente("Marta", 8);
        Studente s2 = new Studente("Luca", 7);
        studenti.add(s1);
        studenti.add(s2);

        // Stampa studenti iniziali
        System.out.println("Studenti iniziali:");
        for (Studente s : studenti) {
            System.out.println(s);
        }

        // Prova a cambiare il voto con valore valido e non valido
        System.out.println("\nCambio voto di Marta a 9:");
        s1.setVoto(9);
        System.out.println(s1);

        System.out.println("\nTentativo di assegnare voto non valido a Marta:");
        s1.setVoto(15); // Errore

        // Gestione arraylist: aggiunta di un nuovo studente
        Studente s3 = new Studente("Giulia", 10);
        studenti.add(s3);

        // Stampa elenco aggiornato
        System.out.println("\nStudenti dopo aggiunta:");
        for (Studente s : studenti) {
            System.out.println(s);
        }

        // Ricerca per nome
        String nomeRicerca = "luca";
        Studente trovato = cercaPerNome(studenti, nomeRicerca);
        System.out.println("\nRisultato ricerca per nome '" + nomeRicerca + "':");
        if (trovato != null) {
            System.out.println(trovato);
        } else {
            System.out.println("Nessuno studente trovato con quel nome.");
        }
    }
}
