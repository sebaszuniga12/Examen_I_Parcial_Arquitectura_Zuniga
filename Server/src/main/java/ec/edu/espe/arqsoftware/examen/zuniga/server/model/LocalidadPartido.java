/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author sebas
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "localidad_partido")

public class LocalidadPartido implements Serializable {

    @Id
    @Column(name = "codigo_localidad")
    private String codigoLocalidad;
    @Column(name = "disponibilidad")
    private int disponibilidad;
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @ManyToOne
    private PartidoFutbol codigoPartido;
    
}
