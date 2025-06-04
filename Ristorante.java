import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// ===== Classe base Utente =====
class Utente {
    private String nome;
    private String email;
    private float soldi;

    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.soldi = randomizzaCredito();
    }

    protected float randomizzaCredito() {
        Random rand = new Random();
        return 10 + rand.nextFloat() * 90; // tra 10 e 100 euro
    }

    public void rivalutaCredito() {
        this.soldi = randomizzaCredito();
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public float getSoldi() { return soldi; }

    public void stampaDati() {
        System.out.println("Nome: " + nome + " | Email: " + email + " | Credito: " + String.format("%.2f", soldi));
    }
}

// ===== Classe Ristorante =====
class Ristorante {
    private ArrayList<String> piatti;
    private ArrayList<String> valutazioni;

    public Ristorante() {
        piatti = new ArrayList<>();
        valutazioni = new ArrayList<>();
    }

    public void aggiungiPiatto(String piatto) {
        piatti.add(piatto);
    }

    public void aggiungiValutazione(String valutazione) {
        valutazioni.add(valutazione);
    }

    public void stampaPiatti() {
        System.out.println("Piatti: " + piatti);
    }

    public void stampaValutazioni() {
        System.out.println("Valutazioni: " + valutazioni);
    }
}

// ===== Sottoclasse Chef =====
class Chef extends Utente {
    private int inserimenti = 0;
    private boolean chefCapo = false;
    private Ristorante ristorante;

    public Chef(String nome, String email, Ristorante ristorante) {
        super(nome, email);
        this.ristorante = ristorante;
    }

    public void aggiungiPiatto(String piatto) {
        ristorante.aggiungiPiatto(piatto);
        inserimenti++;
        controllaPromozione();
        System.out.println("Piatto aggiunto da Chef!");
    }

    private void controllaPromozione() {
        if (inserimenti >= 3 && !chefCapo) {
            chefCapo = true;
            System.out.println("Congratulazioni! Ora sei Chef_Capo!");
        }
    }

    @Override
    public void stampaDati() {
        super.stampaDati();
        if (chefCapo) {
            System.out.println("(Ruolo: Chef_Capo)");
        } else {
            System.out.println("(Ruolo: Chef)");
        }
    }
}

// ===== Sottoclasse Critico =====
class Critico extends Utente {
    private int recensioni = 0;
    private boolean criticForte = false;
    private Ristorante ristorante;

    public Critico(String nome, String email, Ristorante ristorante) {
        super(nome, email);
        this.ristorante = ristorante;
    }

    public void aggiungiValutazione(String valutazione) {
        ristorante.aggiungiValutazione(valutazione);
        recensioni++;
        controllaPromozione();
        System.out.println("Valutazione aggiunta da Critico!");
    }

    private void controllaPromozione() {
        if (recensioni >= 3 && !criticForte) {
            criticForte = true;
            System.out.println("Complimenti! Ora sei CRITIC_FORTE!");
        }
    }

    @Override
    public void stampaDati() {
        super.stampaDati();
        if (criticForte) {
            System.out.println("(Ruolo: CRITIC_FORTE)");
        } else {
            System.out.println("(Ruolo: Critico)");
        }
    }
}

// ===== MAIN =====
public class EsercizioEreditarieta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ristorante ristorante = new Ristorante();
        Utente utente = null;
        boolean esci = false;

        while (!esci) {
            System.out.println("\n--- MENU PRINCIPALE ---");
            System.out.println("1. Crea nuovo utente");
            System.out.println("2. Stampa dati utente");
            System.out.println("3. Ricarica credito (rivalutazione)");
            System.out.println("4. Diventa Chef (aggiungi piatto)");
            System.out.println("5. Diventa Critico (aggiungi valutazione)");
            System.out.println("6. Stampa piatti e valutazioni");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            int scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    utente = new Utente(nome, email);
                    System.out.println("Utente creato!");
                    break;

                case 2:
                    if (utente != null) utente.stampaDati();
                    else System.out.println("Crea prima un utente!");
                    break;

                case 3:
                    if (utente != null) {
                        utente.rivalutaCredito();
                        System.out.println("Credito rivalutato!");
                    } else {
                        System.out.println("Crea prima un utente!");
                    }
                    break;

                case 4:
                    if (utente == null) {
                        System.out.println("Crea prima un utente!");
                        break;
                    }
                    if (!(utente instanceof Chef)) {
                        utente = new Chef(utente.getNome(), utente.getEmail(), ristorante);
                        System.out.println("Ora sei uno Chef! Puoi aggiungere piatti.");
                    }
                    System.out.print("Nome piatto da aggiungere: ");
                    String piatto = sc.nextLine();
                    ((Chef) utente).aggiungiPiatto(piatto);
                    break;

                case 5:
                    if (utente == null) {
                        System.out.println("Crea prima un utente!");
                        break;
                    }
                    if (!(utente instanceof Critico)) {
                        utente = new Critico(utente.getNome(), utente.getEmail(), ristorante);
                        System.out.println("Ora sei un Critico! Puoi aggiungere valutazioni.");
                    }
                    System.out.print("Inserisci valutazione: ");
                    String valutazione = sc.nextLine();
                    ((Critico) utente).aggiungiValutazione(valutazione);
                    break;

                case 6:
                    ristorante.stampaPiatti();
                    ristorante.stampaValutazioni();
                    break;

                case 0:
                    esci = true;
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        }
        sc.close();
    }
}
