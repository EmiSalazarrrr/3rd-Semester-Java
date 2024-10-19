package per;

import java.util.Scanner;

public class PER {
    static Scanner leer = new Scanner(System.in);

    void AlmacenarDatos(int[] Vector, int i, int X) {
        System.out.println("Ingresa el valor para la posición " + i);
        Vector[i] = leer.nextInt();
        if (i < X - 1) { // El límite es X-1 para no salir del índice del arreglo
            AlmacenarDatos(Vector, i + 1, X);
        }
    }

    void MostrarDatos(int[] Vector, int i, int X) {
        System.out.println("Posición " + i + " : " + Vector[i]);
        if (i < X - 1) { // De nuevo, X-1 es el límite del índice
            MostrarDatos(Vector, i + 1, X);
        }
    }

    int SumarElementos(int[] Vector, int i, int X) {
        if (i == X) { // Condición de salida
            return 0;
        }
        return Vector[i] + SumarElementos(Vector, i + 1, X);
    }

    double Promedio(int[] Vector, int i, int Suma) {
        if (i == Vector.length) { // Condición de salida
            return (double) Suma / Vector.length;
        }
        return Promedio(Vector, i + 1, Suma);
    }

    void Mover(int[] Vector, int i) {
        if (i > 0) { // Condición de salida
            int Aux = Vector[i];
            Vector[i] = Vector[i - 1];
            Vector[i - 1] = Aux;
            Mover(Vector, i - 1);
        }
    }

    public static void main(String[] args) {
        int X, opc;
        PER objeto = new PER();
        System.out.println("¿Cuántos datos almacenarás en el vector?");
        X = leer.nextInt();
        int[] Vector = new int[X];
        do {
            System.out.println("Elige qué hacer: ");
            System.out.println("1.- Llenar el vector. ");
            System.out.println("2.- Mostrar el vector. ");
            System.out.println("3.- Sumar elementos. ");
            System.out.println("4.- Calcular promedio. ");
            System.out.println("5.- Mover un nivel hacia arriba. ");
            System.out.println("6.- Salir. ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    objeto.AlmacenarDatos(Vector, 0, X);
                    break;
                case 2:
                    objeto.MostrarDatos(Vector, 0, X);
                    break;
                case 3:
                    int Suma = objeto.SumarElementos(Vector, 0, X);
                    System.out.println("La suma de los elementos es: " + Suma);
                    break;
                case 4:
                    int sumaTotal = objeto.SumarElementos(Vector, 0, X);
                    double promedio = objeto.Promedio(Vector, 0, sumaTotal);
                    System.out.println("El promedio es: " + promedio);
                    break;
                case 5:
                    objeto.Mover(Vector, X - 1); // Comienza desde el último índice
                    break;
            }
        } while (opc != 6);
    }
}
