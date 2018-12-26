USE `heroku_ddeb90f13531d40`;
DROP procedure IF EXISTS `getlistaractabyproyecto`;

DELIMITER $$
USE `heroku_ddeb90f13531d40`$$
CREATE PROCEDURE `getlistaractabyproyecto`(IN _proyectoid bigint(20))
BEGIN
		if exists(select * from proyecto where proyecto_id =  _proyectoid and estado = 'A') then 
			select acta_id, 
				fecha,  
                resumen,
                estado,
                hora_incio,
                hora_fin,
                usuario_username,
                correlativo
            from acta where proyecto_proyecto_id = _proyectoid
            and estado = 'A'
            order by fecha desc;
        end if;
END$$

DELIMITER ;
