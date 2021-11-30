/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.bridge.controller;

import ec.edu.espe.arqsoftware.examen.zuniga.bridge.service.ComprarBoletoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@Slf4j
@RestController
@RequestMapping("/api/compra")
public class ComprarBoletoController {

    private final ComprarBoletoService service;

    public ComprarBoletoController(ComprarBoletoService service) {
        this.service = service;
    }
    
     @GetMapping(value = "{codigoPartido}/{codigoLocalidad}")
    public ResponseEntity comprarBoleto(@PathVariable("codigoPartido") String codigoPartido, String codigoLocalidad) {
        try {
            this.service.crearCompraBoleto(codigoPartido,codigoLocalidad);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
