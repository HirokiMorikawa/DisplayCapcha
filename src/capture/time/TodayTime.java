package capture.time;

import java.time.ZonedDateTime;

/**
 * 今の時間を扱うクラス
 * 
 * @author morikawahiroki
 *
 */
public class TodayTime extends Today {
	
	/**
	 * 初回起動時の何時かを格納する
	 */
	/**
	 * 初回起動時の何分かを格納する
	 */
	/**
	 * 初回起動時の何秒かを格納する
	 */
	/**
	 * 初回起動時の何ナノ秒かを格納する
	 */
	/**
	 * 何時かを格納する
	 */
	private int hour;
	/**
	 * 何分かを格納する
	 */
	private int minute;
	/**
	 * 何秒かを格納する
	 */
	private int second;
	/**
	 * 何ナノ秒かを格納する
	 */
	private int nanosecond;

	/**
	 * デフォルトコンストラクタ.これを使えば自動的にTokyoのタイムゾーンで設定した現在の時刻を参照できます.
	 */
	private TodayTime() {
		super();
		this.hour = zonedDateTime.getHour();
		this.minute = zonedDateTime.getMinute();
		this.second = zonedDateTime.getSecond();
		this.nanosecond = zonedDateTime.getNano();
	}

	/**
	 * 与えられたタイムゾーンからそれが存在しているとき,それを基にして現在の時刻を参照できるようにします. もしなければ,
	 * 自動的にTokyoのタイムゾーンで設定した現在の時刻を参照できます.
	 * 
	 * @param timeZone
	 *            タイムゾーン
	 */
	private TodayTime(String timeZone) {
		super(timeZone);
		this.hour = zonedDateTime.getHour();
		this.minute = zonedDateTime.getMinute();
		this.second = zonedDateTime.getSecond();
		this.nanosecond = zonedDateTime.getNano();
	}

	static TodayTime getTodayTime() {
		return new TodayTime();
	}

	static TodayTime getTodayTime(String timeZone) {
		return new TodayTime(timeZone);
	}

	/**
	 * 時間を取得します 更新された時間を欲しいときは, setTimeOfNowメソッドを使ってください.
	 * 
	 * @return オブジェクト生成時の時間を返します.今の情報が欲しいときはsetTimeOfNowメソッドを使ってください.
	 */
	public int getHour() {
		//setTimeOfNow();
		return hour;
	}

	/**
	 * 分を取得します 更新された分を欲しいときは, setTimeOfNowメソッドを使ってください.
	 * 
	 * @return　オブジェクト生成時の分を返します.今の情報が欲しいときはsetTimeOfNowメソッドを使ってください.
	 */
	public int getMinute() {
		//setTimeOfNow();
		return minute;
	}

	/**
	 * 秒を取得します 更新された秒を欲しいときは, setTimeOfNowメソッドを使ってください.
	 * 
	 * @return オブジェクト生成時の秒を返します.今の情報が欲しいときはsetTimeOfNowメソッドを使ってください.
	 */
	public int getSecond() {
		//setTimeOfNow();
		return second;
	}

	/**
	 * ナノ秒を取得します 更新されたナノ秒を欲しいときは, setTimeOfNowメソッドを使ってください.
	 * 
	 * @return オブジェクト生成時のナノ秒を返します.今の情報が欲しいときはsetTimeOfNowメソッドを使ってください.
	 */
	public int getNanosecond() {
		//setTimeOfNow();
		return nanosecond;
	}

	public String toString() {
		return String.format("%2d:%2d:%2d:%d\n", getHour(), getMinute(),
				getSecond(), getNanosecond());
	}

	/**
	 * 時間を表示します.更新された時間を表示するときは, setTimeOfNowメソッドを使ってからにしてください.
	 */
	public void viewNowTime() {
		System.out.printf(toString());
	}

	/**
	 * 新しい時間をセットします
	 */
	public void setTimeOfNow() {
		zonedDateTime = ZonedDateTime.now(currentTimeZone);
		this.hour = zonedDateTime.getHour();
		this.minute = zonedDateTime.getMinute();
		this.second = zonedDateTime.getSecond();
		this.nanosecond = zonedDateTime.getNano();
	}
}
