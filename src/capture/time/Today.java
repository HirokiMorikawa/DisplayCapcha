package capture.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Today {
	/**
	 * 
	 */
	protected static final String DefaultZoneID = "Japan";
	/**
	 * デフォルトのタイムゾーン(日本)
	 */
	protected static final ZoneId DefaultTIMEZONE = ZoneId.of("Japan");
	/**
	 * 使えるタイムゾーンを格納
	 */
	protected final String[] someOfZoneID = (ZoneId.getAvailableZoneIds())
			.toArray(new String[0]);
	/**
	 * 現在設定されているタイムゾーンの情報
	 */
	protected ZoneId currentTimeZone;
	/**
	 * これを使って,日時,日付を取得する
	 */
	protected ZonedDateTime zonedDateTime;
	/**
	 * 
	 */
	protected String zoneID;
	private boolean flg = false;

	/**
	 * デフォルトコンストラクタ.これを使えば自動的にTokyoのタイムゾーンで設定した現在の日時を参照できます.
	 */
	public Today() {
		zonedDateTime = ZonedDateTime.now(DefaultTIMEZONE);
		currentTimeZone = DefaultTIMEZONE;
		zoneID = DefaultZoneID;
	}

	/**
	 * 与えられたタイムゾーンからそれが存在しているとき,それを基にして現在の日時を参照できるようにします. もしなければ,
	 * 自動的にTokyoのタイムゾーンで設定した現在の日時を参照できます.
	 * 
	 * @param timeZone
	 *            タイムゾーン
	 */
	public Today(String timeZone) {
		for (String zoneID : someOfZoneID) {
			if (timeZone.equals(zoneID)) {
				this.zoneID = timeZone;
				currentTimeZone = ZoneId.of(timeZone);
				zonedDateTime = ZonedDateTime.now(currentTimeZone);
				flg = true;
				break;
			}
		}
		if (!flg) {
			zonedDateTime = ZonedDateTime.now(DefaultTIMEZONE);
			currentTimeZone = DefaultTIMEZONE;
			zoneID = DefaultZoneID;
		}

	}

	public String getZoneID() {
		return zoneID;
	}
}
