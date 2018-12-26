package cl.usach.dminute.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "log")
public class LoggDminute {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "username")
	private String username;
	@Column(name = "detalle")
	private String detalle;
	@Column(name = "url")
	private String url;
	

}
