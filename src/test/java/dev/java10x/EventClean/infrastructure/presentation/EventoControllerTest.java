package dev.java10x.EventClean.infrastructure.presentation;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.enuns.TipoEvento;
import dev.java10x.EventClean.core.usecases.CriarEventoUsecase;
import dev.java10x.EventClean.core.usecases.BuscarEventoUsecase;
import dev.java10x.EventClean.core.usecases.FiltrarIdentificadorEventoUsacase;
import dev.java10x.EventClean.infrastructure.dtos.EventoDto;
import dev.java10x.EventClean.infrastructure.mapper.EventoDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class EventoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CriarEventoUsecase criarEventoUsecase;

    @Autowired
    private BuscarEventoUsecase buscarEventoUsecase;

    @Autowired
    private FiltrarIdentificadorEventoUsacase filtrarIdentificadorEventoUsecase;

    @Autowired
    private EventoDtoMapper eventoDtoMapper;

    private EventoDto eventoDto;

    @BeforeEach
    public void setUp() {
        eventoDto = new EventoDto(
            1L,
            "Tech Conference 2024",
            "A cutting-edge technology conference focused on AI and ML",
            "TCHC123",
            LocalDateTime.of(2024, 5, 10, 9, 0),
            LocalDateTime.of(2024, 5, 10, 18, 0),
            "Tech Hub Arena",
            500,
            "Tech Innovators",
            TipoEvento.WORKSHOP
        );
    }

    @Test
    public void testCriarEvento() throws Exception {
        // Gerando um identificador único
        String identificadorUnico = "TCHC123-" + UUID.randomUUID();

        mockMvc.perform(post("/api/v1/criarevento")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                    "\"nome\":\"Tech Conference 2024 teste 2 direto no banco\"," +
                    "\"descricao\":\"A cutting-edge technology conference focused on AI and ML\"," +
                    "\"identificador\":\"" + identificadorUnico + "\"," +
                    "\"local\":\"Tech Hub Arena\"," +
                    "\"capacidade\":500," +
                    "\"organizador\":\"Tech Innovators\"," +
                    "\"tipoEvento\":\"WORKSHOP\"," +
                    "\"dataInicio\":\"2024-05-10T09:00:00\"," +
                    "\"dataFim\":\"2024-05-10T18:00:00\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.mensagem").value("Evento cadastrado com sucesso no nosso banco de dados"))
            .andExpect(jsonPath("$.dadosEvento.nome").value("Tech Conference 2024 teste 2 direto no banco"));
    }
}
