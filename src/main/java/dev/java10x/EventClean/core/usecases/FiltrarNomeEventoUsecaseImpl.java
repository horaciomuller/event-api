package dev.java10x.EventClean.core.usecases;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.NotFoundEventException;
import org.springframework.stereotype.Service;

public class FiltrarNomeEventoUsecaseImpl implements FiltrarNomeEventoUsecase {

    private final EventoGateway eventoGateway;

    public FiltrarNomeEventoUsecaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(String nome) {
        return eventoGateway.filtrarPorNome(nome)
            .orElseThrow(() -> new NotFoundEventException("Evento com nome " + nome + " não encontrado."));
    }
}
