package javaConcepts;

import java.net.URI;
import java.net.URL;

public class LoopTimeTaken {
	public static void main(String[] args) {
		
		//URL url=new URL(protocol, host, port, file) 
		
		
		
		long curentTime = System.currentTimeMillis();
		for (long i = 0; i < 10000000000l; i++) {

		}
		System.out.println("Time taken ="
				+ (System.currentTimeMillis() - curentTime));
	}
}
