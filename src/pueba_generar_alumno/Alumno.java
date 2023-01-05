/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pueba_generar_alumno;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Contiene los datos generales del alumno
 * @author Carmona Ayala Mariana Zoe, Castillo Martinez Diego Leonardo, García Cerda Gerardo Daniel, Lechuga Castillo Shareny Ixchel, Sánchez Medina José Santiago.
 */

public class Alumno {
    /**
     * Nombre del alumno
     */
    private String nombre;
    /**
     * Número de cuenta del alumno
     */
    private int numCuenta;
    /**
     * Edad del alumno
     */
    private int edad;
    /**
     * Promedio del alumno, donde el promedio mínimo del alumno es de 5, si el alumno tiene menos de 6 se encuentra en 
     * primer o segundo semestre 
     */
    private float promedio;
    /**
     * Dirección del alumno
     */
    private String direccion;
    /**
     * Número de materias no acreditadas por el laumno
     */
    private int numMateriasNoAcreditadas;
    /**
     * Semestre del alumno, todas las carreras son de 10 semestres y solo se puede pasar al siguiente semestre si 
     * has acreditado todas las materias
     */
    private int semestre; 
    /**
     * Carrera del alumno
     */
    private String carrera;
    /**
     * Arreglo de materias
     * Especificaciones para las materias 
     * Cada semestre tiene forzosamente 5 materias de estas en todas las carreras las cuales son 6 ingenierias, los 5 primeros 
     * semestres son iguales para cada una por conveniencia en el archivo mas que nada, sin embargo se puede modificar todas las 
     * materias para facilitación de este código, todas las materias valdran 6 creditos.
     */
    private ArrayList<Materia> materia;
    
    /**
     * Indicador escolar del alumno
     */
    private float indicadorEscolar;
    /**
     * Número de inscripción del alumno
     */
    private int numeroDeInscripcion;
    
    /**
     * Constructor Alumno
     */
    public Alumno() {
        
    }

    /**
     * Constructor que recibe nombre, número de cuenta, edad y el promedio del alumno
     * @param nombre indica el nombre del alumno
     * @param numCuenta indica el número de cuenta del alumno
     * @param edad indica la edad del alumno
     * @param promedio indica el promedio del alumno
     */
    public Alumno(String nombre, int numCuenta, int edad, float promedio) {
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.edad = edad;
        this.promedio = promedio;
    }

    /**
     * Devuelve el nombre del alumno
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del alumno
     * @param nombre indica el nombre del alumno
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el número de cuenta del alumno
     * @return numCuenta
     */
    public int getNumCuenta() {
        return numCuenta;
    }

    /**
     * Modifica el número de cuenta del alumno
     * @param numCuenta indica el número de cuenta del alumno
     */
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * Devuelve la edad del alumno
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad del alumno
     * @param edad indica la edad del alumno
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

   /**
     * Devuelve el promedio del alumno
     * @return promedio
     */
    public float getPromedio() {
        return promedio;
    }

    /**
     * Modifica el promedio del alumno
     * @param promedio indica el promedio que obtiene el alumno
     */
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    /**
     * Devuelve la dirección del alumno
     * @return dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Modifica la dirección del alumno
     * @param direccion indica la dirección del alumno
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el número de materias no acreditadas
     * @return numMateriasNoAcreditadas
     */
    public int getNumMateriasNoAcreditadas() {
        return numMateriasNoAcreditadas;
    }

    /**
     * Modifica el número de materias no acreditadas
     * @param numMateriasNoAcreditadas indica el número de materias no acreditadas por el alumno
     */
    public void setNumMateriasNoAcreditadas(int numMateriasNoAcreditadas) {
        this.numMateriasNoAcreditadas = numMateriasNoAcreditadas;
    }

    /**
     * Devuelve el semestre del alumno
     * @return semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Modifica el semestre del alumno
     * @param semestre indica el semstre del alumno
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Devuelve la carrera del alumno
     * @return carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Modifica la carrera del alumno
     * @param carrera indica la carrera del alumno
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Devuelve la materia del alumno
     * @return materia
     */
    public ArrayList<Materia> getMateria() {
        return materia;
    }

