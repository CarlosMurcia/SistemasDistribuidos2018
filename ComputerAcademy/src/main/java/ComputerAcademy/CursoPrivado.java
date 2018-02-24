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
	
	private String curso;
	private String descripcion;
	private String enlace;
	
	public CursoPrivado(){
		
	}

	public CursoPrivado (String curso, String descripcion, String enlace) {
		super();
		this.curso = curso;
		this.descripcion = descripcion;
		this.enlace = enlace;
		
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso =  curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	
	@Override
	public String toString() {
		return "CursoPrivado [curso=" + curso + ", descripcion=" + descripcion + ", enlace=" + enlace + "]";
	}
	
}
