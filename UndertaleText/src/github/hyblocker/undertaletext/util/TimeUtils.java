package github.hyblocker.undertaletext.util;

public class TimeUtils {

	public static float MillisToSeconds(long millis) {
		return (float) millis / 1000f;
	}

	public static float SecondsToMinutes(long secs) {
		return (float) secs / 60f;
	}

	public static float MillisToMinutes(long millis) {
		return (float) (millis / 1000f) / 60f;
	}

	public static float MillisToHours(long millis) {
		return (float) ((millis / 1000f) / 60f) / 60f;
	}

	public static String MillisToString(long millis, TimeFormat format) {
		if (format == TimeFormat.Minutes) {
			return MillisToMinutes(millis) + ":" + MillisToSeconds(millis);
		} else if (format == TimeFormat.Seconds) {
			return MillisToSeconds(millis) + "";
		} else if (format == TimeFormat.Hours) {
			return MillisToHours(millis) + ":" + MillisToMinutes(millis) + ":" + MillisToSeconds(millis);
		}
		return millis + "";
	}
}
