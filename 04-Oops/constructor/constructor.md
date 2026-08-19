# Java Constructors

A **constructor** is a special member of a class that is automatically invoked when an object is created.

Its primary purpose is to **initialize the instance variables of an object**.

This section covers:

- What is a Constructor?
- Creating Objects Using Constructors
- Rules of Constructors
- Default Constructor
- No-Argument Constructor
- Parameterized Constructor
- Constructor Overloading
- Default Constructor vs No-Argument Constructor
- `this` Keyword
- Constructor Chaining

---

# 1. What is a Constructor?

A constructor is a special member of a class that is automatically called when an object is created.

Consider a `Student` class:

```java
class Student {

    String name;
    int age;
    int rollNo;
    String college;

    Student() {

        name = "Aditya";
        age = 21;
        rollNo = 101;
        college = "ABES";
    }
}
```

When an object is created:

```java
Student s1 = new Student();
```

the constructor is automatically called.

Conceptually:

```text
Student s1 = new Student();
                 │
                 ▼
          Object Creation
                 │
                 ▼
       Constructor is called
                 │
                 ▼
      Instance variables are initialized
```

Therefore:

> A constructor is automatically invoked during object creation and is primarily used to initialize an object's instance variables.

---

# 2. Creating an Object and Calling a Constructor

Consider:

```java
Student s1 = new Student();
```

This statement performs object creation.

The following part:

```java
new Student()
```

creates the object.

At the same time:

```text
Student()
```

calls the constructor.

Therefore:

```text
new Student()
      │
      ├──► Object is created
      │
      └──► Constructor is called
```

The constructor initializes the object.

---

# 3. Basic Constructor Example

```java
class Student {

    String name;
    int age;
    int rollNo;
    String college;

    Student() {

        name = "Aditya";
        age = 21;
        rollNo = 101;
        college = "ABES";
    }
}
```

Creating an object:

```java
Student s1 = new Student();
```

The constructor:

```java
Student()
```

is automatically called.

After the constructor executes, the object contains initialized values.

Conceptually:

```text
s1
 │
 ▼
┌──────────────────────┐
│ name    → Aditya     │
│ age     → 21         │
│ rollNo  → 101        │
│ college → ABES       │
└──────────────────────┘
```

---

# 4. Rules of Constructors

A constructor follows several important rules.

## Rule 1: Same Name as the Class

The constructor name must be the same as the class name.

Example:

```java
class Student {

    Student() {

    }
}
```

Here:

```text
Class Name       → Student
Constructor Name → Student
```

Both names are the same.

---

## Rule 2: No Return Type

A constructor does not have any return type.

Not even:

```java
void
```

Correct:

```java
Student() {

}
```

Incorrect:

```java
void Student() {

}
```

The second example is a method, not a constructor.

---

## Rule 3: Automatically Called During Object Creation

A constructor is automatically called when an object is created.

Example:

```java
Student s1 = new Student();
```

Conceptually:

```text
new Student()
      │
      ▼
Object Creation
      │
      ▼
Constructor Automatically Invoked
```

---

## Rule 4: Used to Initialize an Object

The primary purpose of a constructor is to initialize the instance variables of an object.

Example:

```java
class Student {

    String name;
    int age;

    Student() {

        name = "Aditya";
        age = 21;
    }
}
```

When an object is created, the constructor initializes its variables.

---

## Rule 5: Constructors Can Be Overloaded

A class can contain multiple constructors.

Example:

```java
class Student {

    Student() {

    }

    Student(String name) {

    }
}
```

This is called **constructor overloading**.

---

# 5. Default Constructor

A **default constructor** is a constructor automatically provided by the Java compiler when no constructor is explicitly defined in a class.

Example:

```java
class Student {

    String name;
    int age;
    int rollNo;
    String college;
}
```

Here, no constructor is explicitly written.

Therefore, Java provides a default constructor.

Now we can create an object:

```java
Student s1 = new Student();
```

The compiler-provided constructor allows object creation.

Conceptually:

```text
Class
 │
 ├── No constructor explicitly defined
 │
 ▼
Compiler provides
Default Constructor
 │
 ▼
Object can be created
```

---

# 6. Important Point About the Default Constructor

Suppose we have:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
```

Here, a constructor is explicitly defined.

Therefore, Java will **not automatically provide a default constructor**.

So:

```java
Student s1 = new Student();
```

will cause a compile-time error because no no-argument constructor exists.

You must either define a no-argument constructor:

```java
Student() {

}
```

or create the object using the parameterized constructor.

Example:

```java
Student s1 = new Student("Yash", 23);
```

---

# 7. No-Argument Constructor

A **no-argument constructor** is a constructor that does not accept any parameters.

Example:

```java
class Animal {

    String name;

