package dev.java10x.EventClean.infrastructure.dtos;
import dev.java10x.EventClean.core.enuns.TipoEvento;
import java.time.LocalDateTime;

public record EventoDto(Long id,
                        String nome,
                        String descricao,
                        String identificador,
                        LocalDateTime dataInicio,
                        LocalDateTime dataFim,
                        String localEvento,
                        Integer capacidade,
                        String imgUrl,
                        TipoEvento tipo) {}
