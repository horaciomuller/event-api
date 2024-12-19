package dev.java10x.EventClean.core.gateway;
import dev.java10x.EventClean.core.entities.Evento;
import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    Optional<Evento> filtrarPorIdentificador(String identificador);
    Evento criarEvento(Evento evento);
    List<Evento> buscarEventos();
    boolean existePorIdentificador(String identificador);

}
