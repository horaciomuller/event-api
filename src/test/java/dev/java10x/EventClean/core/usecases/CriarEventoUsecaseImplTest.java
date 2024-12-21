package dev.java10x.EventClean.core.usecases;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.enuns.TipoEvento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.DuplicateEventException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class CriarEventoUsecaseImplTest {

    @Mock
    private EventoGateway eventoGateway;

    @InjectMocks
    private CriarEventoUsecaseImpl criarEventoUsecase;

    @Test
    void deveCriarEventoQuandoIdentificadorNaoExistir() {
        // Arrange
        String identificador = "EVENTO123";
        Evento eventoMock = new Evento(
            1L,
            "Evento de Teste",
            "Descrição do evento de teste",
            identificador,
            LocalDateTime.of(2024, 6, 15, 9, 0),
            LocalDateTime.of(2024, 6, 15, 18, 0),
            "Local do Evento",
            100,
            "Organizador do Evento",
            TipoEvento.PALESTRA
        );

        Mockito.when(eventoGateway.existePorIdentificador(identificador)).thenReturn(false);
        Mockito.when(eventoGateway.criarEvento(eventoMock)).thenReturn(eventoMock);

        // Act
        Evento eventoCriado = criarEventoUsecase.execute(eventoMock);

        // Assert
        Assertions.assertNotNull(eventoCriado);
        Assertions.assertEquals(identificador, eventoCriado.identificador());
        Mockito.verify(eventoGateway).existePorIdentificador(identificador);
        Mockito.verify(eventoGateway).criarEvento(eventoMock);
    }

    @Test
    void deveLancarExcecaoQuandoIdentificadorJaExistir() {
        // Arrange
        String identificador = "EVENTO123";
        Evento eventoMock = new Evento(
            1L,
            "Evento de Teste",
            "Descrição do evento de teste",
            identificador,
            LocalDateTime.of(2024, 6, 15, 9, 0),
            LocalDateTime.of(2024, 6, 15, 18, 0),
            "Local do Evento",
            100,
            "Organizador do Evento",
            TipoEvento.PALESTRA
        );

        Mockito.when(eventoGateway.existePorIdentificador(identificador)).thenReturn(true);

        // Act & Assert
        DuplicateEventException exception = Assertions.assertThrows(
            DuplicateEventException.class,
            () -> criarEventoUsecase.execute(eventoMock)
        );

        Assertions.assertEquals("O identificador numero: EVENTO123 ja esta em uso para outro evento!", exception.getMessage());
        Mockito.verify(eventoGateway).existePorIdentificador(identificador);
        Mockito.verifyNoMoreInteractions(eventoGateway);
    }
}
