package dev.java10x.EventClean.core.usecases;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.enuns.TipoEvento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infrastructure.exception.NotFoundEventException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FiltrarIdentificadorEventoUsecaseImplTest {

    @Mock
    private EventoGateway eventoGateway;

    @InjectMocks
    private FiltrarIdentificadorEventoUsecaseImpl filtrarIdentificadorEventoUsecase;

    @Test
    void deveRetornarEventoQuandoIdentificadorExistir() {
        // Arrange
        String identifier = "TCHC123";
        Evento eventMock = new Evento(
            1L,
            "Tech Conference 2024",
            "A cutting-edge technology conference focused on AI and machine learning",
            identifier,
            LocalDateTime.of(2024, 5, 10, 9, 0),
            LocalDateTime.of(2024, 5, 10, 18, 0),
            "Tech Hub Arena",
            500,
            "Tech Innovators",
            TipoEvento.WORKSHOP);
        Mockito.when(eventoGateway.filtrarPorIdentificador(identifier))
            .thenReturn(Optional.of(eventMock));

        // Act
        Evento event = filtrarIdentificadorEventoUsecase.execute(identifier);

        // Assert
        Assertions.assertNotNull(event);
        Assertions.assertEquals(identifier, event.identificador());
        Assertions.assertEquals("Tech Conference 2024", event.nome());
        Mockito.verify(eventoGateway).filtrarPorIdentificador(identifier);
    }

    @Test
    void deveLancarExcecaoQuandoEventoNaoExistir() {
        // Arrange
        System.out.println("Executando teste deveLancarExcecaoQuandoEventoNaoExistir...");
        String identificador = "evento-inexistente";

        Mockito.when(eventoGateway.filtrarPorIdentificador(identificador))
            .thenReturn(Optional.empty()); // Simulando a ausência do evento

        // Act & Assert
        NotFoundEventException exception = Assertions.assertThrows(
            NotFoundEventException.class, // Verificando que a exceção é lançada
            () -> filtrarIdentificadorEventoUsecase.execute(identificador)
        );

        // Verificando a mensagem da exceção
        Assertions.assertEquals("Evento com identificador evento-inexistente não encontrado.", exception.getMessage());
        Mockito.verify(eventoGateway).filtrarPorIdentificador(identificador); // Verificando a chamada do método
    }
}
