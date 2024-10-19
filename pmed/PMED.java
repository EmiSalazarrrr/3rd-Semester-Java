package pmed;

import java.util.Scanner;

public class PMED {
    
    static Scanner leer = new Scanner(System.in);
    
    void BuscarDato(int [][]edades,int NR,int NC){
        System.out.println("Introduce la edad que deseas buscar:");
                    int buscarEdad = leer.nextInt();
                    boolean encontrado = false;
                    for (int i = 0; i < NR; i++) {
                        for (int j = 0; j < NC; j++) {
                            if (edades[i][j] == buscarEdad) {
                                System.out.println("La edad " + buscarEdad + " se encuentra en la posición [" + i + "][" + j + "]");
                                encontrado = true;
                            }
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Edad no encontrada.");
                    }
    }//Buscar Dato
    
    void Modificar(int [][]edades, int NR, int NC){
        int fila, columna;
                    System.out.println("Introduce la fila y columna de la edad que deseas modificar:");
                    fila = leer.nextInt();
                    columna = leer.nextInt();
                    if (fila >= 0 && fila < NR && columna >= 0 && columna < NC) {
                        System.out.println("Introduce la nueva edad válida (>0):");
                        int nuevaEdad;
                        do {
                            nuevaEdad = leer.nextInt();
                        } while (nuevaEdad <= 0);
                        edades[fila][columna] = nuevaEdad;
                        System.out.println("Edad modificada correctamente.");
                    } else {
                        System.out.println("Posición inválida.");
                    }
    }//Modificar 
    
    void Promedio (int[][]edades, int NR, int NC){
        int suma = 0;
                    for (int i = 0; i < NR; i++) {
                        for (int j = 0; j < NC; j++) {
                            suma += edades[i][j];
                        }
                    }
                    double promedio = (double) suma / (NR*NC);
                    System.out.println("El promedio de las edades es: " + promedio);
    }//Promedio
    
    void EdadMayor (int [][]edades, int NR, int NC){
        int mayor = edades[0][0];
                    for (int i = 0; i < NR; i++) {
                        for (int j = 0; j < NC; j++) {
                            if (edades[i][j] > mayor) {
                                mayor = edades[i][j];
                            }
                        }
                    }
                    System.out.println("La edad mayor es: " + mayor);
    }//Edad Mayor
    
    void EdadMenor (int [][]edades, int NR, int NC){
        int menor = edades[0][0];
        for (int i = 0; i < NR; i++) {
            for (int j = 0; j < NC; j++) {
                if (edades[i][j] < menor) {
                    menor = edades[i][j];
                }
            }
        }
        System.out.println("La edad menor es: " + menor);
    }//Edad Menor
    
    void ImprimirPrmUltDato(int [][]edades, int NR, int NC){
        System.out.println("El primer dato es: " + edades[0][0]);
        System.out.println("El último dato es: " + edades[NR - 1][NC - 1]);
    }//Imprimir Primer y Ultimo Dato
    
    void ImprimirMedio(int[][]edades, int NR, int NC){
        int mitad = (NR*NC) / 2;
        int filaMitad = mitad / NC;
        int columnaMitad = mitad % NC;
        System.out.println("El dato de en medio es: " + edades[filaMitad][columnaMitad]);        
    }//Imprimir Dato de Medio
    
    void PasarVector (int[][]edades,int[]vector, int NR, int NC){
        int index = 0;
        for (int i = 0; i < NR; i++) {
            for (int j = 0; j < NC; j++) {
                vector[index] = edades[i][j];
                    index++;
            }
        }
        System.out.println("Los datos han sido pasados a un vector.");        
    }//Pasar a Vector
    
    public static void main(String[] args) {
        int NR, NC, opc;
        PMED objeto = new PMED(); 
        System.out.println("Introduce el número de renglones:");
        NR = leer.nextInt();
        System.out.println("Introduce el número de columnas:");
        NC = leer.nextInt();
        int[][] edades = new int[NR][NC];
        int[] vector = new int[NR*NC];
        int aux;
        // Llenado de la matriz con validación
        for (int i = 0; i < NR; i++) {
            for (int j = 0; j < NC; j++) {
                System.out.println("Introduce una edad para la posición [" + i + "][" + j + "]:");
                aux = leer.nextInt();
                if(aux<0){
                    System.out.println("La edad debe ser mayor que 0");
                }
                else{
                    edades[i][j] = aux;
                }
            }
        }

        do {
            System.out.println("Elige una opción");
            System.out.println("1. Buscar un dato");
            System.out.println("2. Modificar una edad");
            System.out.println("3. Calcular promedio de edades");
            System.out.println("4. Determinar edad mayor");
            System.out.println("5. Determinar edad menor");
            System.out.println("6. Imprimir el primer y último dato");
            System.out.println("7. Imprimir el dato de en medio");
            System.out.println("8. Pasar datos de la matriz a un vector");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    objeto.BuscarDato(edades, NR, NC);
                    break;
                case 2:
                    objeto.Modificar(edades, NR, NC);
                    break;
                case 3:
                    objeto.Promedio(edades, NR, NC);
                    break;
                case 4:
                    objeto.EdadMayor(edades, NR, NC);
                    break;
                case 5:
                    objeto.EdadMenor(edades, NR, NC);
                    break;
                case 6:
                    objeto.ImprimirPrmUltDato(edades, NR, NC);
                    break;
                case 7:
                    objeto.ImprimirMedio(edades, NR, NC);
                    break;
                case 8:
                    objeto.PasarVector(edades, vector, NR, NC);
                    break;
            }
        } while (opc != 9);
       
    }
    
}
