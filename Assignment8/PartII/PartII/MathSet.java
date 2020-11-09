package PartII;

import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2) {
		MathSet<E> result = new MathSet<E>();
		for (E item : s2) {
			if (this.contains(item)) {
				result.add(item);
			}
		}
		return result;
	}

	public Set<E> union(Set<E> s2) {
		MathSet<E> result = new MathSet<E>();
		for (E item : this) {
			result.add(item);
		}
		for (E item : s2) {
			result.add(item);
		}
		return result;

	}

	public <T> Set<Pair<E, T>> cartesianProduct(Set<T> s2) {
		Set<Pair<E, T>> result = new MathSet<Pair<E, T>>();
		this.forEach(item1 -> {
			s2.forEach(item2 -> {
				// System.out.println(new Pair<E, T>(item1, item2));
				result.add(new Pair<E, T>(item1, item2));
			});
		});
		return result;
	}

	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		MathSet<Integer> s1 = new MathSet<Integer>();
		s1.add(2);
		s1.add(3);
		s1.add(5);

		MathSet<Integer> s2 = new MathSet<Integer>();
		s2.add(2);
		s2.add(4);
		s2.add(5);
		s2.add(7);

		System.out.println(s1.intersection(s2));
		System.out.println(s1.union(s2));

		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<String> s3 = new MathSet<String>();
		s3.add("a");
		s3.add("ok");
		s3.add("xyz");

		MathSet<Pair<Integer, String>> s4 = new MathSet<Pair<Integer, String>>();
		s4.add(new Pair<Integer, String>(4, "fine"));

		System.out.println(s1.cartesianProduct(s3));

	}
}
