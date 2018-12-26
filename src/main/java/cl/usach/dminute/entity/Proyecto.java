package cl.usach.dminute.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id
	@GeneratedValue
	@Column(name = "proyectoId")
	private long proyectoId;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "fechaInicio")
	private Date fechaInicio;
	@Column(name = "fechaFin")
	private Date fechaFin;
	@Column(name = "estado", length = 1)
	private String estado;
	@ManyToOne
	private Usuario usuario;
}
