package ComputerAcademy;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UsuariosRepository UsuariosRepository;

    @PostConstruct
    private void initDatabase() {
    	
    	UsuariosRepository.save(new Usuario("user", "userapellido","9165656556","user@user.com", "pass", "ROLE_USER"));
		UsuariosRepository.save(new Usuario("admin", "adminapellido","762652552","admin@admin.com","adminpass", "ROLE_USER", "ROLE_ADMIN"));
		
    }

}
