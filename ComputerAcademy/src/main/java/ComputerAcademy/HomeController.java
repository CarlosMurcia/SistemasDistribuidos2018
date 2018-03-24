package ComputerAcademy;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	private CursosPublicoRepository repository2;
	
	@Autowired 
	private CursoPrivadosRepository repository3;
	
	@PostConstruct
	public void init () {
		repository1.save (new Foro ("Nombre1", "Esto es un comentario"));
		repository1.save (new Foro ("Nombre2", "Esto es otro comentario"));
		repository2.save (new CursoPublico ("Java", "Introduccion a java", "https://www.youtube.com/watch?v=Z0F7sJaOQtw"));
		repository2.save (new CursoPublico ("HTML", "Introduccion a HTML", "https://www.youtube.com/watch?v=cqMfPS8jPys"));
		repository3.save (new CursoPrivado ("Curso Premium Java", "Java Avanzado", "https://www.youtube.com/watch?v=ye_0sRyHBmM","http://www.jtech.ua.es/j2ee/publico/lja-2012-13/wholesite.pdf"));
		repository3.save (new CursoPrivado ("Curso Premium Spring", "Spring MVC", "https://www.youtube.com/watch?v=ye_0sRyHBmM","http://www.jtech.ua.es/j2ee/publico/spring-2012-13/wholesite.pdf"));
	}
	
	
	
	@RequestMapping("/")
    public String Login(Model model,  Pageable page) {
		
		model.addAttribute("usuarios", repository.findAll (page));
		model.addAttribute("CursosPublico", repository2.findAll (page));
        
		return "Login";
    }
	
	@RequestMapping("/home")
	public String home(Model model, Pageable page, HttpServletRequest request) {
		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("CursosPrublico", repository2.findAll (page));
		model.addAttribute("CursoPrivados", repository3.findAll (page));
		

		return "Home";
	}

	@GetMapping("/usuario/nuevo")
	public String nuevoUsuario(Model model) {

		return "NuevoUsuario";

	}
	
	@PostMapping("/usuario/guardado")
	public String UsuarioGuardado (Model model,Usuario usuarios, HttpSession sesion) {
		
		ArrayList<String> roles = new ArrayList<String>();
	 	roles.add("ROLE_USER");
	 	usuarios.setRoles(roles);
	 	repository.save(usuarios);
	 	new Comunicacion().enviar(usuarios.getEmail(), "Servicio Interno", "Tu Registro ha sido un éxito, Ahora puedes disfrutar de nuestros curso privados.");
		
		return "UsuarioGuardado";
	}

	@RequestMapping("/foro")
	public String nuevoComentario(Model model, Foro foros,Pageable page) {

		model.addAttribute("foros", repository1.findAll (page));
		
		return "Comentario";
	}
	
	@PostMapping("/comentario")
	public String Comentario (Model model, Foro foros) {
		
		repository1.save(foros);

		return "ComentarioGuardado";
	}
	
		
	@GetMapping("/publico")
	public String CursoPublico(Model model,Pageable page) {

		model.addAttribute("CursosPublico", repository2.findAll (page));
		
		return "CursoPublico";
	}
	
	@RequestMapping("/privado")
	public String nuevoCursoPrivado(Model model, Pageable page) {

		model.addAttribute("CursoPrivados", repository3.findAll (page));
		
		return "CursoPrivado";
	}
	
	@GetMapping("/publico/nuevo")
	public String nuevoPublico(Model model) {

		return "NuevoPublico";

	}
	@GetMapping("/privado/nuevo")
	public String nuevoPrivado(Model model) {

		return "NuevoPrivado";

	}
	
	@PostMapping("/curso/guardado")
	public String Comentario (Model model, CursoPublico cursospublico,CursoPrivado cursosprivado) {
		
		repository2.save(cursospublico);
		repository3.save(cursosprivado);

		return "CursoGuardado";
	}
	
	
	
	@GetMapping("/loginout")
    public String loginout() {
    	
    	return "LoginOut";
    }
    
    @GetMapping("/loginerror")
    public String loginerror() {
    	
    	return "LoginError";
    }
    

    @GetMapping("/admin")
    public String admin(Model model,  Pageable page) {
    	
    	model.addAttribute("usuarios", repository.findAll (page));
    	
    	return "Admin";
    }
    
    @RequestMapping("/contactar")
	public String Contacto () {

		return "Contacto";
	}
    @RequestMapping("/lista")
  	public String lista (Model model,  Pageable page) {
    	
    	model.addAttribute("usuarios", repository.findAll (page));

  		return "Lista";
  	}
	
}