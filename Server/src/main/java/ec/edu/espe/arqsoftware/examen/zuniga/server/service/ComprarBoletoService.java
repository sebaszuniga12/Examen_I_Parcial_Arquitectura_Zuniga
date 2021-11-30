/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.service;

import ec.edu.espe.arqsoftware.examen.zuniga.server.dao.LocalidadPartidoRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.server.dao.PartidoFutbolRepository;
import ec.edu.espe.arqsoftware.examen.zuniga.server.exception.CreateException;
import ec.edu.espe.arqsoftware.examen.zuniga.server.model.LocalidadPartido;
import ec.edu.espe.arqsoftware.examen.zuniga.server.model.PartidoFutbol;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class ComprarBoletoService {
     private final LocalidadPartidoRepository localidadPartidoRepo;
     private final PartidoFutbolRepository partidoFutbolRepo;

    public ComprarBoletoService(LocalidadPartidoRepository localidadPartidoRepo, PartidoFutbolRepository partidoFutbolRepo) {
        this.localidadPartidoRepo = localidadPartidoRepo;
        this.partidoFutbolRepo = partidoFutbolRepo;
    }
     
     @Transactional
    public LocalidadPartido comprarBoleto(String codigoPartido, String codigoLocalidad){
         Optional<PartidoFutbol> partidoOpt = this.partidoFutbolRepo.findById(codigoPartido);
          if (partidoOpt.isPresent()) {
          }
          else{
              Optional<LocalidadPartido> localidadOpt = this.localidadPartidoRepo.findById(codigoLocalidad);
               if (localidadOpt.isPresent()) {
                   localidadOpt.get().setDisponibilidad(localidadOpt.get().getDisponibilidad() -1);
                    return this.localidadPartidoRepo.save(localidadOpt.get());
               }
               else{
                   throw new CreateException("El codigo de localidad no existe");
               } 
          }
          throw new CreateException("El codigo de partido no existe");
    }
}
