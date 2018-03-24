package ComputerAcademy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CursosPublicoRepository extends JpaRepository<CursoPublico, Long> {

    CursoPublico findById(Long id);
}
