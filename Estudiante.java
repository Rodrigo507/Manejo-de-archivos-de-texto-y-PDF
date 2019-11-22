/**
 * Estudiante
 */
public class Estudiante implements Comparable<Estudiante>{//Implementamos la interface Comparable
    /*Encapsulación de los datos(atributos) del objeto*/
    private final String cedula;
    private final String apellido;
    private final String nombre;
    private final char sexo;
    private final String turno;
    private final int anno;
    /********************************************/
    //Contrutor del objeto
    Estudiante (String ced,String ape,String nom,char se,String tur,int an){
        this.cedula=ced;
        this.apellido=ape;
        this.nombre=nom;
        this.sexo=se;
        this.turno=tur;
        this.anno=an;
    }
    /********************************************/
    /*METODOS */
    /**
     * Con estos metodos
     * devolvemos los atributos del objeto
     */
    public String getcedula() {
        return(this.cedula);
    }
    public String getApellido() {
        return(this.apellido);
    }
    public String getNombre() {
        return(this.nombre);
    }
    public char getSexo() {
        return(this.sexo);
    }
    public String getTurno() {
        return(this.turno);
    }
    public int getAnno() {
        return(this.anno);
    }
    /********************************************/
    /*Metodo comparable*/
    /*Con este metodo realizamos la ordenacion del ArrayList*/
    @Override
    public int compareTo(final Estudiante o) {
        if (this.sexo < o.sexo) {
            return -1;
        }if (this.sexo == o.sexo) {
            return 0;
        }
        return 1;
    }    
   
}