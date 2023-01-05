/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pueba_generar_alumno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter; //Para escribir en un archivo 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Obtiene indicador escolar y número de inscripción
 * @author Carmona Ayala Mariana Zoe, Castillo Martinez Diego Leonardo, García Cerda Gerardo Daniel, Lechuga Castillo Shareny Ixchel, Sánchez Medina José Santiago.
 */
public class Pueba_generar_ALUMNO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        Alumno alumno;
        int op = 1;
        int op3 = 3;
        int contra = 345;
        /**
         * Captura información recibida
         */
        Scanner scanner = new Scanner(System.in);

        ArrayList<Alumno> listaPrincipal=new ArrayList();
        int numAlumnos=500;
        float arreglo[]=new float[numAlumnos]; 
        /**
         * Ciclo for 
         */
        for (int i = 0; i < numAlumnos; i++) {
            alumno=new Alumno();
            alumno.generarNombre();
            alumno.generarDireccion();
            alumno.generarHistorialAcademico();
            alumno.generarCalificacion();
            alumno.generarEdad();
            alumno.generarIndicadorEscolar();
            arreglo[i]=alumno.getIndicadorEscolar();//Guardar en un arreglo los indicadores escolares para despues ordenarlos 
            listaPrincipal.add(alumno);
            //System.out.println("en estos omentos soy:"+alumno);
            alumno.generarNumCuenta(listaPrincipal, alumno); 
        }

       listaPrincipal=listaOrdenada(listaPrincipal,arreglo);
       generarCSV(listaPrincipal);
         
       // System.out.println(listaPrincipal);
       /**
        * Nos ayuda que el menú se siga repitiendo constantemente
        */
        while (op == 1){
            /**
             * Impresión de 3 casos: cuando se es alumno, profesor o se desea salir
             */
            System.out.println("========== SSA INGENIERIA ==========");
            System.out.println("INDIQUE QUIEN INTENTA INICIAR SESION");
            System.out.println("1.- Soy Alumno          2.- Soy Profesor");
            System.out.println("3.- Salir");
            
            int op2 = scanner.nextInt();
            /**
             * Dependeindo de la opción tomada, se desplegaran 3 casos
             */
            switch(op2){
               /**
                * Primer caso: alumno
                */
                case 1:
                {
                    int op5 = 1;
                    while(op5 == 1){ //Nos mantenemos en un bucle dentro de este caso hasta que se cumpla alguna condicion (acceso autorizado o acceso denegado)
                        boolean found = false; //Nos ayudara a validar si se encuentra el numero de cuenta ingresado para imprimir dichos datos que coincidan con el numero de cuenta ingresado
                        int index = 0; //Iniciamos el indice en 0
                        System.out.println("INGRESA TU NUMERO DE CUENTA: ");
                        int numC = scanner.nextInt(); //Se ingresa el numero de cuenta
                        
                        for (Alumno alu : listaPrincipal){ //Recorremos los alumnos dentro de la ListaPrincipal
                            if (alu.getNumCuenta() == numC){  //Validamos que alguno de los alumnos coincida con el numero de cuenta ingresado
                                index = indexByNumCuenta(listaPrincipal, numC); //Funcion para obtener el indice del numero de cuenta del alumno
                                found = true; //Si es encontrado, cambiamos el booleano a true para la siguiente condicion
                            }
                        }
                        
                        if (found) { //El booleano al ser TRUE, imprimimos los datos del numero de cuenta ingresado, obtuvimos el indice con la funcion "findByNumCuenta"
                            System.out.println("ACCESO AUTORIZADO");
                            System.out.println(listaPrincipal.get(index).toString()); //Imprimimos todos los datos del indice encontrado en el metodo anterior
                            op5 = 0; //Terminamos el bucle While
                        } else { //Si el ciclo for con la condicion if anterior no encuentra el numero de cuenta ingresado, naturalmente el booleano sigue siendo false
                            if (op3 == 0){ //Cuando los intentos lleguen a 0, el programa termina (op = 0)
                                op5 = 0;
                                op = 0;
                            } else{ //Los intentos van repitiendose 
                                System.out.println("ACCESO DENEGADO");
                                System.out.println("TIENES "+(op3)+" INTENTOS MAS"); //Implementacion de intentos fallidos
                                op3--;
                            }
                        }
                    }break;
                }
                
                /**
                 * Segundo caso: profesor o administración escolar
                 */
                case 2:
                {
                    int op5 = 1;
                    while(op5 == 1){
                        System.out.println("INGRESA LA CONTRASENA");
                        int numCo = scanner.nextInt();
                        if(numCo == contra) {
                            System.out.println("ACCESO AUTORIZADO");
                            validarAtributos(listaPrincipal);
                            op5 = 0;
                        } else{
                             if (op3 == 0){ //Cuando los intentos lleguen a 0, el programa termina (op = 0)
                                op5 = 0;
                                op = 0;
                            } else{ //Los intentos van repitiendose 
                                System.out.println("ACCESO DENEGADO");
                                System.out.println("TIENES "+(op3)+" INTENTOS MAS"); //Implementacion de intentos fallidos
                                op3--;
                            }
                        }
                    }
                 } break;
                 /**
                  * Tercer caso: Acaba el programa (cambiamos op a 0 para que se finalice el programa)
                  */
                case 3:
                {
                    op = 0;
                    break;
                }
                default:
                    System.out.println("OPCION INCORRECTA");
                    break;
            }
        }
    }
    
    /**
     * Método que recibe una lista ordenada (en base al indicador escolar) de alumnos y la ordena y da número de inscripción
     * @param listaAuxiliar indica la lista de todos los alumnos que se generaron
     * @param arreglo 
     * @return listaPrincipal
     */
    public static ArrayList<Alumno> listaOrdenada(ArrayList<Alumno> listaAuxiliar,float arreglo[]){
        Arrays.sort(arreglo);
        int i=(arreglo.length-1),j,num=1;
        ArrayList<Alumno> listaPrincipal=new ArrayList();
        while(i>=0){
            j=0;
            while(arreglo[i]!=listaAuxiliar.get(j).getIndicadorEscolar()){
                j++;
            }
            
            listaAuxiliar.get(j).setNumeroDeInscripcion(num);
            listaPrincipal.add(listaAuxiliar.get(j));
            i=i-1;
            num++;
        }
        return listaPrincipal;
    }
    
    /**
     * Método que crea arreglo de indicadores
     * @param listaAuxiliar indica la lista de todos los alumnos que se generaron
     * @return arreglo
     */
    public static float[] crearArregloDeIndicadores(ArrayList<Alumno> listaAuxiliar){
        float arreglo[]=new float[listaAuxiliar.size()]; 
        for (int i = 0; i < listaAuxiliar.size(); i++) {
            arreglo[i]=listaAuxiliar.get(i).getIndicadorEscolar(); 
        }
    
        return arreglo;
    }
    
    /**
     * Método de indice de número de cuenta
     * @param listaPrincipal indica la lista de todos los alumnos que se generaron
     * @param numC
     * @return i
     */
    public static int indexByNumCuenta(ArrayList<Alumno> listaPrincipal, int numC){
        for (int i = 0; i < listaPrincipal.size(); i++) {
            if (listaPrincipal.get(i).getNumCuenta() == numC){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Método para validar atributos.
     * Se pregunta al profesor la opcion que desea realizar.
     * Se utiliza un try - catch debido al caso 4 del switch.
     * @param listaPrincipal indica la lista de todos los alumnos que se generaron
     */
    public static void validarAtributos(ArrayList<Alumno> listaPrincipal){
        Scanner scanner = new Scanner(System.in);
        int op = 1;
        
        /**
         * Repetimos el menú del profesor
         */
        while(op == 1){
        try {
            System.out.println("INGRESE LA OPCION DESEADA: ");
            System.out.println("1.- Agregar Alumno        2.- Imprimir datos");
            System.out.println("3.- Actualizar datos      4.- Eliminar Alumno");
            System.out.println("5.- Imprimir todo        6.- Salir");
            
            int op1 = scanner.nextInt();
                    float arreglo[]=new float[listaPrincipal.size()]; //Para que el número de inscripción se imprima correctamnete
                    arreglo=crearArregloDeIndicadores(listaPrincipal);
                    listaPrincipal=listaOrdenada(listaPrincipal,arreglo);
                    
            switch(op1){
                case 1:
                {
                    agregarAlumno(listaPrincipal);
                    generarCSV(listaPrincipal);
                    break;
                }
                case 2:
                {
                    imprimirDatos(listaPrincipal);
                    break;
                }
                case 3:
                {
                    editarAtributos(listaPrincipal);
                    generarCSV(listaPrincipal);
                    break;
                }
                case 4:
                {
                    System.out.println("INGRESA EL NUMERO DE CUENTA DEL ALUMNO A BORRAR: ");
                    int numC = scanner.nextInt();
                    System.out.println("SEGURO DE ELIMINAR?");
                    System.out.println("1.- Si      2.- No");
                    int oop = scanner.nextInt();
                    if (oop == 1){
                        eliminarAlumno(listaPrincipal, numC);
                    }
                    generarCSV(listaPrincipal);
                    break;
                }
                case 5:
                {
                    
                    System.out.println(listaPrincipal); //Imprime toda la lista
                    break;
                }
                case 6:
                {
                    op = 0;
                    break;
                }
                
                default:
                    System.out.println("OPCION INVALIDA"); //Si se pone otra opción no valida
                    break;
        }
        } catch (Exception e){
            System.out.println("ALUMNO NO ENCONTRADO");
        }
        }
    }
    
    /**
     * Método que edita los alumnos.
     * Validamos si el número de cuenta existe, si es correcto, se lleva a un menú donde se pregunta el dato que se desea editar.
     * @param listaPrincipal indica la lista de todos los alumnos que se generaron
     */
    public static void editarAtributos(ArrayList<Alumno> listaPrincipal){
        int o = 1;
        int index = 0;
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        while (o == 1){
            System.out.println("INGRESA EL NUMERO DE CUENTA DEL ALUMNO: ");
            int numC = scanner.nextInt();
            for (Alumno alu : listaPrincipal){ //Recorremos los alumnos dentro de la ListaPrincipal
                  if (alu.getNumCuenta() == numC){  //Validamos que alguno de los alumnos coincida con el numero de cuenta ingresado
                           index = indexByNumCuenta(listaPrincipal, numC); //Funcion para obtener el indice del numero de cuenta del alumno
                           found = true;
                  }
            }
            if (found) {
                //Menu donde se pregunta que se quiere editar
                System.out.println("SELECCIONA EL DATO A EDITAR: ");
                System.out.println("1.- Nombre      2.- Edad        3.- Carrera");
                System.out.println("4.- Semestre        4.- Promedio");
                System.out.println("5.- Numero de materias no acreditadas       6.- Direccion");
                System.out.println("7.- Salir");
                int o2 = scanner.nextInt();
                switch(o2){
                    case 1:
                    {
                        System.out.println("EDITANDO NOMBRE");
                        System.out.println("INGRESA EL NUEVO NOMBRE:");
                        scanner.nextLine(); //No se por que, pero se necesita "Saltar" una linea para que podamos escribir el string
                        //Respuesta encontrada en stackoverflow: "https://stackoverflow.com/questions/7877529/java-string-scanner-input-does-not-wait-for-info-moves-directly-to-next-stateme"
                        String name = scanner.nextLine();
                        listaPrincipal.get(index).setNombre(name);
                        o = 0;
                        break;
                    }
                    
                    case 2:
                    {
                        System.out.println("EDITANDO EDAD");
                        System.out.println("INGRESA LA NUEVA EDAD:");
                        int edad = scanner.nextInt();
                        listaPrincipal.get(index).setEdad(edad);
                        o = 0;
                        break;
                    }
                    
                    case 3:
                    {
                        System.out.println("EDITANDO CARRERA");
                        System.out.println("INGRESA LA NUEVA CARRERA:");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        listaPrincipal.get(index).setCarrera(name);
                        o = 0;
                        break;
                    }
                    
                    case 4:
                    {
                        System.out.println("EDITANDO SEMESTRE");
                        System.out.println("INGRESA EL NUEVO SEMESTRE:");
                        int semestre = scanner.nextInt();
                        listaPrincipal.get(index).setSemestre(semestre);
                        o = 0;
                        break;
                    }
                    
                    case 5:
                    {
                        System.out.println("EDITANDO MATERIAS NO ACREDITADAS");
                        System.out.println("INGRESA EL NUMERO DE MATERIAS NO ACREDITADAS:");
                        int materias = scanner.nextInt();
                        listaPrincipal.get(index).setSemestre(materias);
                        o = 0;
                        break;
                    }
                    
                    case 6:
                    {
                        System.out.println("EDITANDO DIRECCION");
                        System.out.println("INGRESA LA NUEVA DIRECCION:");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        listaPrincipal.get(index).setCarrera(name);
                        o = 0;
                        break;
                    }
                    
                    case 7:
                    {
                        o = 0;
                        break;
                    }
                    
                    default:
                        System.out.println("OPCION INVALIDA");
                        break;
                }

            } else {
                System.out.println("ALUMNO NO ENCONTRADO");
            }    
         }
        generarCSV(listaPrincipal); //Volvemos a generar el CSV cuando se editó el dato de algun alumno
    }
    
    /**
     * Método que imprime datos.
     * Se valida número de cuenta, si es correcto, se imprimen datos.
     * @param listaPrincipal indica la lista de todos los alumnos que se generaron
     */
    public static void imprimirDatos(ArrayList<Alumno> listaPrincipal){
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        boolean found = false;
        System.out.println("INGRESA EL NUMERO DE CUENTA DEL ALUMNO: ");
        int numC = scanner.nextInt();
        for (Alumno alu : listaPrincipal){ //Recorremos los alumnos dentro de la ListaPrincipal
                            if (alu.getNumCuenta() == numC){  //Validamos que alguno de los alumnos coincida con el numero de cuenta ingresado
                                index = indexByNumCuenta(listaPrincipal, numC); //Funcion para obtener el indice del numero de cuenta del alumno
                                found = true; //Si es encontrado, cambiamos el booleano a true para la siguiente condicion
                            }
                        }
                        if (found) { //El booleano al ser TRUE, imprimimos los datos del numero de cuenta ingresado, obtuvimos el indice con la funcion "findByNumCuenta"
                            System.out.println(listaPrincipal.get(index).toString()); //Imprimimos todos los datos del indice encontrado en el metodo anterior
                        } else {
                            System.out.println("ALUMNO NO ENCONTRADO");//Si el número de cuenta no existe
                        }
    } 
    
    /**
     * Método que agrega alumno.
     * Se despliega un menu donde se ingresan datos generales del alumno y lo agrega a una lista
     * @param listaPrincipal indica la lista de todos los alumnos que se generaron
     * @throws IOException 
     */
    public static void agregarAlumno(ArrayList<Alumno> listaPrincipal) throws IOException{
        //Utilizado para escanear opciones
        Scanner scanner = new Scanner(System.in);
        //Mini menú donde se escribe los datos del alumno
        System.out.println("AGREGAR ALUMNO");
        System.out.println("Ingresa los datos solicitados a continuacion: ");
        System.out.print("Nombre (completo): ");
        String name = scanner.nextLine();
        System.out.print("Edad: ");
        //scanner.nextLine();
        int edad = scanner.nextInt();
        System.out.print("Carrera: ");
        scanner.nextLine();
        String carrera = scanner.nextLine();
        System.out.print("Semestre: ");
       // scanner.nextLine();
        int semestre = scanner.nextInt();
        System.out.print("Promedio: ");
        //scanner.nextLine();
        float promedio = scanner.nextFloat();
        System.out.print("Numero de materias no acreditas: ");
       // scanner.nextLine();
        int numNA = scanner.nextInt();
        System.out.print("Direccion: ");
        scanner.nextLine();
        String direccion = scanner.nextLine();
        
        //Generación de alumno auxiliar con caracyeristicas dadas por el usuario, agregandolo a lista principal
        Alumno aluAux = new Alumno();
        listaPrincipal.add(aluAux);
        aluAux.generarNumCuenta(listaPrincipal, aluAux);
        aluAux.setNombre(name);
        aluAux.setEdad(edad);
        aluAux.setCarrera(carrera);
        aluAux.setSemestre(semestre);
        aluAux.setPromedio(promedio);
        aluAux.setNumMateriasNoAcreditadas(numNA);
        aluAux.setDireccion(direccion);
        aluAux.generarIndicadorEscolar();
        
        System.out.print("Numero de cuenta generado: ");
        System.out.println(aluAux.getNumCuenta());
        
        generarCSV(listaPrincipal); //Volvemos a generar el archivo CSV cuando ya se agregó un nuevo alumno
    }
    
    /**
     * Método donde se elimina al alumno.
     * Se valida número de cuenta, y si es correcto, se elimina.
     * @param listaPrincipal indica la lista de todos los alumnos que se generaron
     * @param numC 
     */
    public static void eliminarAlumno(ArrayList<Alumno> listaPrincipal, int numC){
        int index = 0;
        boolean found = false;
        for (Alumno alu : listaPrincipal){ //Recorremos los alumnos dentro de la ListaPrincipal
                            if (alu.getNumCuenta() == numC){  //Validamos que alguno de los alumnos coincida con el numero de cuenta ingresado
                                index = indexByNumCuenta(listaPrincipal, numC); //Funcion para obtener el indice del numero de cuenta del alumno
                                found = true; //Si es encontrado, cambiamos el booleano a true para la siguiente condicion
                            }
                        }
                        if (found) { //El booleano al ser TRUE, imprimimos los datos del numero de cuenta ingresado, obtuvimos el indice con la funcion "findByNumCuenta"
                            listaPrincipal.remove(index);
                            System.out.println("ALUMNO BORRADO CON EXITO");
                            generarCSV(listaPrincipal); //Volvemos a generar el archivo CSV cuando se borró otro alumno
                        } else {
                            System.out.println("ALUMNO NO ENCONTRADO");
                        }
    }
    
    /**
     * Método que genera CSV.
     * Se genera un archivo para ir guardando los datos dentro de este, manualmentete se van guardando los atributos de los alumnos
     * @param listaPrincipal indica la lista de todos los alumnos que se generaron
     */
    public static void generarCSV(ArrayList<Alumno> listaPrincipal){
        //Para guardar en un archivo csv
            FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("listaalumnos.csv");
            fileWriter.append("Nombre");
            fileWriter.append(",");
            fileWriter.append("Edad");
            fileWriter.append(",");
            fileWriter.append("Carrera");
            fileWriter.append(",");
            fileWriter.append("Semestre");
            fileWriter.append(",");
            fileWriter.append("IndicadorEscolar");
            fileWriter.append(",");
            fileWriter.append("NumeroDeCuenta");
            fileWriter.append(",");
            fileWriter.append("Promedio");
            fileWriter.append(",");
            fileWriter.append("NumMateriasNoAcreditadas");
            fileWriter.append(",");
            fileWriter.append("Direccion");
            fileWriter.append(",");
            fileWriter.append("NumeroInscripcion");
            fileWriter.append("\n");
            
            //Escribimos el ArrayList (listaPrincipal, es la lista de alumnos) en el archivo CSV que se genera en los anteriores objetos
            for (Alumno var : listaPrincipal){
                fileWriter.append(var.getNombre());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(var.getEdad()));//En lugar de ser un número entero, se convierte en String
                fileWriter.append(",");
                fileWriter.append(var.getCarrera());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(var.getSemestre()));//En lugar de ser un número entero, se convierte en String
                fileWriter.append(",");
                fileWriter.append(String.valueOf(var.getIndicadorEscolar()));//En lugar de ser un número entero, se convierte en String
                fileWriter.append(",");
                fileWriter.append(String.valueOf(var.getNumCuenta()));//En lugar de ser un número entero, se convierte en String
                fileWriter.append(",");
                fileWriter.append(String.valueOf(var.getPromedio()));//En lugar de ser un número entero, se convierte en String
                fileWriter.append(",");
                fileWriter.append(String.valueOf(var.getNumMateriasNoAcreditadas()));//En lugar de ser un número entero, se convierte en String
                fileWriter.append(",");
                fileWriter.append(var.getDireccion());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(var.getNumeroDeInscripcion())); //En lugar de ser un número entero, se convierte en String
                fileWriter.append("\n");
            }
            
            fileWriter.flush();//Desahoga el objeto
            fileWriter.close();//Cerramos archivo
        } catch (IOException ex) {
            Logger.getLogger(Pueba_generar_ALUMNO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
