import java.util.ArrayList;
import java.util.Scanner;

// ===== Classe Dipendente =====
class Dipendente {
    private String nome;
    private double stipendio;
    private String dipartimento;

    public Dipendente(String nome, double stipendio, String dipartimento) {
        this.nome = nome;
        this.stipendio = stipendio;
        this.dipartimento = dipartimento;
    }

    public String getNome() { return nome; }
    public double getStipendio() { return stipendio; }
    public String getDipartimento() { return dipartimento; }

    public void setNome(String nome) { this.nome = nome; }
    public void setStipendio(double stipendio) { this.stipendio = stipendio; }
    public void setDipartimento(String dipartimento) { this.dipartimento = dipartimento; }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Stipendio: " + stipendio + ", Dipartimento: " + dipartimento;
    }
}

// ===== Main: Gestione Lista Dipendenti =====
public class GestioneDipendenti {

    // ===== Funzione main =====
    public static void main(String[] args) {
        ArrayList<Dipendente> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n=== MENU CRUD Dipendenti ===");
            System.out.println("1. Aggiungi Dipendente");
            System.out.println("2. Visualizza Dipendenti");
            System.out.println("3. Modifica Dipendente");
            System.out.println("4. Elimina Dipendente");
            System.out.println("0. Esci");
            System.out.print("Scegli: ");
            scelta = sc.nextInt();
            sc.nextLine(); // pulisci buffer

            switch (scelta) {
                case 1: // ===== Crea (Create) =====
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Stipendio: ");
                    double stipendio = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Dipartimento: ");
                    String dipartimento = sc.nextLine();
                    lista.add(new Dipendente(nome, stipendio, dipartimento));
                    System.out.println("Dipendente aggiunto!");
                    break;

                case 2: // ===== Leggi (Read) =====
                    System.out.println("--- Lista Dipendenti ---");
                    if (lista.isEmpty()) {
                        System.out.println("Nessun dipendente in lista.");
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println((i+1) + ") " + lista.get(i));
                        }
                    }
                    break;

                case 3: // ===== Modifica (Update) =====
                    System.out.print("Numero dipendente da modificare: ");
                    int idx = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idx >= 0 && idx < lista.size()) {
                        Dipendente d = lista.get(idx);
                        System.out.print("Nuovo nome (" + d.getNome() + "): ");
                        String nuovoNome = sc.nextLine();
                        System.out.print("Nuovo stipendio (" + d.getStipendio() + "): ");
                        double nuovoStipendio = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Nuovo dipartimento (" + d.getDipartimento() + "): ");
                        String nuovoDipartimento = sc.nextLine();
                        d.setNome(nuovoNome);
                        d.setStipendio(nuovoStipendio);
                        d.setDipartimento(nuovoDipartimento);
                        System.out.println("Dipendente aggiornato.");
                    } else {
                        System.out.println("Indice non valido.");
                    }
                    break;

                case 4: // ===== Cancella (Delete) =====
                    System.out.print("Numero dipendente da eliminare: ");
                    int idElim = sc.nextInt() - 1;
                    sc.nextLine();
                    if (idElim >= 0 && idElim < lista.size()) {
                        lista.remove(idElim);
                        System.out.println("Dipendente eliminato.");
                    } else {
                        System.out.println("Indice non valido.");
                    }
                    break;

                case 0:
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        sc.close();
    }
}
