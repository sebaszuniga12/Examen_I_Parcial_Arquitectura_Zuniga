/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.endpoint;

import ec.edu.espe.arqsoftware.examen.zuniga.server.exception.CreateException;
import ec.edu.espe.arqsoftware.examen.zuniga.server.service.ComprarBoletoService;
import ec.edu.espe.arqsoftware.examen.zuniga.server.ws.CompraRequest;
import ec.edu.espe.arqsoftware.examen.zuniga.server.ws.CompraResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author sebas
 */
@Endpoint
@Slf4j
public class ComprarBoletoEndPoint {
    
    private static final String NAMESPACE_URI = "http://espe.edu.ec/arqsoftware/examen/zuniga/server/ws";
     private final ComprarBoletoService service;

    public ComprarBoletoEndPoint(ComprarBoletoService service) {
        this.service = service;
    }
     
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "compraRequest")
    @ResponsePayload
    public CompraResponse crearCompraBoleto(@RequestPayload CompraRequest request) throws CreateException{ 
          try {
            this.service.comprarBoleto(request.getCodigoPartido(),request.getCodigoPartido());
            CompraResponse response = new CompraResponse();
            return response;
        } catch (Exception e) {
            String exceptionMessage = e.getMessage();
            log.error("Ocurrio un error al comprar el boleto. {} - retorna badrequest - causado por: {}", e.getMessage(), exceptionMessage);
            throw new CreateException("Error: " + exceptionMessage);
        }
        
        
    }
}