    Animal() {

        name = "Unknown";
    }
}
```

Creating an object:

```java
Animal a1 = new Animal();
```

The constructor:

```java
Animal()
```

does not accept any parameters.

Therefore:

> A no-argument constructor is a constructor that does not accept any parameters.

It can initialize an object using default or predefined values.

---

# 8. Default Constructor vs No-Argument Constructor

These two concepts are often confused.

## Default Constructor

A default constructor is automatically provided by the compiler when no constructor is explicitly defined in the class.

```java
class Student {

    String name;
    int age;
}
```

Here, the compiler can provide a default constructor.

---

## No-Argument Constructor

A no-argument constructor is explicitly defined by the programmer and does not accept any parameters.

```java
class Student {

    String name;
    int age;

    Student() {

        name = "Unknown";
        age = 0;
    }
}
```

### Difference

| Default Constructor | No-Argument Constructor |
|---|---|
| Provided automatically by the compiler | Explicitly written by the programmer |
| Created when no constructor is defined | Can be defined by the programmer |
| Does not take parameters | Does not take parameters |

### Important

Both constructors do not accept parameters, but they are not necessarily the same concept.

```text
Default Constructor
        │
        └── Provided automatically by compiler

No-Argument Constructor
        │
        └── Explicitly defined by programmer
```

---

# 9. Parameterized Constructor

A **parameterized constructor** is a constructor that accepts parameters.

It is used to initialize different objects with different values at the time of object creation.

Example:

```java
class Student {

    String name;
    int age;
    int rollNo;
    String college;

    Student(String name, int age, int rollNo, String college) {

        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.college = college;
    }
}
```

Now we can create objects with different values:

```java
Student s1 = new Student("Yash", 23, 101, "ABES");

Student s2 = new Student("Om", 22, 102, "ABES");
```

Conceptually:

```text
Student Class
       │
       ├──► s1 → Yash, 23, 101, ABES
       │
       └──► s2 → Om, 22, 102, ABES
```

Therefore:

> A parameterized constructor accepts parameters and allows objects to be initialized with different values at the time of object creation.

---

# 10. Why Do We Need Parameterized Constructors?

Suppose we use only a no-argument constructor:

```java
Student s1 = new Student();
```

Every object may receive the same predefined values.

However, different students should be able to have different values.

For example:

```text
Student 1
Name → Yash
Age  → 23

Student 2
Name → Om
Age  → 22
```

A parameterized constructor allows us to provide these values during object creation.

```java
Student s1 = new Student("Yash", 23);
Student s2 = new Student("Om", 22);
```

---

# 11. Constructor Overloading

Constructor overloading means defining multiple constructors in the same class with different parameter lists.

Example:

```java
class Student {

    Student() {

    }

    Student(String name) {

    }

    Student(String name, int age) {

    }
}
```

Here, the `Student` class contains three constructors.

```text
Student()
Student(String name)
Student(String name, int age)
```

These constructors have different parameter lists.

Therefore, this is called **constructor overloading**.

---

# 12. Example of Constructor Overloading

Consider:

```java
class Animal {

    String name;
    int age;

    Animal() {

        name = "Unknown";
        age = 0;
    }

    Animal(String name) {

        this.name = name;
        age = 0;
    }

