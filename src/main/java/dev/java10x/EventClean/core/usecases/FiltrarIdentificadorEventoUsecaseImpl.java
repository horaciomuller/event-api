package dev.java10x.EventClean.core.usecases;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.NotFoundEventException;

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
