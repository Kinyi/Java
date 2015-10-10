package com.adsage.dc.Java;

import java.io.File;

/**
 * 递归方法遍历文件夹
 * @author chenqinyi
 *
 */
public class Bianli2 {

	public static void main(String[] args) {
		String pathname = "D:\\360wangpan";
		outputFilename(pathname);
	}
	
	public static void outputFilename(String pathname){
		File file = new File(pathname);
		if (file.isFile()) {
			System.out.println(file.getPath());
		}else {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				outputFilename(file2.getPath());
			}
		}
	}
}