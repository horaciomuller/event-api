package dev.java10x.EventClean.infrastructure.presentation;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.BuscarEventoUsecase;
import dev.java10x.EventClean.core.usecases.CriarEventoUsecase;
import dev.java10x.EventClean.core.usecases.FiltrarIdentificadorEventoUsacase;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/v1/")
public class EventoController {

    private final CriarEventoUsecase criarEventoUsecase;
    private final EventoDtoMapper eventoDtoMapper;
    private final BuscarEventoUsecase buscarEventoUsecase;
    private final FiltrarIdentificadorEventoUsacase filtrarIdentificadorEventoUsecase;

    public EventoController(CriarEventoUsecase criarEventoUsecase, EventoDtoMapper eventoDtoMapper, BuscarEventoUsecase buscarEventoUsecase, FiltrarIdentificadorEventoUsacase filtrarIdentificadorEventoUsecase) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUsecase = buscarEventoUsecase;
        this.filtrarIdentificadorEventoUsecase = filtrarIdentificadorEventoUsecase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto eventoDto) {
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.toDomain(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("dadosEvento", eventoDtoMapper.toDto(novoEvento));
        return ResponseEntity.ok(response);
    }


    @GetMapping("buscarevento")
    public List<EventoDto> buscarEventos() {
        return
            buscarEventoUsecase.execute().stream().map(eventoDtoMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/identificador/{identificador}")
    public ResponseEntity<Evento> buscarPorIdentificador(@PathVariable String identificador) {
        Evento evento = filtrarIdentificadorEventoUsecase.execute(identificador);
        return ResponseEntity.ok(evento);
    }
}

