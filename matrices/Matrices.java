//Joel Emiliano Salazar Figueroa
package matrices;

import java.util.Scanner;

public class Matrices {
    
    String [][] nombres = new String [2][2];
    int [][] edades = new int [2][2];
    static Scanner leer = new Scanner(System.in);

void almacenar(){
      for(int r = 0; r < 2; r++){
          for(int c = 0;c < 2; c++ ){
            System.out.println("Captura un nombre: "+r+" "+c);
            nombres[r][c] = leer.next();
            System.out.println("Captra una edad: "+r+" "+c);
            edades[r][c] = leer.nextInt();
          }
      }  
    } //Almacenar
    void mostrar(){
        for(int r = 0; r < 2; r++){
            System.out.println("MATRIZ DE NOMBRS");
            for(int c = 0; c < 2; c++){
            System.out.println(" "+nombres[r][c]);
            }
            System.out.println(" ");
        }
        System.out.println("MATRIZ DE EDADES");
        for(int r = 0; r < 2; r++){
            for(int c = 0; c < 2; c++){
            System.out.print(" "+edades[r][c]);
            }
            System.out.println(" ");
        }
        System.out.println("MATRICES JUNTAS");
        for(int r = 0; r < 2; r++){
            for(int c = 0; c < 2; c++){
            System.out.print(" "+nombres[r][c]+" "+edades[r][c]);
            }
            System.out.println(" ");

            
        }
    }
    public static void main(String[] args) {    
        Matrices objeto = new Matrices();
        int opcion;
        do{
            System.out.println("1.- Almacenar");
            System.out.println("2.- Mostrar");
            System.out.println("3.- Salir");
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    objeto.almacenar();
                    break;
                case 2:
                    objeto.mostrar();
                    break;
            }   
        }while(opcion != 3);
    }

}