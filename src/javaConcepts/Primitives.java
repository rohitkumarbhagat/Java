package javaConcepts;

public class Primitives {
	public static void main(String[] args) {
		short abc = (short) 471142;
		System.out.println(abc);
		System.out.println(new Short(abc).byteValue());
		System.out.println((float) ('a'));
		Float fl = 100001111111.0f;
		Character a='a';
		System.out.println(Float.floatToIntBits(a));
	}
}
