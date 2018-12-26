USE `heroku_ddeb90f13531d40`;
DROP procedure IF EXISTS `getelementosdialogoproyecto`;

DELIMITER $$
USE `heroku_ddeb90f13531d40`$$
CREATE PROCEDURE `getelementosdialogoproyecto`(IN _proyectoid bigint(20))
BEGIN
	
		if exists(select * from proyecto where proyecto_id =  _proyectoid) then 
        
        	 SELECT el.id,
				el.descripcion,
				el.estado,
				el.fecha_compromiso,
				el.elemento_dialogo_id,
				el.tema_id,
				el.tipo_elemento_dialogo_cod_rol,
                CONCAT(us.nombre, " ", us.apellido),
                el.titulo,
                CONCAT(ac.correlativo, ".", el.correlativo)
			FROM elemento_dialogo el
            INNER JOIN tema tm
            ON el.tema_id = tm.id
            INNER JOIN acta ac
            ON tm.acta_acta_id = ac.acta_id
            INNER JOIN usuario us
            ON us.username = el.usuario_username
            WHERE el.tema_id in (select id from tema inner join acta on tema.acta_acta_id = acta.acta_id where acta.proyecto_proyecto_id =  _proyectoid)
            AND el.estado <> "DELE"
            ORDER BY el.fecha_compromiso;

        end if;
        
END$$

DELIMITER ;

