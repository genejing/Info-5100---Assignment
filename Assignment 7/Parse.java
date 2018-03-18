package Assignment7;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Parse {
	public static void parse(File file) {
		RandomAccessFile input = null;
		String line = null;
		
		try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			return;
			
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件");
		} catch (IOException e) {
			System.out.println("读取文件异常");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println("关闭文件时发生异常");
				}
			}
		}
	}
}