    /**
     * Modifica la materia del alumno
     * @param materia indica la materia del alumno
     */
    public void setMateria(ArrayList<Materia> materia) {
        this.materia = materia;
    }

    /**
     * Devuelve el indicador escolar del alumno
     * @return indicadorEscolar 
     */
    public float getIndicadorEscolar() {
        return indicadorEscolar;
    }

    /**
     * Modifica el indicador escolar del alumno
     * @param indicadorEscolar indicada la escolaridad del alumno
     */
    public void setIndicadorEscolar(float indicadorEscolar) {
        this.indicadorEscolar = indicadorEscolar;
    }

    /**
     * Modifica el número de inscripción del alumno
     * @param numeroDeInscripcion indica el número de inscripción del alumno
     */
    public void setNumeroDeInscripcion(int numeroDeInscripcion) {
        this.numeroDeInscripcion = numeroDeInscripcion;
    }

    /**
     * Devuelve el número de inscripción del alumno
     * @return 
     */
    public int getNumeroDeInscripcion() {
        return numeroDeInscripcion;
    }
    
    /**
     * Método que genera el número de cuenta del alumno
     *Para generar un numero de cuenta iremos generando de manera aleatoria número por número para luego unir todo.
     *El primer número indica la generacion y con base a ella sabremos aproximadamente la edad de nuestro alumno, esto nos 
     * ayudará mas adelante.
     *Debemeos tener en cuenta que los números de cuenta no se deben repetir pues seran nuestro indicador para diferenciar 
     * por cada alumno por lo cual iremos haciendo que se revise la lista de manera recursiva.
     * @param Aux
     * @param ulti 
     */
    public void generarNumCuenta(ArrayList<Alumno> Aux, Alumno ulti){
       Random tmp =new Random();
       int i=0,numGenerado;
       /**
        * Nos va a ayudar a castera de entero a string para no tener un numero aleatorio tan extraño y reducir la probabilidad de
        * que los números de cuenta se repitan
        */
       String casteador; 
       
        numGenerado=(tmp.nextInt(6)+1);
        casteador=numGenerado+"";    
        numGenerado=(tmp.nextInt(8999)+1000);
        casteador=casteador+numGenerado+"";numGenerado=(tmp.nextInt(8999));
        casteador=casteador+numGenerado+"";
        numGenerado = Integer.parseInt(casteador);
        
        /**
         * While realiza un ciclo para corroborar que no estamos en el último elemento de nuestra lista y a su vez nos ayuda a que 
         * no se repitan los números de cuenta, si se sale es debido a que alguna de las dos condiciones no se cumplió y 
         * tocará revisarlas
         */
       while(Aux.get(i).numCuenta != numGenerado & Aux.get(i).nombre!=ulti.nombre){
           i++;
           /**
        * Condiciones para el if - else
        * -Primera condición: Se generó sin problemas y nada se repitio 
        * -Segunda condición: Se tuvo que repetir el ciclo pues hubo una repetición de número de cuenta justo al final de todo
        * -Tercera condición: Se tuvo que repetir el ciclo pues hubo una repetición de número de cuenta en algun punto de la lista
        */
       }
       if(Aux.get(i).nombre==ulti.nombre & Aux.get(i).numCuenta != numGenerado){
           Aux.get(i).numCuenta=numGenerado;
           //Primera condición  
       }else if(Aux.get(i).nombre==ulti.nombre & Aux.get(i).numCuenta == numGenerado){
           Aux.get(i).generarNumCuenta(Aux, ulti);
           //Segunda condición
       }else{
         Aux.get(i).generarNumCuenta(Aux, ulti);
         //Tercera condición
       }
    }
    
