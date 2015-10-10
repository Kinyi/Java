package com.adsage.dc.Java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Bianli_thread implements Runnable {
	static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	static List<String> files = new ArrayList<String>();

	// D:\360wangpan
	public static void main(String[] args) {
		String pathname = "D:\\360wangpan";
		queue.add(pathname);
		Bianli_thread ob1 = new Bianli_thread();
		new Thread(ob1,"线程1").start();
		new Thread(ob1,"线程2").start();
	}

	public static void addFile(String filename) {
		File file = new File(filename);
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				queue.add(file2.getPath());
			}
		} else {
			files.add(file.getName());
		}
	}

	public void run() {
		while (!queue.isEmpty()) {
			String path = queue.poll();
			addFile(path);
		}
		for (String filename : files) {
			System.out.println(Thread.currentThread().getName()+":"+filename);
		}
	}
}