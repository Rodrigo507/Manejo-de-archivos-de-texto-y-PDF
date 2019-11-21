/**
 * Estudiante
 */
public class Estudiante implements Comparable<Estudiante>{
    private final String cedula;
    private final String apellido;
    private final String nombre;
    private final char sexo;
    private final String turno;
    private final int anno;
    Estudiante (final String ced,final String ape, final String nom,final char se, final String tur, final int an){
        this.cedula=ced;
        this.apellido=ape;
        this.nombre=nom;
        this.sexo=se;
        this.turno=tur;
        this.anno=an;
    }
    /*METODOS */
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

@Override
     public int compareTo(final Estudiante o) {
        if (this.sexo < o.sexo) {
            return -1;
        }
        if (this.sexo == o.sexo) {
            return 0;
        }
        return 1;
     }
   
}