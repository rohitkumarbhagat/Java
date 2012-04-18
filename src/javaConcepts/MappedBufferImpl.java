package javaConcepts;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MappedBufferImpl {
	static void mapped() {
		FileChannel fc;
		try {
			StringBuilder strBuilder = new StringBuilder();
			BlockingQueue<StringBuilder> lqueue = new LinkedBlockingQueue<StringBuilder>();
			fc = (new FileInputStream("/Users/rohitkumar/Downloads/book.txt"))
					.getChannel();
			ByteBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
//			 ByteBuffer ib = ByteBuffer.allocate((int)fc.size());
//			 fc.read(ib);
//			 //ib.position(0);
//			 ib.flip();
			// MappedByteBuffer mbb = fc.map(MapMode.READ_ONLY, 0, fc.size());
			// CharBuffer cb = decoder.decode(ib);

			// String encoding = System.getProperty("file.encoding");
			//
			// CharBuffer chrbfr = Charset.forName(encoding).decode(ib);
			// CharBuffer chrbfr=ib.asCharBuffer();
			// System.out.println(str.substring(0,19));
			// String[] lines=str.split("\n");
			// //System.out.println(lines.length);
			char abc;
			
			
			
			
			while (ib.hasRemaining()) {
				abc = (char) ib.get();
				
				if (abc == '\n' || abc == '\r') {
					// if (strBuilder.length() > 0) {
					// lqueue.add(strBuilder);
					// strBuilder = new StringBuilder();
					// }
				} else {
					// strBuilder.append(abc);
				}

			}
			System.out.println(lqueue.size());

			fc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void stream() {
		 String line;
		 BlockingQueue<String> lqueue = new LinkedBlockingQueue<String>();
		 BufferedReader reader = null;
		 try {
		 StringBuilder strBuilder = new StringBuilder();
		 reader = new BufferedReader(new InputStreamReader(
		 new FileInputStream("/Users/rohitkumar/Downloads/book.txt")));
		
		 while ((line = reader.readLine()) != null) {
		 //lqueue.add(line);
		// strBuilder.append(line);
		 }
		
		 reader.close();
		 System.out.println(lqueue.size());
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

		
//		try {
//			DataInputStream dis;
//			dis = new DataInputStream(new BufferedInputStream(
//					new FileInputStream("/Users/rohitkumar/Downloads/book.txt")));
//
//			for (int i = 0; i < dis.available(); i++)
//				dis.readChar();
//			dis.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
		long currentime = System.currentTimeMillis();
		mapped();
		System.out.println("mapped time = "
				+ (System.currentTimeMillis() - currentime));
		currentime = System.currentTimeMillis();
		stream();
		System.out.println("strreeam time = "
				+ (System.currentTimeMillis() - currentime));

	}
}