    /**
     * Método que genera el nombre del alumno
     * @throws IOException 
     */
    public void generarNombre() throws IOException {
        ArrayList<String> NombresH = new ArrayList<String>();
        ArrayList<String> Apellidos= new ArrayList<String>();
        ArrayList<String> NombresM = new ArrayList<String>();
        try {
            BufferedReader bf= new BufferedReader(new FileReader("NombresH.txt"));
            String bfRead;
            while ((bfRead= bf.readLine()) != null){
                NombresH.add(bfRead);
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        }
        try {
            BufferedReader bf= new BufferedReader(new FileReader("NombresM.txt"));
            String bfRead;
            while ((bfRead= bf.readLine()) != null){
                NombresM.add(bfRead);
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        }
        try {
            BufferedReader bf= new BufferedReader(new FileReader("Apellidos.txt"));
            String bfRead;
            while ((bfRead= bf.readLine()) != null){
                Apellidos.add(bfRead);
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        }
        
        Random tmp =new Random();
        String nombreAleatorio;
        
        /**
         *Condiciones del if - else
         * Si es igual a 0 nuestro alumno generado sera una mujer, de lo contrario será hombre 
         */
        if(tmp.nextInt(2)==0){
            nombreAleatorio=(NombresM.get(tmp.nextInt(NombresM.size()))+" "
                +Apellidos.get(tmp.nextInt(Apellidos.size()))+" "+Apellidos.get(tmp.nextInt(Apellidos.size())));
        }else{
            nombreAleatorio=(NombresH.get(tmp.nextInt(NombresH.size()))+" "
                +Apellidos.get(tmp.nextInt(Apellidos.size()))+" "+Apellidos.get(tmp.nextInt(Apellidos.size())));
        }

        nombre=nombreAleatorio;
    } 
    
    /**
     * Método que genera la dirección del alumno.
     * Utiliza archivo de direcciones
     * @throws FileNotFoundException 
     */
    public void generarDireccion() throws FileNotFoundException{
        ArrayList<String> lista_de_direcciones = new ArrayList<String>();
        try {
            BufferedReader bf= new BufferedReader(new FileReader("Direcciones.txt"));
            String bfRead;
            while ((bfRead= bf.readLine()) != null){
                lista_de_direcciones.add(bfRead);
            }
        } catch (IOException ex) {
           System.out.println("No se encontro el archivo");
        }
        Random tmp =new Random();
        String direccion=lista_de_direcciones.get(tmp.nextInt(lista_de_direcciones.size()));
        this.direccion=direccion;
    
    }
    
    /**
     * Método que genera el historial académico del alumno.
     * El alumno puede estar insrcito dentro de 6 diferentes ingenierias, dentro de estas se asignan sus materias para obetner su califiación
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void generarHistorialAcademico() throws FileNotFoundException, IOException{
        int i;
        materia=new ArrayList<Materia>();
        Random num =new Random();
        //int selector =1;//(num.nextInt(6)+1);// aqui se decidira la crrera 
        Materia auxiliar;
        
        ArrayList<String> MateriasDeCarrera = new ArrayList<String>();
        try {
            BufferedReader bf= new BufferedReader(new FileReader("Materias.txt"));
            String bfRead;
            while ((bfRead= bf.readLine()) != null){
                MateriasDeCarrera.add(bfRead);
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        }
            int selector =(num.nextInt(6)+1);
            if(selector==1){ 
                i=0;
            //En este caso se elegira la carrera de ingenieria en computacion (número 1)
                carrera="Ingenieria En Computacion";
                selector =(num.nextInt(10)+1); //Decide el semestre que este hombre tiene
                semestre=selector;
                
                while(i<((selector*5) -5)){
                    auxiliar=new Materia();
                    auxiliar.setMateria(MateriasDeCarrera.get(i));
                    auxiliar.setCalificacion(num.nextFloat(4)+6);
                    this.materia.add(auxiliar);
                    i++;
                }
                
                while(i<((selector*5))){
                    auxiliar=new Materia();
                    auxiliar.setMateria(MateriasDeCarrera.get(i));
                   
                    auxiliar.setCalificacion( num.nextFloat(5)+5);
                    this.materia.add(auxiliar);
                    if(auxiliar.getCalificacion()<6){
                        numMateriasNoAcreditadas++;
                    }
                    i++;
                }   
            }else if(selector==2){ 
               i=50;
            //Se eligirá la carrera de ingenieria Mecanica (número 2)
                carrera="Ingenieria Mecanica";
                selector =(num.nextInt(10)+1); // Decide el semestre que este hombre tiene
                semestre=selector;
                
                while(i<((selector*5) -5)+50){
                    auxiliar=new Materia();
                    auxiliar.setMateria(MateriasDeCarrera.get(i));
                    auxiliar.setCalificacion(num.nextFloat(4)+6);
                    this.materia.add(auxiliar);
                    i++;
                }
                
                while(i<((selector*5))+50){
                    auxiliar=new Materia();
                    auxiliar.setMateria(MateriasDeCarrera.get(i));
                   
                    auxiliar.setCalificacion( num.nextFloat(5)+5);
                    this.materia.add(auxiliar);
                    if(auxiliar.getCalificacion()<6){
                        numMateriasNoAcreditadas++;
                    }
                    i++;
                }   
            }else if(selector==3){ 
                i=100;
            //Se elegirá la carrera de ingenieria Aeroespacial (número 3)
                carrera="Ingenieria Aeroespacial";
                selector =(num.nextInt(10)+1); //Este decide el semestre que este hombre tiene
                semestre=selector;
                
                while(i<((selector*5) -5)+100){
                    auxiliar=new Materia();
                    auxiliar.setMateria(MateriasDeCarrera.get(i));
                    auxiliar.setCalificacion(num.nextFloat(4)+6);
                    this.materia.add(auxiliar);
                    i++;
                }
                
                while(i<((selector*5))+100){
                    auxiliar=new Materia();
                    auxiliar.setMateria(MateriasDeCarrera.get(i));
                   
                    auxiliar.setCalificacion( num.nextFloat(5)+5);
                    this.materia.add(auxiliar);
                    if(auxiliar.getCalificacion()<6){
                        numMateriasNoAcreditadas++;
                    }
                    i++;
                }   
            }else if(selector==4){ 
                    i=150;
                 // Se elegirá la carrera de ingenieria Industrial (número 4)
                     carrera="Ingenieria Industrial";
                     selector =(num.nextInt(10)+1); //Este decide el semestre que este hombre tiene
                     semestre=selector;

                     while(i<((selector*5) -5)+150){
                         auxiliar=new Materia();
                         auxiliar.setMateria(MateriasDeCarrera.get(i));
                         auxiliar.setCalificacion(num.nextFloat(4)+6);
                         this.materia.add(auxiliar);
                         i++;
                     }

                     while(i<((selector*5))+150){
                         auxiliar=new Materia();
                         auxiliar.setMateria(MateriasDeCarrera.get(i));

                         auxiliar.setCalificacion( num.nextFloat(5)+5);
                         this.materia.add(auxiliar);
                         if(auxiliar.getCalificacion()<6){
                             numMateriasNoAcreditadas++;
                         }
                         i++;
                     }   
                 } else if(selector==5){ 
                    i=200;
                 //Se elegirá la carrera de ingenieria  Electrica Electronica (número 5)
                     carrera="Ingenieria Electrica Electronica";
                     selector =(num.nextInt(10)+1); //Este decide el semestre que este hombre tiene
                     semestre=selector;

                     while(i<((selector*5) -5)+200){
                         auxiliar=new Materia();
                         auxiliar.setMateria(MateriasDeCarrera.get(i));
                         auxiliar.setCalificacion(num.nextFloat(4)+6);
                         this.materia.add(auxiliar);
                         i++;
                     }

                     while(i<((selector*5))+200){
                         auxiliar=new Materia();
                         auxiliar.setMateria(MateriasDeCarrera.get(i));

                         auxiliar.setCalificacion( num.nextFloat(5)+5);
                         this.materia.add(auxiliar);
                         if(auxiliar.getCalificacion()<6){
                             numMateriasNoAcreditadas++;
                         }
                         i++;
                     }   
                 }else { 
                    i=250;
                 //Se elegirá la carrera de ingenieria Ambiental (otro caso)
                     carrera="Ingenieria Ambiental";
                     selector =(num.nextInt(10)+1); //Decide el semestre que este hombre tiene
                     semestre=selector;

                     while(i<((selector*5) -5)+250){
                         auxiliar=new Materia();
                         auxiliar.setMateria(MateriasDeCarrera.get(i));
                         auxiliar.setCalificacion(num.nextFloat(4)+6);
                         this.materia.add(auxiliar);
                         i++;
                     }

                     while(i<((selector*5))+250){
                         auxiliar=new Materia();
                         auxiliar.setMateria(MateriasDeCarrera.get(i));

                         auxiliar.setCalificacion( num.nextFloat(5)+5);
                         this.materia.add(auxiliar);
                         if(auxiliar.getCalificacion()<6){
                             numMateriasNoAcreditadas++;
                         }
                         i++;
                     }   
                 }
        }
    
    /**
     * Método que genera la calificación del alumno.
     * Calcula el promedio del alumno con ayuda del algoritmo de la FI.
     */
    public void generarCalificacion(){
        float promediofinal=0;
        for (int i = 0; i < materia.size(); i++) {
             promediofinal=promediofinal+materia.get(i).getCalificacion();
        }
        promedio=(promediofinal)/(semestre*5);
    }
    
     /**
     * Método que genera la edad del alumno
     * Si se encuentra en semestre 1 o 2: su edad es 15 a 18
     * Si se encuentra en semestre 3 o 4: su edad es 18 a 21
     * Si se encuentra en semestre 5 o 6: su edad es 21 a 24
     * Si se encuentra en semestre 7 u 8: su edad es 24 a 27
     * Si se encuentra en otro semestre: su edad es 24 a 27
     */
    public void generarEdad(){
        Random tmp =new Random();
        
        if(semestre==1 || semestre==2){
            edad=tmp.nextInt(3)+15;
        }else if(semestre==3 || semestre==4){
            edad=tmp.nextInt(3)+18;
        }else if(semestre==5 || semestre==6){
            edad=tmp.nextInt(3)+21;
        }else if(semestre==7 || semestre==8){
            edad=tmp.nextInt(3)+24;
        }
        else {
            edad=tmp.nextInt(2)+25;}
    }
    
    /**
     * Método que genera el indicador escolar del alumno
     * Recordando, todas las materias valen 6 créditos para para este indicador y se hace uso de la pagina general de la FI
     * Para obtener el indicador requerimos el promedio, escolaridad y velocidad del alumno.
     * Escolaridad: Se dividen las asignaturas aprobadas en ordinario (se hara de manera aleatoria) entre las asignaturas 
     * inscritas en ordinario, multiplicado todo por 100 
     * Velocidad: Se dividen los creditos que lleva el alumno(esto se hara en vase a la cantidad de materias aprobadas del alumno 
     * dado que ya establecimos que en esta escuela hipotetica el alumno no debe tener reprobados semestres anteriores, solo existe
     * la posibilidad de que los alumno tengan trunco el semestre actual y se recuperen en ese semestre) entre los 
     * creditos que deberia llevar de acuerdo al semestre, multiplicado todo por 100
     */
    public void generarIndicadorEscolar(){
        float escolaridad,tmp,velocidad;
        int aux;
        aux=semestre*5; //Auxiliar sirve para saber el número de materias acreditadas por semestre para el alumno
        /**
         * Generamos un número aleatorio de materias que no se pasaron en ordinario, esto es para que la cantidad de 
         * materias aprobadas en ordinario parezca creible y no salgan tantos alumnos con un número de inscripción tan bajo
         */
        Random acredit_en_extra= new Random();
        tmp=acredit_en_extra.nextInt(aux);
        escolaridad=((aux-tmp)/aux)*100; //Como el algoritmo establecido por la FI
        
        tmp=(semestre*5*6)-(numMateriasNoAcreditadas*6);
        
        velocidad=(((tmp)/(semestre*30)))*100;//Como el algoritmo establecido por la FI
        
        indicadorEscolar=promedio*velocidad*escolaridad;
    }
    
    /**
     * Método que está en la clase principal y se sobreescribe
     * @return nombre, carrera, edad, semsetre, indicadorEscolar, numCuenta, promedio, numMateriasNoAcreditadas, direccion y numerDeInscripción del alumno
     */
    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------------------\n"+
                "Alumno{ \n" + 
                "nombre=" + nombre + "      edad="+ edad+"\n"+
                "carrera=" + carrera +"          semestre=" + semestre +  "     Indicador escolar="+indicadorEscolar+"\n"+
                "numCuenta=" + numCuenta + "     promedio=" + promedio + "     numMateriasNoAcreditadas=" + numMateriasNoAcreditadas+"\n"+
                "direccion=" + direccion  + '}' +"\n" + "numdeinscripcion="+numeroDeInscripcion
                //+"materia"+materia +"\n"
                +"\n-----------------------------------------------------------------------------------\n";
    }
}