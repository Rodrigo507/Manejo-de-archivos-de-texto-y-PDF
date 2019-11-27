/**
 * Estudiante
 * Esta clase nos permite la creacion de objetos
 * ademas que contiene metodos para devolver los datos
 */
public class Estudiante implements Comparable<Estudiante>{//Implementamos la interface Comparable
    /*Encapsulación de los datos(atributos) del objeto*/
    private  String cedula;
    private  String apellido;
    private  String nombre;
    private  String sexo;
    private  String turno;
    private  int anno;
    /********************************************/
    //Construtor del objeto
    Estudiante (String ced,String ape,String nom,String se,String tur,int an){
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
    public String getSexo() {
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
    /*Por sexo */
    @Override
    public int compareTo( Estudiante o) {
        return(this.sexo.compareTo(o.sexo));
    }    
   
}