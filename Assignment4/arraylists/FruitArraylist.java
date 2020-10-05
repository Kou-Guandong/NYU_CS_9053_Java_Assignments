package arraylists;

import java.util.ArrayList;
import fruits.*;
import java.util.stream.Collectors;

public class FruitArraylist {

	public static void main(String[] args) {

		// Create 8 Fruit objects
		Apple redApple = new Apple("sweet", "crisp", "red", false);
		Apple rottenApple1 = new Apple("tart", "soft", "green", true);
		Apple rottenApple2 = new Apple("tart", "soft", "green", true);
		Lemon ripeLemon1 = new Lemon((int) (Math.random() * 100), "sour", false);
		Lemon ripeLemon2 = new Lemon((int) (Math.random() * 100), "sour", false);
		Lemon ripeLemon3 = new Lemon((int) (Math.random() * 100), "sour", false);
		Orange mandarin1 = new Orange("mandarin", "sweet", true);
		Orange mandarin2 = new Orange("mandarin", "sweet", true);

		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();
		fruitArrayList.add(redApple);
		fruitArrayList.add(rottenApple1);
		fruitArrayList.add(rottenApple2);
		fruitArrayList.add(ripeLemon1);
		fruitArrayList.add(ripeLemon2);
		fruitArrayList.add(ripeLemon3);
		fruitArrayList.add(mandarin1);
		fruitArrayList.add(mandarin2);

		// b. average sourness of all the Lemon objects
		System.out.println(fruitArrayList.stream().filter(obj -> obj instanceof Lemon)
				.mapToDouble(obj -> ((Lemon) obj).getSourness()).average());

		// c. Remove the matching objects
		Apple anotherRottenGreenApple = rottenApple1;

		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit currentFruit = fruitArrayList.get(i);
			if (currentFruit instanceof Apple && currentFruit.equals(anotherRottenGreenApple)) {
				System.out.println("The object that equals the first rotten green apple:\n" + currentFruit);
				// the same object
				if (currentFruit == anotherRottenGreenApple) {
					System.out.println("The same object: \n" + currentFruit);
				}
			}
		}

		// remove all the matching objects from the Arraylist.
		// (There are other ways to do it, here I used a functional-programming approach
		// via stream.)
		fruitArrayList = new ArrayList<Fruit>(
				fruitArrayList.stream().filter(obj -> !(obj instanceof Apple && obj.equals(anotherRottenGreenApple)))
						.collect(Collectors.toList()));

		// d. Print out the remaining objects
		System.out.println(fruitArrayList);

	}
}
