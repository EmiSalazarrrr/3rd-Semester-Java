//Joel Emiliano Salazar Figueroa
package pme;

import java.util.Scanner;

public class PME {
    static int N;
    static double []calificaciones;
    static String []nombres;
    static Scanner leer = new Scanner (System.in);
    
    void Iniciar(int N){
        PME.N = N;
        calificaciones = new double[N];
        nombres = new String[N];
        
    }
    void almacenar(){
        try{
        for (int i = 0; i < N; i++) {
            double T = 0;
            System.out.println("Nombre del alumno: ");
            nombres[i]= leer.next();
            System.out.println("Calificación de "+nombres[i]+":");
            T = leer.nextDouble();
            if (T >= 0) 
                calificaciones[i] = T;
            else{
                System.out.println("La calificación tiene que ser mayor que 0");
                i--; 
                }
        }
        }catch(Exception e){
                System.out.println("Ocurrió un error al almacenar.");
                }
        }//Almacenar 
    void buscar(String NombreEstudiante){
        try{
        for (int i = 0; i < N; i++) {
            if (nombres[i].equalsIgnoreCase(NombreEstudiante)){
                System.out.println("El estudiante está en la posición "+i);
                System.out.println("Estudiante: "+nombres[i]+" calificación: "+calificaciones[i]);
            return;
            }
        }
        System.out.println("Estudiante NO encontrado.");
        }catch(Exception e){
            System.out.println("Error al buscar el estudiante.");
        }
    }//Buscar
    
    void modificar(String NombreEstudiante){
        try{
        double NuevaCal;
        System.out.println("Ingresa la nueva calificación: ");
        NuevaCal = leer.nextInt();
        for (int i = 0; i < N; i++) {
            if (nombres[i].equalsIgnoreCase(NombreEstudiante)){
                calificaciones[i] = NuevaCal;
                System.out.println("Calificación cambiada.");
                return;
            }
        }
        }catch (Exception e){
            System.out.println("Error al modificar.");
        }
    }//Modificar 
    
    void promedio(){
        try{
        double promedio = 0.0;
        for (int i = 0; i < N; i++) {
            promedio += calificaciones[i];
        }
        promedio = promedio/N;
        System.out.println("El promedio de califacaciones es: "+promedio);
        }catch(Exception e){
            System.out.println("Error al sacar el promedio.");
        }
    }//Promedio
    
    void CalificacionMayor(){
        try{
        double Aux = 0.0; 
        String NombreMayor ="";
        for (int i = 0; i < N; i++) {
            if (calificaciones[i]>Aux){
                Aux = calificaciones[i];
                NombreMayor = nombres[i];
            }
        }
        System.out.println("La calificación mayor fue obtenida por: "+NombreMayor
                +"y fue de: "+Aux);
        }catch(Exception e){
            System.out.println("Error al buscar la calificación mayor.");
        }
    }
    
    void CalificacionMenor(){
        try{
        double Aux = 10.0;
        for (int i = 0; i < N; i++) {
            if(calificaciones[i]<Aux)
                Aux = calificaciones[i];
        }
        System.out.println("La calificación menor fue: "+Aux);
        }catch(Exception e){
            System.out.println("Error al encontrar la calificación menor.");   
        }
    }
    
    void Imprimir(){
        try{
            System.out.println("Primer estudiante: " + nombres[0] + ", Calificación: " + calificaciones[0]);
            System.out.println("Último estudiante: " + nombres[N - 1] + ", Calificación: " + calificaciones[N- 1]);
        }catch(Exception e){
            System.out.println("Error al imprimir el primer y último dato del vector.");
        }
    }
    
    void Mover(){
        try{
        String tn1;
        double te1;
        tn1=nombres[N - 1];
        te1=calificaciones[N - 1];
        for (int i = N - 1; i>0; i--){
            nombres[i]=nombres[i-1];
            calificaciones[i]=calificaciones[i-1];
        }
        nombres[0]=tn1;
        calificaciones[0]=te1;
        }catch(Exception e){
            System.out.println("Error al mover los datos.");
        }
    }//Mover
    public static void main(String[] args) {
        int opc;
        String NombreEstudiante;
        PME Objeto = new PME();//Creación del objeto.
        System.out.println("Cuantos alumnos serán?");
        N = leer.nextInt();
        Objeto.Iniciar(N);
        do{
            System.out.println("Selecciona una opción. \n"
                    + "1.-Almacenar. \n"
                    + "2.- Buscar. \n"
                    + "3.- Modificar calificación. \n"
                    + "4.- Calcular promedio. \n"
                    + "5.- Determinar calificación mayor. \n"
                    + "6.- Determinar calificación menor. \n"
                    + "7.- Imprimir el primer y último dato almacenado. \n"
                    + "8.- Reacomodar datos. \n"
                    + "9.- Salir.");
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    Objeto.almacenar();
                    break;
                case 2:
                    System.out.println("Ingresa el estudiante a mostrar: "); 
                    NombreEstudiante = leer.next();
                    Objeto.buscar(NombreEstudiante);
                    break;
                case 3:
                    System.out.println("Ingresa el estudiante al que cambiarás calificación: ");
                    NombreEstudiante = leer.next();
                    Objeto.modificar(NombreEstudiante);
                    break;
                case 4: 
                    Objeto.promedio();
                    break;
                case 5:
                    Objeto.CalificacionMayor();
                    break;
                case 6: 
                    Objeto.CalificacionMenor();
                    break;
                case 7:
                    Objeto.Imprimir();
                    break;
                case 8:
                    Objeto.Mover();
                    break;
            }
        }while (opc!=9);
    }
    
}
