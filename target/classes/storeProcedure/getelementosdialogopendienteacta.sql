USE `heroku_ddeb90f13531d40`;
DROP procedure IF EXISTS `getelementosdialogopendienteacta`;

DELIMITER $$
USE `heroku_ddeb90f13531d40`$$
CREATE PROCEDURE `getelementosdialogopendienteacta`(IN _proyectoid bigint(20), IN _actaid bigint(20))
BEGIN
	
		DECLARE _fechaActa datetime;
        
		if exists(select * from proyecto where proyecto_id =  _proyectoid) then 
			
			 select fecha into _fechaActa from acta where acta_id = _actaid;

        
        	 SELECT el.id,
				el.descripcion,
				el.estado,
				el.fecha_compromiso,
				el.elemento_dialogo_id,
				el.tema_id,
				el.tipo_elemento_dialogo_cod_rol,
				el.usuario_username,
                el.titulo,
                CONCAT(ac.correlativo, ".", el.correlativo)
			FROM elemento_dialogo el
            INNER JOIN tema tm
            ON el.tema_id = tm.id
            INNER JOIN acta ac
            ON tm.acta_acta_id = ac.acta_id
            WHERE el.tema_id in (select id from tema inner join acta on tema.acta_acta_id = acta.acta_id where acta.proyecto_proyecto_id =  _proyectoid)
            AND el.estado not in ( "DELE", "DONE")
            AND ac.acta_id <> _actaid
            ORDER BY ac.fecha, el.fecha_compromiso;

        end if;
        
END$$

DELIMITER ;