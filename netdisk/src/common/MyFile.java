package common;

import java.io.File;

public class MyFile
{
	//删除指定目录中的所有子目录和文件
	public static void deleteAny(String path)
	{
		File file = new File(path);
		if (file.exists())
		{
			//如果path表示的是目录，则继续扫描该目录中的子目录和文件
			if (file.isDirectory())
			{
				File[] files = file.listFiles();
				for (File myFile : files)
				{
					//发现一个子目录，递归调用deleteAny方法
					if (myFile.isDirectory()){
						deleteAny(myFile.getPath());
					}
					else{//发现一个文件，直接删除
						myFile.delete();
					}
				}
			}
			//直接删除path参数指定的文件
			file.delete();
		}
	}
}
