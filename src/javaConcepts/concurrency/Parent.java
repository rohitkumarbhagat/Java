package javaConcepts.concurrency;

public class Parent {
	static synchronized void function() throws InterruptedException {
		System.out.println("inside Parent function");
		Thread.sleep(5000);
		System.out.println("leaving Parent function");
	}
}
