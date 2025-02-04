package dev.java10x.EventClean.infrastructure.mapper;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {

    public EventoDto toDto(Evento evento) {
        return new EventoDto(
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

    public Evento toDomain(EventoDto eventoDto) {
        return new Evento(
            eventoDto.id(),
            eventoDto.nome(),
            eventoDto.descricao(),
            eventoDto.identificador(),
            eventoDto.dataInicio(),
            eventoDto.dataFim(),
            eventoDto.localEvento(),
            eventoDto.capacidade(),
            eventoDto.imgUrl(),
            eventoDto.tipo()
        );
    }
    }
