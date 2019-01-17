package io.naztech.DatePrac;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConverterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void FromDateToLocaldateTest() throws ParseException {
		// Converter converter = new Converter();

		String string = "2019-01-16";
		Date dtDate = new SimpleDateFormat("yyyy-MM-dd").parse(string);
		LocalDate date = Converter.FromDateToLocaldate(dtDate);

		LocalDate datetime = LocalDate.parse(string, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		assertEquals(date, datetime);
	}

	@Test
	public void FromLocaldateToDateTest() throws ParseException {
		String string = "Wed Jan 16 00:00:00 BDT 2019";

		LocalDate localDate = LocalDate.parse(string, DateTimeFormatter.ofPattern("EE MMM dd hh:mm:ss z yyyy"));
		Date date = Converter.FromLocaldateToDate(localDate);

		Date dtDate = new SimpleDateFormat("EE MMM dd hh:mm:ss z yyyy").parse(string);
		assertEquals(date, dtDate);

	}
	
	@Test 
	public void FromDateToLocalTimeTest() throws ParseException {
		String datestring = "2011-02-18 05:00:00.0";
	    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//take a look at MM
	    Date date = dt.parse(datestring);
	    
	    LocalTime localTime = Converter.FromDateToLocalTime(date);
	    LocalTime testlTime = LocalTime.of(05, 00);
	    assertEquals(localTime, testlTime);
	}
	
	@Test 
	public void FromDateToLocalDateTimeTest() throws ParseException {
		String datestring = "2011-02-18 05:00:00.0";
	    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//take a look at MM
	    Date date = dt.parse(datestring);
	    
	    LocalDateTime localDateTime = Converter.FromDateToLocalDateTime(date);
	    LocalDateTime testldtTime = LocalDateTime.of(2011, Calendar.MARCH, 18, 05, 00);
	    assertEquals(localDateTime, testldtTime);
	}

	@Test
	public void FromCalenderDatetoLocalDateTimeTest() {
		Calendar cal = Calendar.getInstance();

		LocalDateTime d1 = LocalDateTime.now();

		assertEquals(d1.getHour(), Converter.FromCalendaeDatetoLocalDateTime(cal).getHour());
		assertEquals(d1.getMinute(), Converter.FromCalendaeDatetoLocalDateTime(cal).getMinute());
		assertEquals(d1.getYear(), Converter.FromCalendaeDatetoLocalDateTime(cal).getYear());
		assertEquals(d1.getMonth(), Converter.FromCalendaeDatetoLocalDateTime(cal).getMonth());
		assertEquals(d1.getDayOfMonth(), Converter.FromCalendaeDatetoLocalDateTime(cal).getDayOfMonth());
	}

	@Test
	public void FromDateToCalendarDateTest() throws ParseException {
		Date date = new Date();
		Calendar cal = Converter.fromDateToCalendarDate(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		sdf.format(cal.getTime());

		String stringDate = "2019 Jan 16 15:06:49";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		formatter.parse(stringDate);

		assertEquals(sdf, formatter);

	}

	@Test
	public void FromCalendarToDateTest() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		Date date = Converter.FromCalendarToDate(calendar);
		SimpleDateFormat sm = new SimpleDateFormat("EE MMM dd z yyyy");
		String strDate = sm.format(date);
		Date dt = sm.parse(strDate);

		String string = "Wed Jan 17 BDT 2019";
		Date dtDate = new SimpleDateFormat("EE MMM dd z yyyy").parse(string);

		assertEquals(dt, dtDate);

	}

	@Test
	public void FromCalendarToLocalDateTest() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 21);
		LocalDate ld = Converter.FromCalendarToLocalDate(cl);
		assertEquals(LocalDate.of(2019, Calendar.FEBRUARY, 21), ld);

	}

	@Test
	public void FromCalendarToLocalTimeTest() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 16, 16, 20);
		LocalTime lt = Converter.FromCalendarToLocalTime(cl);
		assertEquals(LocalTime.of(16, 20), lt);

	}

	@Test
	public void FromCalendarToLocalDateTimeTest() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 12, 10, 02, 10);
		LocalDateTime ldt = Converter.FromCalendarToLocalDateTime(cl);
		assertEquals(LocalDateTime.of(2019, Calendar.FEBRUARY, 12, 10, 02, 10), ldt);
	}

	@Test
	public void FromCalendarToTimezoneTest() {

		Calendar cl = Calendar.getInstance();
		// cl.setTimeZone(TimeZone.getTimeZone("UTC"));
		TimeZone tz = Converter.FromCalendarToTimezone(cl);
		assertEquals(tz, TimeZone.getTimeZone("Asia/Dhaka"));
	}
	
	@Test
	public void fromCalendarToZonedTimeTest() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 17, 14, 30);
		ZonedDateTime zdtDateTime = Converter.fromCalendarToZonedTime(cl);
		
		LocalDateTime ldt = LocalDateTime.of(2019, Calendar.FEBRUARY, 17, 14, 30);
		ZonedDateTime klDateTime = ldt.atZone(ZoneId.of("Asia/Tokyo"));
		assertEquals(zdtDateTime.getZone(), klDateTime.getZone());
	}

}
