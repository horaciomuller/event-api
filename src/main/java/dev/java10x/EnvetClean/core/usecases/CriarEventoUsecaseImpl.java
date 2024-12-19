package dev.java10x.EnvetClean.core.usecases;
import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.core.gateway.EventoGateway;
import dev.java10x.EnvetClean.infrastructure.exception.DuplicateEventException;

public class CriarEventoUsecaseImpl implements CriarEventoUsecase {

    private final EventoGateway eventoGateway;

    public CriarEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        if (eventoGateway.existePorIdentificador(evento.identificador())) {
            throw new DuplicateEventException("O identificador numero: " + evento.identificador() + " ja esta em uso para outro evento!");
        }
        return eventoGateway.criarEvento(evento);
    }
}
