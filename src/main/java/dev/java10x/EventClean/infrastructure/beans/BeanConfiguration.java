package dev.java10x.EventClean.infrastructure.beans;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.usecases.*;
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

    @Bean
    public FiltrarNomeEventoUsecase filtrarNomeEventoUsecase(EventoGateway eventoGateway) {
        return new FiltrarNomeEventoUsecaseImpl(eventoGateway);
    }




}
