/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.service;

import ec.edu.espe.arqsoftware.examen.zuniga.server.dao.LocalidadPartidoRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.server.dao.PartidoFutbolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class LocalidadPartidoService {
    
     private final LocalidadPartidoRepository localidadPartidoRepo;
     private final PartidoFutbolRepository partidoFutbolRepo;

    public LocalidadPartidoService(LocalidadPartidoRepository localidadPartidoRepo, PartidoFutbolRepository partidoFutbolRepo) {
        this.localidadPartidoRepo = localidadPartidoRepo;
        this.partidoFutbolRepo = partidoFutbolRepo;
    }
     

}
