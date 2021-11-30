/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.examen.zuniga.server.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "partido_futbol")

public class PartidoFutbol implements Serializable {

    @Id
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "equipo_local")
    private String equipoLocal;
    @Column(name = "equipo_visita")
    private String equipoVisita;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "lugar")
    private String lugar;
    @OneToMany(mappedBy = "codigoPartido")
    private List<LocalidadPartido> localidadPartido;

}
