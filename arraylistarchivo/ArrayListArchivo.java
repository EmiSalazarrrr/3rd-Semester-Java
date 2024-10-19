package arraylistarchivo;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListArchivo {
    static Scanner leer = new Scanner (System.in);
    BufferedReader leer2 = new BufferedReader (new InputStreamReader(System.in));
    static ArrayList<String> nombres = new ArrayList<>();
    static ArrayList<Integer> edades = new ArrayList<>();
    
    static String AccesoArchivo = "personas.dat";
    FileOutputStream AbrirFlujoEscribir;
    DataOutputStream EscribirArchivoBinario;
    FileInputStream AbrirFlujoLectura;
    DataInputStream LecturaArchivoBinario;
    
    void AlmacenarPersonas(){
        for (int i = 0; i < 5; i++) {
            try{
                String Nombre ="";
                int Edad = 0;
                System.out.println("Capturar un nombre: ");
                Nombre = leer2.readLine();
                nombres.add(Nombre);
                System.out.println("Capturar una edad: ");
                Edad = leer.nextInt();
                edades.add(Edad);
            }catch(NumberFormatException w){
                System.out.println("Error de formato"+w);
            }catch(Exception e){
                    System.out.println("Error de formato "+e);
            }
        }
    }   
    
    void MostrarPersonas(){
        System.out.println("Se mostrarán las personas...");
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(i+" Nombre: "+nombres.get(i));
            System.out.println(i+" Edad: "+edades.get(i));
        }
    }
    
    void ContarAdultos(){
        int contador = 0;
        for (int edad : edades) {
            if (edad>=18&&edad<65)
                contador++;
        }
        System.out.println("Número de adultos: " + contador);
    }
    
    void ContarTerceraEdad(){
        int Contador = 0;
        for (int edad : edades){
            if (edad>65)
                Contador++;
        }
        System.out.println("Número de adultos mayores: "+Contador);
    }
    
    void GuardarArchivo() throws FileNotFoundException, IOException{
        AbrirFlujoEscribir = new FileOutputStream(AccesoArchivo, true);
        EscribirArchivoBinario = new DataOutputStream (AbrirFlujoEscribir);
        for (int i = 0; i < nombres.size(); i++) {
            System.out.println("GUARDANDO ARCHIVO");
            EscribirArchivoBinario.writeUTF(nombres.get(i));
            EscribirArchivoBinario.writeInt(edades.get(i));
        }
        EscribirArchivoBinario.close();
        AbrirFlujoEscribir.close();
    }
    
    void MostrarArchivo() throws FileNotFoundException, IOException{
        AbrirFlujoLectura = new FileInputStream (AccesoArchivo);
        LecturaArchivoBinario = new DataInputStream (AbrirFlujoLectura);
        System.out.println("Mostrando contenido del archivo: ");
        while(LecturaArchivoBinario.available()!=0){
            System.out.println(" Nombre: "+LecturaArchivoBinario.readUTF());
            System.out.println(" Edad: "+ LecturaArchivoBinario.readInt());
        }
        LecturaArchivoBinario.close();
        AbrirFlujoLectura.close();
    }
    
    void BuscarPersona(){
        String Nombre;
        System.out.println("Ingrese el nombre a buscar: ");
        Nombre = leer.next();
        for (int i = 0; i < nombres.size(); i++) {
            if(nombres.get(i).equals(Nombre))
                System.out.println("Persona encontrada en posición: "+ i + "Nombre: "+nombres.get(i)+", Edad: " + edades.get(i) );
                break;
        }
    }
    
    void ModificarPersona(){
        String Nombre, NuevoNombre;
        int NuevaEdad;
        System.out.println("Ingrese nombre de la persona a modificar: ");
        Nombre = leer.next();
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).equals(Nombre)) {
                System.out.println("Nuevo nombre: ");
                NuevoNombre = leer.next();
                System.out.println("Nueva edad: ");
                NuevaEdad = leer.nextInt();
                nombres.set(i, NuevoNombre);
                edades.set(i, NuevaEdad);
                break;
            }
        }
    }   
    
    void EliminarPersona(){
        String NombreEliminar;
        System.out.println("Ingrese el nombre a eliminar: ");
        NombreEliminar = leer.next();
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).equals(NombreEliminar)) {
                nombres.remove(i);
                edades.remove(i);
                System.out.println("Persona eliminada.");
                break;
            }
        }
    }
    
    void MostrarInverso(){
        System.out.println("Lista en orden inverso: ");
        for (int i = nombres.size() - 1; i < 0; i--) {
            System.out.println("Nombre: "+nombres.get(i)+", Edad: "+edades.get(i));
        }
    }
    
    void SumarEades(){
        int suma = 0;
        for (int edad : edades)
            suma += edad;
        System.out.println("Suma de las edades: "+suma);
    }
    
    void CalcularMedia(){
        int Suma = 0;
        if(edades.isEmpty()){
            System.out.println("No hay personas registradas");
            return;
        }
        for(int edad : edades){
            Suma+= edad;
        }
        double Media = (double) Suma/edades.size();
        System.out.println("Media: "+Media);
    }
    
    void PasarMatriz(){
        int[][] Matriz = new int[edades.size()][1];
        for (int i = 0; i < edades.size(); i++) {
            Matriz[i][0] = edades.get(i);
        }
        System.out.println("Edades en matriz: ");
        for(int []fila : Matriz)
            System.out.println(fila[0]);
    }
    
    public static void main(String[] args) throws IOException {
        ArrayListArchivo objeto = new ArrayListArchivo();
        int opc;
        do{
            System.out.println("Menu:");
            System.out.println("1.- Almacenar personas.");
            System.out.println("2.- Mostrar personas.");
            System.out.println("3.- Contar adultos.");
            System.out.println("4.- Contar tercera edad.");
            System.out.println("5.- Almacenar archivo.");
            System.out.println("6.- Mostrar archivo.");
            System.out.println("7.- Buscar persona.");
            System.out.println("8.- Modificar persona.");
            System.out.println("9.- Eliminar persona.");
            System.out.println("10.- Mostrar inverso.");
            System.out.println("11.- Sumar edades.");
            System.out.println("12.- Calcular media de edades.");
            System.out.println("13.- Pasar edades a matriz.");
            System.out.println("14.- Salir.");
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    objeto.AlmacenarPersonas();
                    break;
                case 2:
                    objeto.MostrarPersonas();
                    break;
                case 3:
                    objeto.ContarAdultos();
                    break;
                case 4:
                    objeto.ContarTerceraEdad();
                    break;
                case 5:
                    objeto.GuardarArchivo();
                    break;
                case 6:
                    objeto.MostrarArchivo();
                    break;
                case 7:
                    objeto.BuscarPersona();
                    break;
                case 8:
                    objeto.ModificarPersona();
                    break;
                case 9:
                    objeto.EliminarPersona();
                    break;
                case 10:
                    objeto.MostrarInverso();
                    break;
                case 11:
                    objeto.SumarEades();
                    break;
                case 12:
                    objeto.CalcularMedia();
                    break;
                case 13:
                    objeto.PasarMatriz();
                    break;
            }
            
        }while(opc!=14);       
    }
    
}