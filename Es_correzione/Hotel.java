import java.util.ArrayList;

// ===== Classe base Camera =====
class Camera {
    private int numero;
    private float prezzo;

    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }

    // Getter e Setter
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public float getPrezzo() { return prezzo; }
    public void setPrezzo(float prezzo) { this.prezzo = prezzo; }

    // Metodo overload: dettagli()
    public void dettagli() {
        System.out.println("Camera n° " + numero + ", Prezzo: " + prezzo + " €");
    }

    public void dettagli(boolean conPrezzo) {
        if (conPrezzo)
            System.out.println("Camera n° " + numero + ", Prezzo: " + prezzo + " €");
        else
            System.out.println("Camera n° " + numero);
    }
}

// ===== Sottoclasse Suite =====
class Suite extends Camera {
    private String serviziExtra;

    public Suite(int numero, float prezzo, String serviziExtra) {
        super(numero, prezzo);
        this.serviziExtra = serviziExtra;
    }

    // Getter e Setter
    public String getServiziExtra() { return serviziExtra; }
    public void setServiziExtra(String serviziExtra) { this.serviziExtra = serviziExtra; }

    // Override di dettagli()
    @Override
    public void dettagli() {
        System.out.println("Suite n° " + getNumero() + ", Prezzo: " + getPrezzo() +
                " €, Servizi extra: " + serviziExtra);
    }
}

// ===== Classe Hotel =====
class Hotel {
    private String nome;
    private ArrayList<Camera> camere;

    public Hotel(String nome) {
        this.nome = nome;
        this.camere = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public void aggiungiCamera(Camera c) {
        camere.add(c);
    }

    public ArrayList<Camera> getCamere() {
        return camere;
    }

    // Metodo statico per contare le Suite
    public static int contaSuite(ArrayList<Camera> lista) {
        int count = 0;
        for (Camera c : lista) {
            if (c instanceof Suite) count++;
        }
        return count;
    }
}

// ===== Main =====
public class MainHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Bel Soggiorno");

        // Aggiungi camere normali
        Camera c1 = new Camera(101, 80.0f);
        Camera c2 = new Camera(102, 85.5f);

        // Aggiungi suite
        Suite s1 = new Suite(201, 150.0f, "Jacuzzi");
        Suite s2 = new Suite(202, 160.0f, "Sauna privata");

        hotel.aggiungiCamera(c1);
        hotel.aggiungiCamera(c2);
        hotel.aggiungiCamera(s1);
        hotel.aggiungiCamera(s2);

        // Usa overload dettagli()
        System.out.println("=== Tutte le camere (dettagli completi)===");
        for (Camera c : hotel.getCamere()) {
            c.dettagli(); // stampa dettagli, polimorfico!
        }

        System.out.println("\n=== Tutte le camere (solo numero)===");
        for (Camera c : hotel.getCamere()) {
            c.dettagli(false); // overload: solo numero
        }

        // Metodo statico per contare suite
        int numSuite = Hotel.contaSuite(hotel.getCamere());
        System.out.println("\nNumero di suite: " + numSuite);
    }
}
