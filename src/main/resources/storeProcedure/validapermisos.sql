USE `heroku_ddeb90f13531d40`;
DROP procedure IF EXISTS `validapermisos`;

DELIMITER $$
USE `heroku_ddeb90f13531d40`$$
CREATE PROCEDURE `validapermisos`(IN _id bigint(20),IN _usuario varchar(255),IN _tipo varchar(3))
BEGIN

	if (_tipo = 'PRY') then
		if exists(select * from proyecto where proyecto_id =  _id and estado = 'A' and usuario_username = _usuario) then 
			select '1';
	    else
			select '0';
        end if;
    elseif (_tipo = 'ACT') then
		if exists(select * from acta where  acta_id =  _id and estado = 'A' and usuario_username = _usuario) then 
				select '1';
		else
			if exists(select acta_id from proyecto inner join acta on proyecto.proyecto_id = acta.proyecto_proyecto_id  
								where acta_id =  _id and acta.estado = 'A' and proyecto.usuario_username = _usuario) then 
				select '1';
			else
				select '0';
			end if;
        end if;      
	else
			select '0';
    end if;

END$$

DELIMITER ;
