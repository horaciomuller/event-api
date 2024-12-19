package dev.java10x.EventClean.core.usecases;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.DuplicateEventException;

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
