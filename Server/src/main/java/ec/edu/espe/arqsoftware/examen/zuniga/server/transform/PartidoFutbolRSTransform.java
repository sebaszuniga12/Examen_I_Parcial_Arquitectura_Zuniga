/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.transform;

import ec.edu.espe.arqsoftware.examen.zuniga.server.model.PartidoFutbol;
import ec.edu.espe.arqsoftware.examen.zuniga.server.ws.PartidoRS;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author sebas
 */
public class PartidoFutbolRSTransform {

    public static PartidoRS buildPartidoFutbolTransformRS(PartidoFutbol partidoFutbol) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(partidoFutbol.getFecha());
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return PartidoRS.builder()
                .codigo(partidoFutbol.getCodigo())
                .equipoLocal(partidoFutbol.getEquipoLocal())
                .equipoVisita(partidoFutbol.getEquipoVisita())
                .lugar(partidoFutbol.getLugar())
                .fecha(fecha)
                .build();
    }

}
