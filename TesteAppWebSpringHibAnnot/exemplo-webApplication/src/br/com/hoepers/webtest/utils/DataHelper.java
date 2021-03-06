/*
 * Created on Mar 22, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.hoepers.webtest.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.util.StringUtils;

import br.com.hoepers.webtest.exceptions.WebTestException;

/**
 * @author Felipe Santos
 */
public class DataHelper {
	/**
	 * Incrementa a em dias data passada por parametro.
	 * 
	 * @param dtAtual
	 * @param dias
	 * @return Data
	 */
	public static Date dataAtual() {
		Calendar dt = new GregorianCalendar();
		return dt.getTime();
	}

	public static Date incDay(Date dtAtual, int dias) {
		Calendar dt = new GregorianCalendar();
		// ***
		dt.setTime(dtAtual);
		dt.add(Calendar.DAY_OF_WEEK, dias);
		return dt.getTime();
	}

	/**
	 * Incrementa a em dias data passada por parametro.
	 * 
	 * @param dtAtual
	 * @param dias
	 * @return Data
	 */
	public static Date incMonth(Date dtAtual, int month) {
		Calendar dt = new GregorianCalendar();
		// ***
		dt.setTime(dtAtual);
		dt.add(Calendar.MONTH, month);
		return dt.getTime();
	}

	public static Date decData(Date dtAtual, int dias) {
		Calendar dt = new GregorianCalendar();
		// ***
		dt.setTime(dtAtual);
		dt.add(Calendar.DAY_OF_WEEK, -dias);
		return dt.getTime();
	}

	public static Date stringToDate(String string, int tipo)
			throws ParseException {
		SimpleDateFormat DTFORMAT = new SimpleDateFormat("yyyy-MM-dd");

		SimpleDateFormat DTFORMAT3 = new SimpleDateFormat(
				"EEE MMM dd hh:mm:ss z yyyy", Locale.US);
		System.out.println("String do StringToDate: " + string);
		if (tipo == 1) {
			String[] tokens = StringUtils.split(string, "\\-");
			if (tokens.length > 1) {
				// Formato yyyy-MM-dd hh:mm:ss.s
				Date data = DTFORMAT.parse(string);
				String arg = DTFORMAT.format(data);
				String[] sSplit = StringUtils.split(arg, "\\-");
				Integer ano = new Integer(sSplit[0]);
				Integer mes = new Integer(sSplit[1]);
				Integer dia = new Integer(sSplit[2]);
				Calendar cal = new GregorianCalendar();
				cal.set(Calendar.DAY_OF_MONTH, dia.intValue());
				cal.set(Calendar.MONTH, mes.intValue() - 1);
				cal.set(Calendar.YEAR, ano.intValue());
				return cal.getTime();
			} else {
				// Formato Thu Nov 11 15:45:56 BRST 2004
				return DTFORMAT3.parse(string);
			}
		}
		return null;
	}

	/**
	 * dd/mm/yyyy
	 */
	public static Date stringToDate(String string) {
		if (!"".equals(string) && string.length() == 10) {
			String[] sSplit = StringUtils.split(string, "\\/-");
			Integer dia = new Integer(sSplit[0]);
			Integer mes = new Integer(sSplit[1]);
			Integer ano = new Integer(sSplit[2]);
			// ***
			Calendar cal = new GregorianCalendar();
			cal.set(Calendar.DAY_OF_MONTH, dia.intValue());
			cal.set(Calendar.MONTH, mes.intValue() - 1);
			cal.set(Calendar.YEAR, ano.intValue());
			return cal.getTime();
		} else
			return new Date();
	}

	/**
	 * dd/mm/yyyy hh:mm:ss
	 * @throws Exception 
	 */
	public static Date stringToDateTime(String string) {
		if (!"".equals(string)) {
			String[] sSplit = string.split("\\/");
			Integer dia = new Integer(sSplit[0]);
			Integer mes = new Integer(sSplit[1]);
			Integer ano = new Integer(sSplit[2].substring(0, 4));

			String hr        = sSplit[2];
			hr               = hr.substring(5);
			String[] hrSplit = hr.split(":");
			Integer hora     = new Integer(hrSplit[0]);
			Integer min      = new Integer(hrSplit[1]);
			Integer sec      = new Integer(hrSplit[2]);
			
			if ( hora.intValue() > 24 ) {
					throw new WebTestException("Aten��o, hora inv�lida.");
			}		
			
			if ( min.intValue() > 59 ) {
				throw new WebTestException("Aten��o, minuto inv�lida.");
			}	
			
			
			// ***
			Calendar cal = new GregorianCalendar();
			cal.set(Calendar.DAY_OF_MONTH, dia.intValue());
			cal.set(Calendar.MONTH, mes.intValue() - 1);
			cal.set(Calendar.YEAR, ano.intValue());
			cal.set(Calendar.HOUR_OF_DAY, hora.intValue());
			cal.set(Calendar.MINUTE, min.intValue());
			cal.set(Calendar.SECOND, sec.intValue());
			return cal.getTime();
		} else
			return null;
	}

	/**
	 * hh:mm:ss
	 */
	public static Date stringToTime(String string) {
		if (!"".equals(string)) {
			String[] hrSplit = StringUtils.split(string, "\\:");
			Integer hora = new Integer(hrSplit[0]);
			Integer min = new Integer(hrSplit[1]);
			Integer sec = new Integer(hrSplit[2]);
			// ***
			Calendar cal = new GregorianCalendar();
			cal.set(Calendar.DAY_OF_MONTH, 0);
			cal.set(Calendar.MONTH, 0);
			cal.set(Calendar.YEAR, 0000);
			cal.set(Calendar.HOUR_OF_DAY, hora.intValue());
			cal.set(Calendar.MINUTE, min.intValue());
			cal.set(Calendar.SECOND, sec.intValue());
			return cal.getTime();
		} else
			return null;
	}

