package ComputerAcademy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CursoPrivado {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String nuevoCursoPrivado;
	private String descripcionCursoPrivado;
	private String enlaceCursoPrivado;
	
	public CursoPrivado(){
		
	}

	public CursoPrivado (String nuevoCursoPrivado, String descripcionCursoPrivado, String enlaceCursoPrivado) {
		super();
		this.nuevoCursoPrivado = nuevoCursoPrivado;
		this.descripcionCursoPrivado = descripcionCursoPrivado;
		this.enlaceCursoPrivado = enlaceCursoPrivado;
		
	}
	
	public String getNuevoCursoPrivado() {
		return nuevoCursoPrivado;
	}

	public void setNuevoCursoPrivado(String nuevoCursoPrivado) {
		this.nuevoCursoPrivado = nuevoCursoPrivado;
	}

	public String getDescripcionCursoPrivado() {
		return descripcionCursoPrivado;
	}

	public void setDescripcionCursoPrivado(String descripcionCursoPrivado) {
		this.descripcionCursoPrivado = descripcionCursoPrivado;
	}

	public String getEnlaceCursoPrivado() {
		return enlaceCursoPrivado;
	}

	public void setEnlaceCursoPrivado(String enlaceCursoPrivado) {
		this.enlaceCursoPrivado = enlaceCursoPrivado;
	}
	


	@Override
	public String toString() {
		return "CursoPrivado [nuevoCursoPrivado=" + nuevoCursoPrivado + ", descripcionCursoPrivado=" + descripcionCursoPrivado + ", enlaceCursoPrivado=" + enlaceCursoPrivado + "]";
	}
	
}



