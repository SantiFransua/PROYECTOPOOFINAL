/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pueba_generar_alumno;

/**
 *Obtiene calificación y materias del alumno
 * @author Carmona Ayala Mariana Zoe, Castillo Martinez Diego Leonardo, García Cerda Gerardo Daniel, Lechuga Castillo Shareny Ixchel, Sánchez Medina José Santiago.
 */
public class Materia {
    /**
     * Nombre de la materia
     */
    private String materia;
    /**
     * Califiación de tipo flotante 
     */
    private float calificacion;

    /**
     * Constructor Materia
     */
    public Materia() {
    }

     /**
     * Devuelve la materia
     * @return materia
     */
    public String getMateria() {
        return materia;
    }

    /**
     * Devuelve la calificación
     * @return calificación
     */
    public float getCalificacion() {
        return calificacion;
    }

    /**
     * Modifica la materia
     * @param materia indica la materia del alumno
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    /**
     * Modifica la calificación
     * @param calificacion indica la calificación del alumno
     */
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Método que está en la clase principal y se sobreescribe
     * @return materia y califiación
     */
    @Override
    public String toString() {
        return "Materia{" + "materia=" + materia + ", calificacion=" + calificacion + '}' +"\n";
    }
}
