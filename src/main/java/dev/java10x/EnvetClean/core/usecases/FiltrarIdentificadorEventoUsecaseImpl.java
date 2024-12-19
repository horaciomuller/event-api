package dev.java10x.EnvetClean.core.usecases;
import dev.java10x.EnvetClean.core.entities.Evento;
import dev.java10x.EnvetClean.core.gateway.EventoGateway;
import dev.java10x.EnvetClean.infrastructure.exception.NotFoundEventException;

public class FiltrarIdentificadorEventoUsecaseImpl implements FiltrarIdentificadorEventoUsacase {

    private final EventoGateway eventoGateway;

    public FiltrarIdentificadorEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtrarPorIdentificador(identificador)
            .orElseThrow(() -> new NotFoundEventException("Evento com identificador " + identificador + " não encontrado."));
    }
}
