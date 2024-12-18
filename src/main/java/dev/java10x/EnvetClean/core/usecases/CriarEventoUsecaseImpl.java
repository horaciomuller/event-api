package dev.java10x.EnvetClean.core.usecases;
import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.core.gateway.EventoGateway;

public class CriarEventoUsecaseImpl implements CriarEventoUsecase {

    private final EventoGateway eventoGateway;

    public CriarEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        return eventoGateway.criarEvento(evento);
    }
}
