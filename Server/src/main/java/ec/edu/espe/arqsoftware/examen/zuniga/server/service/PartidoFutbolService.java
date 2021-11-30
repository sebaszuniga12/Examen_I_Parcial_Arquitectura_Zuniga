/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.service;

import ec.edu.espe.arqsoftware.examen.zuniga.server.dao.PartidoFutbolRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.server.model.PartidoFutbol;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author sebas
 */
public class PartidoFutbolService {

    private final PartidoFutbolRepository partidoFutbolRepo;

    public PartidoFutbolService(PartidoFutbolRepository partidoFutbolRepo) {
        this.partidoFutbolRepo = partidoFutbolRepo;
    }

    public List<PartidoFutbol> obtainPartidoAfterActualDate() {
        LocalDateTime now = LocalDateTime.now();
        return this.partidoFutbolRepo.findAllByFechaAfter(java.sql.Timestamp.valueOf(now));
    }
}
