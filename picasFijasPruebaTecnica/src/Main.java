import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int picas, fijas;
        int numeroRamdon = generaNumero();
        System.out.println(numeroRamdon);
        do {

            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese sus numeros de 4 digitos");
            String numRecibido = sc.next();

            ArrayList<String> digitosRecibidos = new ArrayList<>();

            for (int i = 0; i < numRecibido.length(); i++) {
                String digito = String.valueOf(numRecibido.charAt(i));
                digitosRecibidos.add(digito);
            }

            fijas = contarFijas(numeroRamdon, digitosRecibidos);
            picas = contarPicas(numeroRamdon, digitosRecibidos);
            System.out.println("Fijas " +fijas+ " | Picas "+ (picas - fijas));


        } while (fijas != 4);

        System.out.println("FELICITACIONES HAS GANADO");

    }

    public static int generaNumero() {


        ArrayList<Integer> digitos = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digitos.add(i);
        }

        Collections.shuffle(digitos);

        StringBuilder numeroAleatorio = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            numeroAleatorio.append(digitos.get(i));
        }

        int numeroGenerado = Integer.parseInt(numeroAleatorio.toString());
        System.out.println("Número aleatorio de 4 dígitos sin repetir: " + numeroGenerado);
        return numeroGenerado;
    }


    public static int contarPicas(int digitosrandom, ArrayList<String> digitosRecibidos) {
        int picas = 0;
        String numToString =  Integer.toString(digitosrandom);
        ArrayList<String> digitosRamdon = new ArrayList<>();

        for (int i = 0; i < numToString.length(); i++) {
            String digito = String.valueOf(numToString.charAt(i));
            digitosRamdon.add(digito);
        }
        for (int i = 0; i < digitosRamdon.size(); i++) {

            for (int j = 0; j < digitosRecibidos.size(); j++) {
                if (digitosRamdon.get(i).equals(digitosRecibidos.get(j))) {
                    picas++;
                }
            }
        }
        return picas;
    }

    public static int contarFijas(int digitosrandom, ArrayList<String> digitosRecibidos) {
        int fijas = 0;
        String numToString =  Integer.toString(digitosrandom);
        ArrayList<String> digitosRamdon = new ArrayList<>();

        for (int i = 0; i < numToString.length(); i++) {
            String digito = String.valueOf(numToString.charAt(i));
            digitosRamdon.add(digito);
        }
        for (int i = 0; i < digitosRecibidos.size(); i++) {
            if (digitosRamdon.get(i).equals(digitosRecibidos.get(i))) {
                fijas = fijas + 1;
            }
        }
        return fijas;
    }
}