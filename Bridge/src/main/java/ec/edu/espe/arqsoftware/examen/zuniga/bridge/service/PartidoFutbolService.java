/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.bridge.service;



import ec.edu.espe.arqsoftware.examen.zuniga.bridge.soap.ObtenerPartidosRequest;
import ec.edu.espe.arqsoftware.examen.zuniga.bridge.soap.ObtenerPartidosResponse;
import ec.edu.espe.arqsoftware.examen.zuniga.bridge.soap.PartidoRS;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author sebas
 */
@Service
public class PartidoFutbolService extends WebServiceGatewaySupport {

     private String endpoint = "http://localhost:8090/ws/partido.wsdl";


    public  List<PartidoRS>  obtenerPartidos()  {
        ObtenerPartidosRequest request = new ObtenerPartidosRequest() ;
        ObtenerPartidosResponse response   = (ObtenerPartidosResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint, request);
        return response.getPartidosRS();
    }
}
