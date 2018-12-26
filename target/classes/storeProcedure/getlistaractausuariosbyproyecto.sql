USE `heroku_ddeb90f13531d40`;
DROP procedure IF EXISTS `getlistaractausuariosbyproyecto`;

DELIMITER $$
USE `heroku_ddeb90f13531d40`$$
CREATE PROCEDURE `getlistaractausuariosbyproyecto`(IN _proyectoid bigint(20))
BEGIN
	if exists(select * from proyecto where proyecto_id =  _proyectoid and estado = 'A') then 
    
		select asiste, 
			secretario, 
			usuario_acta.usuario_username,
            acta_acta_id,
            usuario.nombre,
            usuario.apellido
		from usuario_acta  
		inner join acta
		on usuario_acta.acta_acta_id = acta.acta_id
		inner join usuario
        on usuario.username = usuario_acta.usuario_username
		where acta.acta_id
		in (
			select distinct _acta.acta_id
			from acta _acta
			inner join proyecto _proyecto
			on _proyecto.proyecto_id = _acta.proyecto_proyecto_id
			where _proyecto.estado = 'A'
            and _acta.estado = 'A'
            AND _proyecto.proyecto_id = _proyectoid
		)
		order by acta.acta_id asc;
    
    end if;

END$$

DELIMITER ;

