package io.naztech.DatePrac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
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

	// calendar to date
	public static Date FromCalendarToDate(Calendar calendar) {
		return calendar.getTime();
	}

	// calendar to local date
	public static LocalDate FromCalendarToLocalDate(Calendar c) {
		return LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));

	}

	/// calendar to local time
	public static LocalTime FromCalendarToLocalTime(Calendar c) {
		return LocalTime.of(c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));

	}

	/// calendar to local datetime
	public static LocalDateTime FromCalendarToLocalDateTime(Calendar c) {
		return LocalDateTime.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),
				c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));

	}

	// calendar to time zone
	public static TimeZone FromCalendarToTimezone(Calendar c) {
		return c.getTimeZone();
	}

	public static ZonedDateTime fromCalendarToZonedTime(Calendar c) {
		return ZonedDateTime.of(FromCalendaeDatetoLocalDateTime(c), ZoneId.of("Asia/Tokyo"));
	}

	public static OffsetDateTime FromCalendarToOffsetDateTime(Calendar c) {
		return OffsetDateTime.of(FromCalendaeDatetoLocalDateTime(c), ZoneOffset.of("+02:00"));
	}

	public static OffsetDateTime fromLocaldateToOffset(LocalDate localDate)
	{
		 return OffsetDateTime.of(LocalDate.now(),LocalTime.now(), ZoneOffset.of("+02:00"));
	}

}
