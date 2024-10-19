
package archivovectores;

import java.io.*;
import java.util.Scanner;

public class ArchivoVectores {
    static Scanner leer=new Scanner(System.in);
    BufferedReader leer2=new BufferedReader (new InputStreamReader(System.in));
    static int [] numero=new int[5];
    static String [] nombre=new String[5];
    static double []sueldo = new double[5];
    static int []edad = new int[5];
    void almacenarVector() throws IOException{
        for (int i = 0; i < 5; i++) {
            try{
                System.out.println("Capturar un numero "+i);
                numero[i]=leer.nextInt();
                System.out.println("Capturar un mombre: ");
                nombre[i]=leer2.readLine();
                System.out.println("Capturar el sueldo");
                sueldo[i]=leer.nextDouble();
                System.out.println("Capturar edad: ");
                edad[i] = leer.nextInt();
            }//try
            catch(NumberFormatException w){
                System.out.println("Error de formato "+w);
                i--;
            }//catch
            catch(Exception e){
                System.out.println("Error de formato "+e);
            }//catch  
        }//for
    }//almacenarVector
    void mostrarVector(){
        System.out.println("CONTENIDO DEL VECTOR...");
        for (int i = 0; i < 5; i++) {
            System.out.println(" "+i+" \n");
            System.out.print(" "+numero[i]); //textField
            System.out.print(" "+nombre[i]);
            System.out.print(" "+sueldo[i]);
            System.out.print(" "+edad[i]);
        }//for
    }//mostrarVector
    static String acceso_archivo="binario2.dat";
    FileOutputStream abrirFlujoEscribirFileBinario;
    DataOutputStream EscribirFilebinario;
    void guardarEnBinario() throws FileNotFoundException, IOException{
        abrirFlujoEscribirFileBinario=new FileOutputStream
            (acceso_archivo,true);
        EscribirFilebinario=new DataOutputStream
            (abrirFlujoEscribirFileBinario);
        for (int i = 0; i < 5; i++) {
            System.out.println("Guardando en el archivo binario");
                 //                          (TextField)       
            EscribirFilebinario.writeInt(numero[i]);
            EscribirFilebinario.writeUTF(nombre[i]);
            EscribirFilebinario.writeDouble(sueldo[i]);
            EscribirFilebinario.writeInt(edad[i]);
         }//for
          EscribirFilebinario.close();
          abrirFlujoEscribirFileBinario.close();
    }//Guardarenbinario
    FileInputStream abrirFlujoLecturaFilebinario;
    DataInputStream LeturaFileBinario;
    void mostrarBinario() throws FileNotFoundException, IOException{
        abrirFlujoLecturaFilebinario=new FileInputStream("binario2.dat");
        LeturaFileBinario= new DataInputStream(abrirFlujoLecturaFilebinario);
        System.out.println("MUESTRA CONTENIDO DEL ARCHIVO BINARIO ");
        while(LeturaFileBinario.available()!=0){
            System.out.println("");
            System.out.print(" "+LeturaFileBinario.readInt());
            System.out.print(" "+LeturaFileBinario.readUTF());
            System.out.print(" "+LeturaFileBinario.readDouble());
            System.out.print(" "+LeturaFileBinario.readInt());
        }//while
        LeturaFileBinario.close();
        abrirFlujoLecturaFilebinario.close();
    }//mostrarBinario
    void MostrarPrimero(){
        System.out.println("Primer registro: ");
        System.out.print("Número: " + numero[0]);
        System.out.print(", Nombre: " + nombre[0]);
        System.out.print(", Sueldo: " + sueldo[0]);
        System.out.print(", Edad: " + edad[0]);        
    }
    void MostrarUltimo(){
        int UltimoNumero = numero.length - 1; // Índice del último elemento
        System.out.println("Último registro: ");
        System.out.print("Número: " + numero[UltimoNumero]);
        System.out.print(", Nombre: " + nombre[UltimoNumero]);
        System.out.print(", Sueldo: " + sueldo[UltimoNumero]);
        System.out.print(", Edad: " + edad[UltimoNumero]);
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        ArchivoVectores objeto=new ArchivoVectores();
        int opcion=0;
        do{
        System.out.println("\n menu  ");
        System.out.println("1.-Almacenar vector");
        System.out.println("2.-Mostrar vector");
        System.out.println("3.-Almacenar archivo binario");
        System.out.println("4.-Mostrar archivo binario ");
        System.out.println("5.-Mostrar Primero");
        System.out.println("6.- Mostrar Ultimo");
        System.out.println("7.- Salir");
        opcion=leer.nextInt();
        switch(opcion){
            case 1: objeto.almacenarVector(); break;
            case 2: objeto.mostrarVector();break;
            case 3: objeto.guardarEnBinario();break;
            case 4: objeto.mostrarBinario();break;
            case 5:
                objeto.MostrarPrimero();
                break;
            case 6:
                objeto.MostrarUltimo();
                break;
        }//switch
        }while(opcion!=7);
    }//main
}
