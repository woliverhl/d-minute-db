package cl.usach.dminute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuarioProyecto")
public class UsuarioProyecto {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Proyecto proyecto;
	
	public UsuarioProyecto() {
		this.usuario = new Usuario();
		this.proyecto = new Proyecto();
	}
	
}
