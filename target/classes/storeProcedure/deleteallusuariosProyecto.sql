USE `heroku_ddeb90f13531d40`;
DROP procedure IF EXISTS `deleteallusuariosproyecto`;

DELIMITER $$
USE `heroku_ddeb90f13531d40`$$
CREATE PROCEDURE `deleteallusuariosproyecto`(IN _proyectoid bigint(20))
BEGIN
	
		if exists(select * from proyecto where proyecto_id =  _proyectoid) then 
        
        	delete from usuario_proyecto where proyecto_proyecto_id = _proyectoid;
        end if;
        
END$$

DELIMITER ;