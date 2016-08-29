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
			return String.valueOf(t) + "��ǰ";
		else if((t = time / (30 * 24*3600)) > 0)
			return String.valueOf(t) + "����ǰ";
		else if((t = time / (7 * 24*3600)) > 0)
			return String.valueOf(t) + "��ǰ";
		else if((t = time / (24*3600)) > 0)
			return String.valueOf(t) + "��ǰ";
		else if((t = time / (3600)) > 0)
			return String.valueOf(t) + "Сʱǰ";
		else if((t = time / (60)) > 0)
			return String.valueOf(t) + "����ǰ";
		else
			return String.valueOf(time) + "����ǰ";
	}
}
