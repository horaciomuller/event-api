package dev.java10x.EventClean.infrastructure.mapper;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infrastructure.persistence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento) {
        return new EventoEntity(
            evento.id(),
            evento.nome(),
            evento.descricao(),
            evento.identificador(),
            evento.dataInicio(),
            evento.dataFim(),
            evento.localEvento(),
            evento.capacidade(),
            evento.imgUrl(),
            evento.tipo()
        );

    }

    public Evento toDomain(EventoEntity eventoEntity) {
        return new Evento(
            eventoEntity.getId(),
            eventoEntity.getNome(),
            eventoEntity.getDescricao(),
            eventoEntity.getIdentificador(),
            eventoEntity.getDataInicio(),
            eventoEntity.getDataFim(),
            eventoEntity.getLocalEvento(),
            eventoEntity.getCapacidade(),
            eventoEntity.getImgUrl(),
            eventoEntity.getTipo()
        );

    }


}
