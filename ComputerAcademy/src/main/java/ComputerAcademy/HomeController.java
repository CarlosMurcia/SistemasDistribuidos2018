package ComputerAcademy;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired 
	private UsuariosRepository repository;
	
	@Autowired 
	private ForosRepository repository1;
	
	@Autowired 
	private ReservasRepository repository2;
	
	@Autowired 
	private PublicosRepository repository3;
	
	@Autowired 
	private PrivadosRepository repository4;
	
	@PostConstruct
	public void init () {
		repository.save (new Usuario ("Nombre1", "Email1"));
		repository.save (new Usuario ("Nombre2", "Email2"));
		repository1.save (new Foro ("Nombre1", "Esto es un comentario"));
		repository1.save (new Foro ("Nombre2", "Esto es otro comentario"));
		repository2.save (new Reserva ("Nombre1", "Apellidos1","97387483X","Direccion1", "Email1", "Telefono1"));
		repository2.save (new Reserva ("Nombre2", "Apellidos2","98532753X","Direccion2", "Email2", "Telefono2"));
		repository3.save (new CursoPublico ("Curso1", "descripcion1", "www.youtube.com"));
		repository3.save (new CursoPublico ("Curso2", "descripcion2", "www.youtube.com"));
		repository4.save (new CursoPrivado ("Curso1", "descripcion1", "www.youtube.com"));
		repository4.save (new CursoPrivado ("Curso2", "descripcion2", "www.youtube.com"));
	}
	
	@RequestMapping("/")
	public String home(Model model, Pageable page) {
		
		model.addAttribute("usuarios", repository.findAll (page));
		model.addAttribute("foros", repository1.findAll (page));
		model.addAttribute("publicos", repository3.findAll (page));

		return "Home";
	}

	@GetMapping("/usuario/nuevo")
	public String nuevoUsuario(Model model, Usuario usuario) {

		return "NuevoUsuario";

	}
	
	@PostMapping("/usuario/guardado")
	public String UsuarioGuardado (Model model, Usuario usuarios) {

		repository.save(usuarios);
		
		return "UsuarioGuardado";
	}

	@RequestMapping("/foro")
	public String nuevoComentario(Model model, Foro foros) {

		return "Comentario";
	}
	
	@PostMapping("/comentario")
	public String Comentario (Model model, Foro foros) {
		
		repository1.save(foros);

		return "ComentarioGuardado";
	}
	
		
	@GetMapping("/publico")
	public String CursoPublico(Model model,Pageable page) {

		model.addAttribute("publicos", repository3.findAll (page));
		
		return "CursoPublico";
	}
	
	@RequestMapping("/privado")
	public String nuevoCursoPrivado(Model model, Pageable page) {

		model.addAttribute("privados", repository4.findAll (page));
		
		return "CursoPrivado";
	}
	
	
	@GetMapping("/reserva")
	public String ReservaGuardada (Model model, Reserva reservas) {

		
		return "Reserva";
	}
	
	@PostMapping("/reserva/guardada")
	public String ReservaGuardado (Model model, Reserva reservas) {

		repository2.save(reservas);
		
		return "ReservaGuardada";
	}
	@RequestMapping("/Inicio")
	public String Inicio (Model model) {

		
		return "Welcome";
	}
	
}