package dev.java10x.EnvetClean.infrastructure.beans;
import dev.java10x.EnvetClean.core.gateway.EventoGateway;
import dev.java10x.EnvetClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
   public CriarEventoUsecase criarEventoUsecase(EventoGateway eventoGateway) {
        return new CriarEventoUsecaseImpl(eventoGateway);
   }

   @Bean
    public BuscarEventoUsecase buscarEventoUsecase(EventoGateway eventoGateway) {
        return new BuscarEventoUsecaseImpl(eventoGateway);
   }

    @Bean
    public FiltrarIdentificadorEventoUsacase filtrarIdentificadorEventoUsacase(EventoGateway eventoGateway) {
        return new FiltrarIdentificadorEventoUsecaseImpl(eventoGateway);
    }




}
