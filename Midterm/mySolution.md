## problem 1

Explain the purpose of the keyword `this` in Java.

- Within an instance method or a constructor, `this` is a reference to the current object — the object whose method or constructor is being called.
    - Invoke current class constructor
    - Invoke current class method
    - Return the current class object
    - Pass an argument in the method call
    - Pass an argument in the constructor call


## Problem 2
What will the value of `circle.getRadius()` be?
- 5
What will the value of i be when `startMethod()` ends?
- 5

Explanation:  
For the `modifyArgs(int i, Circle c)` method, the integer parameter was parsed by copying the original value, so that the variable `i` in the `startMethod` was not changed; while the `Circle` parameter was parsed by reference, so that the `circle` object got its `radius` variable increased by 1 in line `c.setRadius(c.getRadius()+1)`. 


## Problem 3
- See code

```
package edu.nyu.cs9053.midterm.hierarchy;

import java.io.*;

class Main {
    public static void main(String[] args) {
        FileReader file;
        try {
            System.out.println(System.getProperty("user.dir"));
            file = new FileReader("data.txt");
            BufferedReader fileInput = new BufferedReader(file);
            String inLine = fileInput.readLine();
            while (inLine != null) {
                String[] numbers = inLine.split(" ");
                Integer a = Integer.parseInt(numbers[0]);
                Integer b = Integer.parseInt(numbers[1]);
                try {
                    Integer c = a / b;
                    System.out.println("result = " + c);
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                }
                inLine = fileInput.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("program ended.");
        }
    }
}
```



## Problem 4
Definition of terms:
- Aircraft: a vehicle that is able to fly by gaining support from the air.
- HotAirBalloon: a lighter-than-air aircraft consisting of a bag, called an envelope, which contains heated air.
- Glider: a fixed-wing aircraft that is supported in flight by the dynamic reaction of the air against its lifting surfaces, and whose free flight does not depend on an engine.
- JetPlane: an aircraft propelled by jet engines.
- PropellerPlane: an airplane that is driven by a propeller.

inheritance hierarchy for these objects:  
```
Aircraft
 | -- HotAirBalloon
 | -- Glider
 | -- JetPlane
        | -- PropellerPlane
```
Explanation:
- Aircraft is the superclass for all vehicles that is able to fly by gaining support from the air.
- HotAirBalloon is an Aircraft that contains heated air, and thus should be a subclass of Aircraft.
- Glider is an Aircraft that does not depend on an engine, and thus should be a subclass of Aircraft.
- JetPlane is an aircraft propelled by jet engines, and thus should be a subclass of Aircraft.
- PropellerPlane is an aircraft driven by a properller, which should be a subclass of JetPlane.

## Problem 5
Give two reasons you might want to use an ArrayList instead of an array.
- ArrayList is dynamically sized, i.e. its size can be changed, while Array has fixed size.
- ArrayList can add or remove elements at particular positions.
- ArrayList can have different type of objects added to it.

## Problem 6
What does the `static` keyword mean in this context and why is `nextId` declared static?
- The `static` keyword means that the static variable belongs to the class, rather than the instances of the class. 
- `nextId` is declared static because we want to keep an increading ID for each instances of the class.

## Problem 7
What is the difference between an overridden and overloaded method?
- Overloading occurs when two or more methods in one class have the same method name but different parameters (i.e. method signature).
- Overriding means having two methods with the same method name and parameters (i.e., method signature). Overriding allows a child class to provide a specific implementation of a method that is already provided its parent class.
- Overriding is a run-time concept while overloading is a compile-time concept. The real object type in the run-time, not the reference variable's type, determines which overridden method is used at runtime. In contrast, reference type determines which overloaded method will be used at compile time.

## Problem 8
Take that object from an array declared as Object[] objs. The result of `(new Object()).toString()` is something like `java.lang.Object@15db9742`. The object type followed by the @ sign and a unique identifier. In the `objs` array, let’s say we execute the following:
```
objs[5] = new Integer(20);
Object myObj = objs[5];
```
What is the output of `myObj.toString()`? Explain why.
- The output is `20`.
- When `myObj.toString()` method is invoked, `myObj` references to `objs[5]`, which is an instance of integer 20. The `toString()` method of an integer returns the `String` object representing this integer’s value, i.e. "20".

## Problem 9
Remember in an earlier lecture when discussing Abstracts, Interfaces, and Generics we
had the class Fruit, declared as:
```
public abstract class Fruit { 
    public Fruit(String name) { /*etc*/ } 
    /*etc */ 
}
```
We created Apple and Orange objects. Why didn’t we ever simply do the following?
```
Fruit f = new Fruit("Apple");
```
There are several reasons:
- it is not efficient
    - in that way we have to add other methods and variables of each instances of `Apple`, which can be shared by all the `Apple` instances.
- it is not robust
    - although we can add methods and variables to the `Fruit` class for it to fit our `Apple` instance, it cannot fit for other subtypes of fruits e.g. `Orange`. (Obviously, `Orange` and `Apple` may have different methods and variables.)

## Problem 10
In this week’s lecture, we had two abstract classes, Animal and Fruit, from which we made various subclasses. Some of those subclasses implemented the interface Edible. Why did we choose to make classes subclasses of Animal and Fruit, but have Edible as an interface? To put the question more generally, why would you design an object as a subclass of another object vs. why would you create an interface and have an object implement an interface? (There’s no single right answer to this question, but there are definitely wrong answers)

- If we want to define a "contract", i.e. method signatures that we want the inheriting classes to implement, then interfaces are preferred. 
- If we want to define default behaviours in non-abstract methods (to reuse without rewriting redundant code), then subclasses are preferred. 
- If we defined a pure abstract class (with only abstract methods and nothing else), then we should choose an interface. This is because a class can implement multiple interfaces, while a class can extend from only one other class.

