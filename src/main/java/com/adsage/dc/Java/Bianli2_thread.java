package com.adsage.dc.Java;

import java.io.File;

/**
 * 递归方法遍历文件夹
 * 
 * @author chenqinyi
 *
 */
public class Bianli2_thread implements Runnable {

	public static void main(String[] args) {
		Bianli2_thread runnable = new Bianli2_thread();
		new Thread(runnable,"线程1").start();
		new Thread(runnable,"线程2").start();
	}

	public static void outputFilename(String pathname) {
		File file = new File(pathname);
		if (file.isFile()) {
			System.out.println(Thread.currentThread().getName() + ":" + file.getPath());
		} else {
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				outputFilename(file2.getPath());
			}
		}
	}

	public void run() {
		String pathname = "D:\\360wangpan";
		outputFilename(pathname);
	}
}