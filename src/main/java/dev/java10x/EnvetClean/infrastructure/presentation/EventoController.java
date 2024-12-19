package dev.java10x.EnvetClean.infrastructure.presentation;
import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.core.usecases.BuscarEventoUsecase;
import dev.java10x.EnvetClean.core.usecases.CriarEventoUsecase;
import dev.java10x.EnvetClean.infrastructure.dtos.EventoDto;
import dev.java10x.EnvetClean.infrastructure.mapper.EventoDtoMapper;
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

    public EventoController(CriarEventoUsecase criarEventoUsecase, EventoDtoMapper eventoDtoMapper, BuscarEventoUsecase buscarEventoUsecase) {
        this.criarEventoUsecase = criarEventoUsecase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUsecase = buscarEventoUsecase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto eventoDto) {
        Evento novoEvento = criarEventoUsecase.execute(eventoDtoMapper.toDomain(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem: ", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("Dados do evento: ", eventoDtoMapper.toDto(novoEvento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("buscarevento")
    public List<EventoDto> buscarEventos() {
        return
            buscarEventoUsecase.execute().stream().map(eventoDtoMapper::toDto).collect(Collectors.toList());
    }


}
