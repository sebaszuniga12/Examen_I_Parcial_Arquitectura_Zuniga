package ec.edu.espe.arqsoftware.examen.zuniga.bridge.configuration;

import ec.edu.espe.arqsoftware.examen.zuniga.bridge.service.ComprarBoletoService;
import ec.edu.espe.arqsoftware.examen.zuniga.bridge.service.PartidoFutbolService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {

    @Autowired
    private ComprarBoletoService client;
    private PartidoFutbolService clientPartido;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ec.edu.espe.arqsoftware.examen.zuniga.bridge.soap");
        return marshaller;
    }

    @Bean
    @Primary
    public ComprarBoletoService boleto(Jaxb2Marshaller marshaller) {
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    @Primary
    public PartidoFutbolService partido(Jaxb2Marshaller marshaller) {
        clientPartido.setMarshaller(marshaller);
        clientPartido.setUnmarshaller(marshaller);
        return clientPartido;
    }

}
