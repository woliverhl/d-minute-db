USE `heroku_ddeb90f13531d40`;
DROP procedure IF EXISTS `deleteallusuariosacta`;

DELIMITER $$
USE `heroku_ddeb90f13531d40`$$
CREATE PROCEDURE `deleteallusuariosacta`(IN _actaid bigint(20))
BEGIN
	
		if exists(select * from acta where acta_id =  _actaid) then 
        
        	delete from usuario_acta where acta_acta_id = _actaid;
        end if;
        
END$$

DELIMITER ;