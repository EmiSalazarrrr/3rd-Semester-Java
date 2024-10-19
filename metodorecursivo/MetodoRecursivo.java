package metodorecursivo;

import java.util.Scanner;

public class MetodoRecursivo {
    
    static int resul = 1;
    static double potencia (int r, int n, int p, int contar){
        if(contar<=p){
            resul=r; //estado base 
            potencia(r*n,n,p,contar+1);
        }
        return resul;
    }
    public static void main(String[] args) {    
        Scanner leer = new Scanner (System.in);
        int n,p;
        double r;
        MetodoRecursivo objeto = new MetodoRecursivo();
        System.out.println("Capturar un numero entero: ");
        n = leer.nextInt();
        System.out.println("Capturar la potencia: ");
        p = leer.nextInt();
        r = potencia(1,n,p,0);
        System.out.println("La potencia es: " +r);
        
    }
    
}
