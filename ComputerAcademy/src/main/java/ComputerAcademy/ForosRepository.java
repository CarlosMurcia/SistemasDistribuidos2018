package ComputerAcademy;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="foro")
public interface ForosRepository extends JpaRepository<Foro, Long> {
	

	@CacheEvict(allEntries=true)
	Foro save(Foro foro);
	

	@Cacheable
	Foro findByNombre(String nombre);
	Foro findByComentario(String comentario);
	
	@Cacheable
	List<Foro> findAll();
	
}
