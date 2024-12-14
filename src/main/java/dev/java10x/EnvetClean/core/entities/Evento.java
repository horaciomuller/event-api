package dev.java10x.EnvetClean.core.entities;
import dev.java10x.EnvetClean.core.enuns.TipoEvento;

import java.time.LocalDateTime;

public record Evento(Long id,
                     String nome,
                     String descricao,
                     String identificador,
                     LocalDateTime dataInicio,
                     LocalDateTime dataFim,
                     String localEvento,
                     Integer capacidade,
                     String organizador,
                     TipoEvento tipo) {}
