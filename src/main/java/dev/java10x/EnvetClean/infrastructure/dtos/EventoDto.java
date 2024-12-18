package dev.java10x.EnvetClean.infrastructure.dtos;
import dev.java10x.EnvetClean.core.enuns.TipoEvento;
import java.time.LocalDateTime;

public record EventoDto(Long id,
                        String nome,
                        String descricao,
                        String identificador,
                        LocalDateTime dataInicio,
                        LocalDateTime dataFim,
                        String localEvento,
                        Integer capacidade,
                        String organizador,
                        TipoEvento tipo) {}
