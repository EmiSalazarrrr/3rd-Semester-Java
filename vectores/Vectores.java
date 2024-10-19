
package vectores;

import java.util.Scanner;

public class Vectores {
    static int N;
    static double []edades;
    static String []nombre;
    static Scanner leer = new Scanner (System.in);
    
     void Iniciar(int N){
        edades = new double[N];
        nombre = new String[N];
       
    }
    
    void almacenar(){
        for(int i= 0; i < edades.length; i++){
            System.out.println("Capturar un nombre: ");
            nombre[i] = leer.next();
            System.out.println("Capturar una edad: ");
            edades[i] = leer.nextInt();
        
        }//For
    }//Almacenar
        
    void mostrar(){
        for (int i = 0; i < edades.length; i++) {
            System.out.println("  "+nombre[i]+"  "+edades[i]);
        }
    }//Mostrar
    void buscar(){
        String buscar = "";
        System.out.println("Ingresa el nombre a buscar: ");
        buscar = leer.next();
        for (int i = 0; i < N; i++) {
            if(nombre[i].equals(buscar)){
                System.out.println("Se encontró en el casillero: "+i);
                System.out.println("Nombre: "+nombre[i]);
                System.out.println("Edad: " + edades[i]);
            }
        }//For
    }//Buscar
    
    void eliminar(){
        String buscar = "";
        System.out.println("Captura el dato a borrar");
        buscar = leer.next();
        for (int i = 0; i < edades.length; i++) {
            System.out.println("Se buscará. ");
            System.out.println("Nombre: "+nombre[i]);
            System.out.println("Edad: "+edades[i]);
            nombre[i]=null;
            edades[i] = 0;
        }//for
    }//buscar
    
    void moverFte2(){
        try{
        String tn1,tn2,tne3;
        double te1,te2,te3;
        tn1=nombre[N-1];
        te1=edades[N-1];
        for (int i = edades.length; i>= edades.length; i--){
            nombre [i]=nombre[i-1];
            edades [i]=edades[i-1];
        }
        nombre[0]=tn1;
        edades[0]=te1;
        }catch(Exception e ){
            System.out.println("Movidos.");
        }
    }//Mover
    
    public static void main(String[] args) {
        Vectores objeto= new Vectores();
        System.out.println("Cuantos datos vas a registrar?");
        N = leer.nextInt();
        objeto.Iniciar(N);
        int opc = 0;
        do{
            System.out.println("1.- Almacenar  ");
            System.out.println("2.- Mostrar  ");
            System.out.println("3.- Buscar  ");
            System.out.println("4.- Eliminar  ");
            System.out.println("5.- Mover");
            System.out.println("6.- Salir");
            opc = leer.nextInt();
            switch(opc){
                case 1: 
                    objeto.almacenar();
                    break;
                case 2:
                    objeto.mostrar();
                    break;
                case 3:
                    objeto.buscar();
                    break;
                case 4: 
                    objeto.eliminar();
                    break;
                case 5:
                    objeto.moverFte2();
                
            }
        }while(opc!=6);
    }//Main
}//Clase
