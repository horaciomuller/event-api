package dev.java10x.EnvetClean.infrastructure.persistence;
import dev.java10x.EnvetClean.core.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {

    Optional<Evento> findByIdentificador(String identificador);


}
