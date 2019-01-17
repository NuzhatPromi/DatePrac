package io.naztech.DatePrac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Converter {

	public static LocalDate FromDateToLocaldate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date FromLocaldateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalTime FromDateToLocalTime(Date date) {
	    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}
	
	public static LocalDateTime FromDateToLocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static LocalDateTime FromCalendaeDatetoLocalDateTime(Calendar cal) {
		TimeZone tz = cal.getTimeZone();
		ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		return LocalDateTime.ofInstant(cal.toInstant(), zid);
	}

	public static Calendar fromDateToCalendarDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	// calendar to date
	public static Date FromCalendarToDate(Calendar calendar) {
		return calendar.getTime();
	}

	// calendar to local date
	public static LocalDate FromCalendarToLocalDate(Calendar c) {
		LocalDate ld = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		return ld;

	}

	/// calendar to local time
	public static LocalTime FromCalendarToLocalTime(Calendar c) {
		LocalTime ld = LocalTime.of(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
		return ld;

	}

	/// calendar to local datetime
	public static LocalDateTime FromCalendarToLocalDateTime(Calendar c) {
		LocalDateTime ld = LocalDateTime.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),
				c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
		return ld;

	}

	// calendar to time zone
	public static TimeZone FromCalendarToTimezone(Calendar c) {
		TimeZone tZone = c.getTimeZone();
		return tZone;
	}

	public static ZonedDateTime fromCalendarToZonedTime(Calendar c) {
		ZoneId zoneid = ZoneId.of("Asia/Tokyo");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(FromCalendaeDatetoLocalDateTime(c), zoneid);
		return zonedDateTime;
	}

//	public static OffsetDateTime FromCalendarToOffsetDateTime(Calendar c) 
//	{
//		ZoneId zoneid = ZoneId.of("Asia/Tokyo");
//		OffsetDateTime offsetDateTime = OffsetDateTime.of
//		return offsetDateTime;
//	}

	public static void main(String[] args) throws ParseException {
		Calendar cl = Calendar.getInstance();
		System.out.println(cl.getTimeZone());
		
		String datestring = "2011-02-18 05:00:00.0";
	    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//take a look at MM
	    Date date = dt.parse(datestring );
		Instant instant = Instant.ofEpochMilli(date.getTime());
	    LocalTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
	    LocalDateTime rDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	    System.out.println(rDateTime);
	    LocalDateTime testldtTime = LocalDateTime.of(2011, Calendar.FEBRUARY, 18, 05, 00);
	    System.out.println(testldtTime);
	}
}
