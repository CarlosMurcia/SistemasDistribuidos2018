package ComputerAcademy;

import java.util.Collection;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/Api")
public class CursosRestController {
	
	

	@Autowired
	private CursosPublicoRepository repository2;
	
	@Autowired
	private CursoPrivadosRepository repository3;


	//Api Rest para cursos publicos
	
	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public Collection<CursoPublico> getPu() {
		return repository2.findAll();
	}
	
	@RequestMapping(value = "/public/{id}", method = RequestMethod.GET)
	public ResponseEntity<CursoPublico> getPu(@PathVariable long id) {

		
		CursoPublico cursospublico = repository2.findOne(id);
		if (cursospublico != null) {
			return new ResponseEntity<>(cursospublico, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/public", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public CursoPublico createPu(@RequestBody CursoPublico cursospublico) {

		repository2.save(cursospublico);

		return cursospublico;
	}
	
	@RequestMapping(value = "/public/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CursoPublico> updatePu(@PathVariable long id, @RequestBody CursoPublico cursospublico) {

		CursoPublico cursospublicos = repository2.findOne(id);
		if (cursospublicos != null) {

			cursospublicos.setId(id);
			repository2.save(cursospublicos);

			return new ResponseEntity<>(cursospublicos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/public/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CursoPublico> deletePu(@PathVariable long id) {

		if (repository2.exists(id)) {
			repository2.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Api Rest cursos privados
	
	@RequestMapping(value = "/private", method = RequestMethod.GET)
	public Collection<CursoPrivado> getPri() {
		return repository3.findAll();
	}
	
	@RequestMapping(value = "/private/{id}", method = RequestMethod.GET)
	public ResponseEntity<CursoPrivado> getPri(@PathVariable long id) {

		
		CursoPrivado cursosprivados = repository3.findOne(id);
		if (cursosprivados != null) {
			return new ResponseEntity<>(cursosprivados, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/private", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public CursoPrivado createPr(@RequestBody CursoPrivado cursosprivado) {

		repository3.save(cursosprivado);

		return cursosprivado;
	}
	
	@RequestMapping(value = "/private/{id}", method = RequestMethod.PUT)
	public ResponseEntity<CursoPrivado> updatePr(@PathVariable long id, @RequestBody CursoPrivado cursosprivado) {

		CursoPrivado cursosprivados = repository3.findOne(id);
		if (cursosprivado != null) {

			cursosprivado.setId(id);
			repository3.save(cursosprivado);

			return new ResponseEntity<>(cursosprivado, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/private/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CursoPrivado> deletePr(@PathVariable long id) {

		if (repository3.exists(id)) {
			repository3.delete(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}


