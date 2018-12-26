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
@Table(name = "elementoDialogo")
public class ElementoDialogo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@Column(name = "fechaCompromiso")
	private Date fechaCompromiso;
	@Column(name = "descripcion", length = 1000)
	private String descripcion;
	@Column(name = "estado", length = 5) //TODO-DOING-DONE-DEL
	private String estado;
	@ManyToOne
	private TipoElementoDialogo tipoElementoDialogo;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Tema tema;	
	@ManyToOne
	private ElementoDialogo elementoDialogo;	
	@Column(name = "titulo", length = 50)
	private String titulo;
	@Column(name = "correlativo")
	private long correlativo;	
	
}
