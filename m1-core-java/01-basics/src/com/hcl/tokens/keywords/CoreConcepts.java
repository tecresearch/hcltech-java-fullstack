/*
 * 🔑 Keywords Used
public, class, static, int, void, for, if, else, new, return
This code is clean, fast to run, and demonstrates the core syntax and logic used in Java programming contests.
 🔹 Data Type Keywords
Java provides several keywords to define the type of data a variable can hold. These include int, float, double, char, boolean, byte, short, and long. Each of these represents a primitive data type. For example, int is used for integers, double for decimal numbers with double precision, and boolean for true/false values.

🔹 Control Flow Keywords
To manage the flow of execution, Java uses keywords like if, else, switch, case, default, while, do, for, break, continue, and return. These allow you to make decisions (if/else), loop through data (for, while, do), exit loops early (break), skip iterations (continue), and return values from methods (return).

🔹 Access Modifiers
Java uses public, private, and protected to control access to classes, methods, and variables. public means accessible from anywhere, private restricts access to within the class, and protected allows access within the same package or subclasses.

🔹 Object-Oriented Programming Keywords
Java is an object-oriented language, and keywords like class, interface, extends, implements, new, this, and super are central to its design. You use class to define a blueprint, interface to define a contract, extends to inherit from a class, and implements to fulfill an interface. The new keyword creates objects, this refers to the current object, and super refers to the parent class.

🔹 Exception Handling Keywords
To handle errors gracefully, Java provides try, catch, finally, throw, and throws. You wrap risky code in a try block, handle exceptions in catch, and use finally for cleanup. throw is used to manually throw an exception, and throws declares exceptions a method might throw.

🔹 Class Behavior Modifiers
Java allows you to modify how classes and methods behave using keywords like abstract, final, static, synchronized, volatile, transient, native, and strictfp. For instance, abstract defines incomplete classes or methods, final prevents inheritance or overriding, and static makes a member belong to the class rather than an instance. synchronized and volatile are used in multithreading, while transient prevents serialization of fields. native links to non-Java code, and strictfp ensures consistent floating-point calculations.

🔹 Other Useful Keywords
Java also includes package and import for organizing and using code from other files. instanceof checks object types, enum defines a fixed set of constants, and assert is used for debugging.

🔹 Reserved but Not Used
Java reserves goto and const, but they are not used in the language. They exist to prevent conflicts with other languages or future extensions
 */
/*
 * Keywords in action:

package: organizes classes into namespaces.
public, private, protected: control visibility.
class: defines a blueprint.
void: indicates no return value.
new: used when creating objects (not shown here but used in main).

 */
package com.hcl.tokens.keywords;
public class CoreConcepts {

    // static variable
    static int counter = 0;

    // main method
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        // for loop and if-else
        for (int num : nums) {
            if (num % 2 == 0) {
                System.out.println(num + " is even");
            } else {
                System.out.println(num + " is odd");
            }
            counter++;
        }

        // method call
        CoreConcepts obj = new CoreConcepts();
        obj.displayCount();
    }

    // method using void and public
    public void displayCount() {
        System.out.println("Total numbers processed: " + counter);
    }
}
