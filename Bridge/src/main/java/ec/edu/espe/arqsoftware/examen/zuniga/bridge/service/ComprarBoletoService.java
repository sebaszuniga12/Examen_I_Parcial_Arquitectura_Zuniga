/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.bridge.service;


import ec.edu.espe.arqsoftware.examen.zuniga.bridge.soap.CompraRequest;
import ec.edu.espe.arqsoftware.examen.zuniga.bridge.soap.CompraResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author sebas
 */
@Service
public class ComprarBoletoService extends WebServiceGatewaySupport {

    private String endpoint = "http://localhost:8090/ws/partido.wsdl";

    public CompraResponse crearCompraBoleto(String codigoPartido, String codigoLocalidad) {
        CompraRequest request = new CompraRequest();
        request.setCodigoPartido(codigoPartido);
        request.setCodigoLocalidad(codigoLocalidad);
        CompraResponse response
                = (CompraResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        return response;
    }
}
