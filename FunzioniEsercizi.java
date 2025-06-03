public class FunzioniEsercizi {

    // ===== Esercizio 1: Funzione Base =====
    // Metodo che calcola la somma di due numeri interi
    public static int somma(int a, int b) {
        return a + b;
    }

    // ===== Esercizio 2: Overloading =====
    // Metodo multiply che accetta due interi
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Metodo multiply che accetta tre double
    public static double multiply(double a, double b, double c) {
        return a * b * c;
    }

    // ===== Esercizio 3: Ricorsione - Somma dei numeri naturali =====
    // Metodo ricorsivo che calcola la somma dei primi n numeri naturali
    public static int sommaNaturali(int n) {
        if (n == 1) {
            return 1; // caso base
        }
        return n + sommaNaturali(n - 1); // passo ricorsivo
    }

    // ===== Esercizio 4: Passaggio per Valore & Riferimento =====
    // Metodo che prova a modificare una variabile primitiva (non cambia l'originale)
    public static void modificaPrimitiva(int x) {
        x = 99;
    }

    // Metodo che modifica un array (modifica l'originale)
    public static void modificaArray(int[] arr) {
        arr[0] = 99;
    }

    // ===== MAIN per testare =====
    public static void main(String[] args) {
        // Esercizio 1
        System.out.println("Esercizio 1: somma(3, 4) = " + somma(3, 4));

        // Esercizio 2
        System.out.println("Esercizio 2:");
        System.out.println("multiply(2, 3) = " + multiply(2, 3));
        System.out.println("multiply(2.0, 3.5, 2) = " + multiply(2.0, 3.5, 2));

        // Esercizio 3
        System.out.println("Esercizio 3: sommaNaturali(5) = " + sommaNaturali(5));

        // Esercizio 4
        int num = 5;
        int[] array = {1, 2, 3};

        System.out.println("Esercizio 4: Passaggio per Valore & Riferimento");
        System.out.println("Prima: num = " + num + ", array[0] = " + array[0]);

        modificaPrimitiva(num);
        modificaArray(array);

        System.out.println("Dopo: num = " + num + ", array[0] = " + array[0]);
        // Output atteso:
        // num non cambia, array[0] sì!
    }
}
