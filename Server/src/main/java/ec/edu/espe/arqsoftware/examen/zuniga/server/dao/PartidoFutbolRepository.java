/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.dao;

import ec.edu.espe.arqsoftware.examen.zuniga.server.model.PartidoFutbol;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface PartidoFutbolRepository extends JpaRepository<PartidoFutbol, String>{
    List<PartidoFutbol> findAllByFechaAfter(Date fecha);
}
