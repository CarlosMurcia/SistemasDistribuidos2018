package ComputerAcademy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CursoPublico {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String nuevoCursoPublico ;
	private String descripcionCursoPublico ;
	private String enlaceCursoPublico ;
	
	public CursoPublico(){
		
	}

	public CursoPublico  (String nuevoCursoPublico , String descripcionCursoPublico , String enlaceCursoPublico) {
		super();
		this.nuevoCursoPublico = nuevoCursoPublico;
		this.descripcionCursoPublico = descripcionCursoPublico;
		this.enlaceCursoPublico = enlaceCursoPublico;
		
	}
	
	public String getNuevoCursoPublico() {
		return nuevoCursoPublico;
	}

	public void setNuevoCursoPublico(String nuevoCursoPublico) {
		this.nuevoCursoPublico = nuevoCursoPublico;
	}

	public String getDescripcionCursoPublico() {
		return descripcionCursoPublico;
	}

	public void setDescripcionCursoPublico(String descripcionCursoPublico) {
		this.descripcionCursoPublico = descripcionCursoPublico;
	}

	public String getEnlaceCursoPublico() {
		return enlaceCursoPublico;
	}

	public void setEnlaceCursoPublico(String enlaceCursoPublico) {
		this.enlaceCursoPublico = enlaceCursoPublico;
	}
	


	@Override
	public String toString() {
		return "CursoPublico [nuevoCursoPublico=" + nuevoCursoPublico + ", descripcionCursoPublico=" + descripcionCursoPublico + ", enlaceCursoPublico=" + enlaceCursoPublico + "]";
	}
	
}



