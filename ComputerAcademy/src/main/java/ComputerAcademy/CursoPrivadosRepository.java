package ComputerAcademy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoPrivadosRepository extends JpaRepository<CursoPrivado, Long> {
	
	CursoPrivado findById(Long id);

}
