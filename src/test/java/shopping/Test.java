package shopping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		Map map = new Hashtable();
		map.put(null, 1);
		map.put("name", "xingming");
		
		System.out.println("name-------------"+map.get("name"));*/
		//listTest();
		//setTest();
		System.out.println(System.currentTimeMillis());
	}
	
	public static void setTest() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(3);
		set.add(3);
		set.add(2);
		set.add(1);
		set.add(5);
		Iterator<Integer> i = set.iterator();
		while(i.hasNext()) {
			Integer num = i.next();
			System.out.println(num);
			
		}
	}
	
	
	public static void listTest() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(2);
		Iterator<Integer> i = list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
}
