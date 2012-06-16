package javaConcepts.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Child extends Parent {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new Runnable() {

			@Override
			public void run() {
				try {
					Child.childFunction();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		executor.execute(new Runnable() {

			@Override
			public void run() {
				try {
					Child.function();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		executor.shutdown();
	}

	static synchronized void childFunction() throws InterruptedException {
		System.out.println("inside child function");
		Thread.sleep(5000);
		System.out.println("leaving child function");
	}
}
