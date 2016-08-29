package common;

public class MyFormat
{
    public static String formatDate(java.util.Date date)
    {
    	String result = "";
    	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
    	result = dateFormat.format(date);
    	return result;
    }
	public static String getTimeInterval(long time)
	{
		time = time / 1000;
		long t = 0;
		if((t = time / (365*24*3600)) > 0)
			return String.valueOf(t) + "年前";
		else if((t = time / (30 * 24*3600)) > 0)
			return String.valueOf(t) + "个月前";
		else if((t = time / (7 * 24*3600)) > 0)
			return String.valueOf(t) + "周前";
		else if((t = time / (24*3600)) > 0)
			return String.valueOf(t) + "天前";
		else if((t = time / (3600)) > 0)
			return String.valueOf(t) + "小时前";
		else if((t = time / (60)) > 0)
			return String.valueOf(t) + "分钟前";
		else
			return String.valueOf(time) + "秒钟前";
	}
}
