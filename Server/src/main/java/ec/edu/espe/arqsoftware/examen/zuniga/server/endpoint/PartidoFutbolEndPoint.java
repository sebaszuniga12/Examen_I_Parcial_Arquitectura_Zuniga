/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.endpoint;

import ec.edu.espe.arqsoftware.examen.zuniga.server.model.PartidoFutbol;
import ec.edu.espe.arqsoftware.examen.zuniga.server.service.PartidoFutbolService;
import ec.edu.espe.arqsoftware.examen.zuniga.server.transform.PartidoFutbolRSTransform;
import ec.edu.espe.arqsoftware.examen.zuniga.server.ws.ObtenerPartidosRequest;
import ec.edu.espe.arqsoftware.examen.zuniga.server.ws.ObtenerPartidosResponse;
import ec.edu.espe.arqsoftware.examen.zuniga.server.ws.PartidoRS;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author sebas
 */


public class PartidoFutbolEndPoint {
     private static final String NAMESPACE_URI = "http://espe.edu.ec/arqsoftware/examen/zuniga/server/ws";
     private final PartidoFutbolService service;

    public PartidoFutbolEndPoint(PartidoFutbolService service) {
        this.service = service;
    }
     
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "compraRequest")
    @ResponsePayload
   public ObtenerPartidosResponse crearCompraBoleto(@RequestPayload ObtenerPartidosRequest request) throws RuntimeException {         
    ObtenerPartidosResponse response = new ObtenerPartidosResponse();
        List<PartidoRS> responseList = new ArrayList<>();
        List<PartidoFutbol> partidos = this.service.obtainPartidoAfterActualDate();
        try{
            partidos.forEach(c -> {
                try {
                    responseList.add(PartidoFutbolRSTransform.buildPartidoFutbolTransformRS(c));
                } catch (DatatypeConfigurationException ex) {
                    Logger.getLogger(PartidoFutbolEndPoint.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            response.setPartidosRS(responseList);
            return response;
        }catch (Exception ex){
            throw new RuntimeException();
        }
   }
}
