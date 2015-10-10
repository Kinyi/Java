package com.adsage.dc.Java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用队列方法遍历文件夹
 * @author chenqinyi
 *
 */
public class Bianli {
	static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	static List<String> files = new ArrayList<String>();

	//D:\360wangpan
	public static void main(String[] args) {
		String pathname = "D:\\360wangpan";
		
		queue.add(pathname);
		while (!queue.isEmpty()) {
			String path = queue.poll();
			addFile(path);
		}
		for (String filename : files) {
			System.out.println(filename);
		}
	}
	
	public static void addFile(String filename){
		File file = new File(filename);
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				queue.add(file2.getPath());
			}
		}else {
			files.add(file.getName());
		}
	}
}