	public static Calendar createDate(Date data) {
		Calendar dt = new GregorianCalendar();
		dt.setTime(data);
		return dt;
	}

	public static Date createDate(int day, int month, int year) {
		Calendar saida = new GregorianCalendar();
		// ***
		saida.set(Calendar.DAY_OF_MONTH, day);
		saida.set(Calendar.MONTH, month - 1);
		saida.set(Calendar.YEAR, year);
		return saida.getTime();
	}

	public static String somaHoraMinSec(String hora1, String hora2) {
		SimpleDateFormat fmt = new SimpleDateFormat("KK:mm:ss");
		String mask = "\\:";
		String[] h1 = StringUtils.split(hora1, mask);
		String[] h2 = StringUtils.split(hora2, mask);
		// Seta a hora1
		Calendar dt1 = new GregorianCalendar();
		dt1.set(Calendar.HOUR_OF_DAY, new Integer(h1[0]).intValue());
		dt1.set(Calendar.MINUTE, new Integer(h1[1]).intValue());
		dt1.set(Calendar.SECOND, new Integer(h1[2]).intValue());
		// Seta hora2
		Calendar dt2 = new GregorianCalendar();
		dt2.set(Calendar.HOUR_OF_DAY, new Integer(h2[0]).intValue());
		dt2.set(Calendar.MINUTE, new Integer(h2[1]).intValue());
		dt2.set(Calendar.SECOND, new Integer(h2[2]).intValue());
		// Hora 1 + Hora 2.
		dt1.add(Calendar.HOUR_OF_DAY, dt2.get(Calendar.HOUR_OF_DAY));
		dt1.add(Calendar.MINUTE, dt2.get(Calendar.MINUTE));
		dt1.add(Calendar.SECOND, dt2.get(Calendar.SECOND));
		return fmt.format(dt1.getTime());
	}

	public static Date createDate(int day, int month, int year, int hour,
			int minute, int second) {
		Calendar saida = new GregorianCalendar();
		// ***
		saida.set(Calendar.DAY_OF_MONTH, day);
		saida.set(Calendar.MONTH, month - 1);
		saida.set(Calendar.YEAR, year);
		saida.set(Calendar.HOUR, hour);
		saida.set(Calendar.MINUTE, minute);
		saida.set(Calendar.SECOND, second);
		saida.set(Calendar.AM_PM, 0);
		return saida.getTime();
	}

	public static Date calculaMediaDeData(Date data, Integer divisor) {
		Calendar hr = new GregorianCalendar();
		hr.setTime(data);
		// ***
		// Transforma tudo em segundos.
		long dif = hr.get(Calendar.HOUR_OF_DAY) * 60 * 60; // Hora p/ segundos
		dif = dif + hr.get(Calendar.MINUTE) * 60; // Minutos p/ segundos
		dif = dif + hr.get(Calendar.SECOND);
		long diferenca = dif;
		diferenca /= divisor.intValue();
		// ***
		long horas = (diferenca / 3600);
		long segundos = ((diferenca) % 60);
		long minutos = ((diferenca - segundos) / 60) % 60;
		hr.set(Calendar.HOUR_OF_DAY, (int) horas);
		hr.set(Calendar.MINUTE, (int) minutos);
		hr.set(Calendar.SECOND, (int) segundos);
		// ***
		return hr.getTime();
	}

	public static long daysBetween(Date date1, Date date2) {
		Calendar c1 = new GregorianCalendar();
		Calendar c2 = new GregorianCalendar();
		c1.setTime(date1);
		c2.setTime(date2);
		return dif(c1.getTime(), c2.getTime());
	}

	static final long ONE_HOUR = 60 * 60 * 1000L;

	private static long dif(Date d1, Date d2) {
		return ((d2.getTime() - d1.getTime() + ONE_HOUR) / (ONE_HOUR * 24));
	}

	/**
	 * Retorna a diferenca entre duas horas
	 * 
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static Date diffHour(Date horaFinal, Date horaInicial) {
		long diferenca = (horaFinal.getTime() - horaInicial.getTime()) / 1000;

		long horas = (diferenca / 3600);
		long segundos = ((diferenca) % 60);
		long minutos = ((diferenca - segundos) / 60) % 60;

		// **
		Calendar hr = new GregorianCalendar();
		hr.set(Calendar.HOUR_OF_DAY, (int) horas);
		hr.set(Calendar.MINUTE, (int) minutos);
		hr.set(Calendar.SECOND, (int) segundos);
		return hr.getTime();

	}
	
	public static String dateTimeToString(Date date, String pattern){
		if ( date != null ) {
			SimpleDateFormat s = new SimpleDateFormat(pattern);
			return s.format( date );
		} else {
			return null;
		}
	}	

	/**
	 * CRIEI ESTE CONVERSOR PORQUE NAO ESTAVA VOLTANDO OS SEGUNDOS.<br>
	 * C�ssio Dias [27.07.06]
	 */
	public static java.util.Date sqlDateToUtilDate(ResultSet rs, String columnName){
		Calendar c = new GregorianCalendar();
		Date dtSql = null;
		try {
			dtSql = rs.getDate(columnName, c);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if ( dtSql != null ) {		
			java.util.Date dtx = c.getTime(); 
			return dtx;
		} else
			return null;
	}
}
