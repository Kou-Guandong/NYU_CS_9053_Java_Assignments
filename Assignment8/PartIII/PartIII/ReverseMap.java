package PartIII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReverseMap {

	public static Map<Object, Set<Object>> getInverted(Map<Object, Object> mp) {
		Map<Object, Set<Object>> result = new HashMap<Object, Set<Object>>();
		for (Map.Entry<Object, Object> entry : mp.entrySet()) {
			Object key = entry.getKey();
			Object value = entry.getValue();
			if (!result.containsKey(value)) {
				result.put(value, new HashSet<Object>());
			}
			result.get(value).add(key);
		}
		return result;
	}

	public static void main(String[] args) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("Key1", new Integer(2));
		m.put("Key2", new Integer(5));
		m.put("Key4", new Integer(2));
		m.put("Key5", new Integer(8));
		m.put("Key6", new Integer(18));
		m.put("Key7", new Integer(24));
		System.out.println("hashmap is " + m);

		System.out.println("inverted: " + ReverseMap.getInverted(m));

	}

}