    Animal(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
```

Now objects can be created in different ways:

```java
Animal a1 = new Animal();

Animal a2 = new Animal("Tiger");

Animal a3 = new Animal("Lion", 9);
```

Different constructors are called depending on the arguments passed during object creation.

```text
new Animal()
        │
        ▼
Animal()

new Animal("Tiger")
        │
        ▼
Animal(String name)

new Animal("Lion", 9)
        │
        ▼
Animal(String name, int age)
```

---

# 13. What is Constructor Overloading?

Constructor overloading is the process of defining multiple constructors in the same class with different parameter lists.

This allows objects to be initialized in different ways.

Example:

```java
class Student {

    Student() {

    }

    Student(String name) {

    }

    Student(String name, int age) {

    }
}
```

The compiler determines which constructor should be called based on:

- Number of parameters
- Type of parameters
- Order of parameters

---

# 14. `this` Keyword

The `this` keyword refers to the **current object being created**.

It is also used to distinguish instance variables from parameters when both have the same name.

Consider:

```java
class Student {

    String name;
    int age;
    String college;

    Student(String name, int age, String college) {

        this.name = name;
        this.age = age;
        this.college = college;
    }
}
```

Here:

```java
this.name
```

refers to the instance variable:

```java
String name;
```

while:

```java
name
```

refers to the constructor parameter.

Conceptually:

```text
this.name = name;

   │          │
   │          └── Parameter
   │
   └── Instance Variable
```

---

# 15. Why Do We Use `this`?

Consider:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
```

The parameters:

```java
String name
int age
```

have the same names as the instance variables:

```java
String name;
int age;
```

Therefore:

```java
this.name = name;
```

means:

```text
Instance Variable = Parameter
```

Similarly:

```java
this.age = age;
```

means:

```text
Instance Variable = Parameter
```

---

# 16. Complete Example Using `this`

```java
class Student {

    String name;
    int age;
    String college;

    Student(String name, int age, String college) {

        this.name = name;
        this.age = age;
        this.college = college;
    }
}
```

Creating an object:

```java
Student s1 = new Student("Yash", 23, "ABES");
```

Conceptually:

```text
Parameters
     │
     ▼
┌─────────────────────┐
│ name    → Yash      │
│ age     → 23        │
│ college → ABES      │
└─────────────────────┘
     │
     ▼
Constructor
     │
     ▼
this.name    = name
this.age     = age
this.college = college
     │
     ▼
Object Initialized
```

---

# 17. Constructor Chaining

**Constructor chaining** is a mechanism in Java where one constructor calls another constructor to reuse initialization code.

This is done using the `this()` keyword.

```text
One Constructor
       │
       ▼
Calls Another Constructor
       │
       ▼
Initialization Code is Reused
```

---

# 18. `this()` in Constructor Chaining

The `this()` keyword is used for constructor chaining within the same class.

Example:

```java
class Student {

    String name;
    int age;

    Student() {

        this("Unknown", 18);
    }

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
```

Here:

```java
this("Unknown", 18);
```

calls another constructor of the same class:

```java
Student(String name, int age)
```

Conceptually:

```text
Student()
    │
    ▼
this("Unknown", 18)
    │
    ▼
Student(String name, int age)
    │
    ▼
Object Initialized
```

---

# 19. Important Rule of `this()`

When constructor chaining is used:

```java
this(...);
```

must always be the **first statement** inside the constructor.

Correct:

```java
Student() {

    this("Unknown", 18);
}
```

Incorrect:

```java
Student() {

    System.out.println("Hello");

    this("Unknown", 18);
}
```

Therefore:

> `this()` must be the first statement in a constructor.

---

# 20. Constructor Chaining Example

```java
class Student {

    String name;
    int age;

    Student() {

        this("Unknown", 18);
    }

    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
```

Creating an object:

```java
Student s1 = new Student();
```

Execution flow:

```text
Student s1 = new Student()
                │
                ▼
           Student()
                │
                ▼
      this("Unknown", 18)
                │
                ▼
 Student(String name, int age)
                │
                ▼
this.name = name
this.age = age
                │
                ▼
       Object Initialized
```

---

# 21. Complete Constructor Example

```java
class Student {

    String name;
    int age;

    // No-Argument Constructor
    Student() {

        this("Unknown", 18);
    }

    // Parameterized Constructor
    Student(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
```

Creating objects:

```java
Student s1 = new Student();

Student s2 = new Student("Yash", 23);
```

For:

```java
Student s1 = new Student();
```

the no-argument constructor is called.

It then calls:

```java
this("Unknown", 18);
```

which invokes the parameterized constructor.

For:

```java
Student s2 = new Student("Yash", 23);
```

the parameterized constructor is directly called.

---

# 22. Quick Revision

```text
Constructor
    │
    ├── Special member of a class
    │
    ├── Same name as class
    │
    ├── No return type
    │
    ├── Automatically called during object creation
    │
    ├── Used to initialize objects
    │
    └── Can be overloaded
```

---

# 23. Types of Constructors

```text
Constructors
      │
      ├── Default Constructor
      │       └── Automatically provided by compiler
      │           when no constructor is explicitly defined
      │
      ├── No-Argument Constructor
      │       └── Explicitly defined by programmer
      │           and accepts no parameters
      │
      └── Parameterized Constructor
              └── Accepts parameters and initializes
                  objects with different values
```

---

# 24. Constructor Overloading

```text
Constructor Overloading
        │
        ▼
Multiple Constructors
in the Same Class
        │
        ▼
Different Parameter Lists
        │
        ▼
Objects Can Be Initialized
in Different Ways
```

Example:

```java
Student()

Student(String name)

Student(String name, int age)
```

---

# 25. `this` Keyword

```text
this
 │
 ├── Refers to the current object
 │
 ├── Used to access instance variables
 │
 ├── Distinguishes instance variables
 │   from parameters
 │
 └── this()
       │
       └── Used for constructor chaining
```

---

# 26. Key Takeaways

- A constructor is a special member of a class.
- A constructor has the same name as its class.
- A constructor does not have a return type, not even `void`.
- A constructor is automatically invoked when an object is created.
- The primary purpose of a constructor is to initialize an object's instance variables.
- A default constructor is automatically provided by the compiler when no constructor is explicitly defined.
- A no-argument constructor does not accept any parameters.
- A parameterized constructor accepts parameters and allows objects to be initialized with different values.
- Constructors can be overloaded by defining multiple constructors with different parameter lists.
- The `this` keyword refers to the current object.
- `this` is used to distinguish instance variables from parameters with the same name.
- `this()` is used for constructor chaining within the same class.
- `this()` must always be the first statement inside a constructor.