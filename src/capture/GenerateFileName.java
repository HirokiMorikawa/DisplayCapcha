package capture;

import capture.time.Today;
import capture.time.TodayDate;
import capture.time.TodayTime;

/**
 * @author morikawahiroki
 * @version 2017/02/08
 */
public class GenerateFileName {
	public String getFileName(String fileType) {
		TodayDate date = new TodayDate();
		TodayTime time = date.getTodayTime();
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		return String.format("%d%d%d%d%d%d.%s", year, month, day, hour, minute,
				second, fileType);
	}
}
