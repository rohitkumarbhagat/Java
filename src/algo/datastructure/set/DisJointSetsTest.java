package algo.datastructure.set;

public class DisJointSetsTest {
	public static void main(String[] args) {
		DisJointSets<String> stringSets = new DisJointSets<String>(10);
		stringSets.makeSet("rohit");
		stringSets.makeSet("abc");
		stringSets.makeSet("xyz");
		stringSets.makeSet("plkmn");
		stringSets.makeSet("del");
		stringSets.makeSet("bangi");
		stringSets.makeSet("bangi");
		stringSets.makeSet("bgp");
		stringSets.makeSet("hwh");
		stringSets.makeSet("kgp");
		System.out.println(stringSets);
		
		System.out.println(stringSets.findSet("bangi"));
		System.out.println(stringSets.findSet("rohit"));
		
		
		System.out.println(stringSets.union("rohit", "bangi"));
		System.out.println(stringSets.union("rohit", "abc"));
		System.out.println(stringSets.union("bangi", "plkmn"));
		System.out.println(stringSets.union("xyz", "del"));
		System.out.println(stringSets.union("xyz", "del"));
		System.out.println(stringSets.union("del", "kgp"));
		System.out.println(stringSets.union("xyz", "bgp"));
		System.out.println(stringSets.union("bgp", "bgp"));
		System.out.println(stringSets.union("bgp", "abc"));
		
		stringSets.findSet("kgp");
		//stringSets.findSet("bgp");
		System.out.println(stringSets);
		
		
	}
}
