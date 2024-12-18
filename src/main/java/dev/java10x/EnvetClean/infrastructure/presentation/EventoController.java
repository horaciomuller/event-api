package dev.java10x.EnvetClean.infrastructure.presentation;
import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.core.usecases.CriarEventoUsecase;
import dev.java10x.EnvetClean.infrastructure.dtos.EventoDto;
import dev.java10x.EnvetClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUsecase criarEventoUsecase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(CriarEventoUsecase criarEventoUsecase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto eventoDto) {
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.toDomain(eventoDto));
        return eventoDtoMapper.toDto(novoEvento);
    }

    @GetMapping
    public String listaevento() {
        return "Lista de eventos";
    }


}
