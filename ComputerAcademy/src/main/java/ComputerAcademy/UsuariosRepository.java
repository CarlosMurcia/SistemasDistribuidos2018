package ComputerAcademy;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuariosRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByNombre(String nombre);
    Usuario findByEmail(String email);
    Usuario findById(Long id);
    
}
