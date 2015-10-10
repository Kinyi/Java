package com.adsage.dc.Java;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Find {
	public static final long start = System.currentTimeMillis();
	public static Queue<File> queue = new LinkedList<File>();

	public static void main(String[] args) {
//		work(new File("D:\\360wangpan"));
//		new Thread(new MultiThread(new File("D:\\360wangpan"))).start();
		queuework(new File("D:\\360wangpan"));
	}

	//单线程使用递归遍历文件夹
	public static void work(File file) {
		if (file == null) {
			return;
		}

		if (file.isFile()) {
			System.out.println(file.getName() + "\t" + (System.currentTimeMillis() - start));
		}

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				work(new File(f.getPath()));
			}
		}
	}

	//单线程使用队列遍历文件夹
	public static void queuework(File file) {
		if (file == null) {
			return;
		}
		
		for (File f = file; f != null; f = queue.poll()) {
			if (f.isFile()) {
				System.out.println(f.getName() + "\t" + (System.currentTimeMillis() - start));
			}

			if (f.isDirectory()) {
				for (File ff : f.listFiles()) {
					queue.add(ff);
				}
			}
		}
	}
}

//多线程使用递归遍历文件夹
class MultiThread implements Runnable {
	public static final long start = System.currentTimeMillis();
	private File file;

	public MultiThread(File file) {
		super();
		this.file = file;
	}

	public static void work(File file) {
		if (file == null) {
			return;
		}

		if (file.isFile()) {
			System.out.println(Thread.currentThread().getName() + ":" + file.getName() + "\t" + (System.currentTimeMillis() - start));
		}

		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				new Thread(new MultiThread(new File(f.getPath()))).start();
			}
		}
	}

	public void run() {
		work(file);
	}
}