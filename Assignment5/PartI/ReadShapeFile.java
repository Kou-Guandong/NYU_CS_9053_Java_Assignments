import java.io.*;
import java.util.ArrayList;

import shapes.*;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shapeName) throws ShapeException {

		/*
		 * if shapeName is "Circle" return Circle(); if shapeName is "Square" return
		 * Square(); if shapeName is "Rectangle" return Rectangle(); if it is not any
		 * one of these, it should throw a ShapeException
		 */

		if (shapeName.equals("Circle")) {
			return new Circle();
		} else if (shapeName.equals("Square")) {
			return new Square();
		} else if (shapeName.equals("Rectangle")) {
			return new Rectangle();
		} else {
			throw new ShapeException("Invalid Shape");
		}
	}

	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		ArrayList<String> strList = new ArrayList<String>();

		File f = new File("shapes.txt");

		String inString = null;
		InputStreamReader isr = null;

		/* create a loop to read the file line-by-line */
		try {
			isr = new InputStreamReader(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(isr);
			while ((inString = br.readLine()) != null) {
				strList.add(inString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String inStr : strList) {
			try {
				GeometricObject shape = createShape(inStr);
				shapeList.add(shape);
			} catch (ShapeException e) {
				e.printStackTrace();
				System.err.println("Cannot create shape: " + inStr);
			}

		}

		System.out.println(shapeList.subList(0, 5));
		System.out.println(shapeList.size());

	}
}
