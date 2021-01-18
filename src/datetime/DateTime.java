package datetime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateTime {

	public static void main(String[] args) {
		System.out.println("java < 8");
		(new PreJava8()).getTodaysTimestamp();
		System.out.println("\njava >= 8");
		(new Java8()).getTodaysTimestamp();
	}

	public interface DateTimeFunctions {

		long getTodaysTimestamp();
	}

	// java < 8
	public static class PreJava8 implements DateTimeFunctions {

		@Override
		public long getTodaysTimestamp() {
			// now
			DateFormat formatShort = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat formatLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar now = Calendar.getInstance();
			System.out.println(formatShort.format(now.getTime()));
			System.out.println(formatLong.format(now.getTime()));
			System.out.println(now.getTimeInMillis());
			
			// today
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			now.set(Calendar.MILLISECOND, 0);
			long timestamp = now.getTimeInMillis();
			System.out.println(timestamp);
			return timestamp;
		}

	}

	// java >= 8
	public static class Java8 implements DateTimeFunctions {
		
		@Override
		public long getTodaysTimestamp() {
			// now
			DateTimeFormatter formatShort = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter formatLong = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println(formatShort.format(now));
			System.out.println(formatLong.format(now));
			System.out.println(Timestamp.valueOf(now).getTime());
			
			// today
			LocalDate today = now.toLocalDate();
			long timestamp = Timestamp.valueOf(today.atStartOfDay()).getTime();
			System.out.println(timestamp);
			return timestamp;
		}
	}
}
