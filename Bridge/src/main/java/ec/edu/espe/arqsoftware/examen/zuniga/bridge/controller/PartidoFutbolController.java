/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.bridge.controller;

import ec.edu.espe.arqsoftware.examen.zuniga.bridge.service.PartidoFutbolService;
import ec.edu.espe.arqsoftware.examen.zuniga.bridge.soap.PartidoRS;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@Slf4j
@RestController
@RequestMapping("/api/partido")
public class PartidoFutbolController {

    private final PartidoFutbolService service;

    public PartidoFutbolController(PartidoFutbolService service) {
        this.service = service;
    }

    @GetMapping(value = "/actual")
    public ResponseEntity comprarBoleto() {
        try {
            List<PartidoRS> response = this.service.obtenerPartidos();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
