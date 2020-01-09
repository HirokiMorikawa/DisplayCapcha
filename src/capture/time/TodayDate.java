package capture.time;

//import java.util.Set;

/**
 * 今日の日付を扱うクラス
 * 
 * @author morikawahiroki
 *
 */
public class TodayDate extends Today {

	/**
	 * 何年かを格納する
	 */
	private int year;
	/**
	 * 何月かを格納する
	 */
	private int month;
	/**
	 * 何日かを格納する
	 */
	private int day;

	/**
	 * デフォルトコンストラクタ.これを使えば自動的にTokyoのタイムゾーンで設定した現在の日時を参照できます.
	 */
	public TodayDate() {
		super();
		// 今何年かを格納する
		year = zonedDateTime.getYear();
		// 今何月かを格納する
		month = zonedDateTime.getMonth().getValue();
		// 今何日かを格納する
		day = zonedDateTime.getDayOfMonth();
		// todayTime = new TodayTime(zonedDateTime);
	}

	/**
	 * 与えられたタイムゾーンからそれが存在しているとき,それを基にして現在の日時を参照できるようにします. もしなければ,
	 * 自動的にTokyoのタイムゾーンで設定した現在の日時を参照できます.
	 * 
	 * @param timeZone
	 *            タイムゾーン
	 */
	public TodayDate(String timeZone) {
		super(timeZone);
		// 今何年かを格納する
		year = zonedDateTime.getYear();
		// 今何月かを格納する
		month = zonedDateTime.getMonth().getValue();
		// 今何日かを格納する
		day = zonedDateTime.getDayOfMonth();
	}

	/**
	 * TodayTimeオブジェクトを返します.これを用いてしかTodayTimeオブジェクトを生成できません
	 * 
	 * @return TodayTimeオブジェクト
	 */
	public TodayTime getTodayTime() {
		return TodayTime.getTodayTime();
	}

	/**
	 * 今現在の日付を表示します.
	 */
	public void viewNowDate() {
		System.out.printf(toString());
	}

	public String toString() {
		return String.format("%4s年%2d月%2d日\n", year, month, day);
	}

	/**
	 * @return 年を返します
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return 月を返します
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return 日を返します
	 */
	public int getDay() {
		return day;
	}
}
