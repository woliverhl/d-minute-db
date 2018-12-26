package cl.usach.dminute.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tipoElementoDialogo")
public class TipoElementoDialogo {

	@Id
	@Column(name = "codRol", length = 2)
	private String codRol;
	@Column(name = "descripcion", length = 50)
	private String descripcion;
	
}
