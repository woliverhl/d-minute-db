package cl.usach.dminute.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utilitario {

	public static Date formatoFecha(String fechaStr) {

		log.info("[Utilitario][formatoFecha][INI][fecha en formato yyyyMMdd"
				+ fechaStr + "]");

		if (fechaStr != null) {
			
			try {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
				Date date = formatoDelTexto.parse(fechaStr);
			    log.info("[Utilitario][formatoFecha][fecha:]" + date);
			   return date;
			} catch (ParseException e) {
				log.error(
						"[Utilitario][formatoFecha][FINEX][Error al calular fecha]");
			}
		}
		return null;
	}
	
	public static String formatoFecha(Date fechaStr) {

		log.info("[Utilitario][formatoFecha][INI][fecha en formato yyyyMMdd"
				+ fechaStr + "]");

		if (fechaStr != null) {
			
			try {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
				String date = formatoDelTexto.format(fechaStr);
			    log.info("[Utilitario][formatoFecha][fecha:]" + date);
			   return date;
			} catch (Exception e) {
				log.error(
						"[Utilitario][formatoFecha][FINEX][Error al calular fecha]");
			}
		}
		return null;
	}
	
	public static Date formatoFechaHora(String fechaStr) {

		log.info("[Utilitario][formatoFecha][INI][fecha en formato yyyyMMdd"
				+ fechaStr + "]");

		if (fechaStr != null) {
			
			try {
				SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH);
				Date date = formatoDelTexto.parse(fechaStr);
			    log.info("[Utilitario][formatoFecha][fecha:]" + date);
			   return date;
			} catch (ParseException e) {
				log.error(
						"[Utilitario][formatoFecha][FINEX][Error al calular fecha]");
			}
		}
		return null;
	}
}
