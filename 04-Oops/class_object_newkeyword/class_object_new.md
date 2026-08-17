# Java OOP — Class, Object & `new` Keyword

Object-Oriented Programming (OOP) is a programming approach where we represent real-world entities as **objects** and define their **characteristics** and **behaviour**.

Covers:

* Problems with representing real-world entities using independent variables
* Basic concept of OOP
* Real-world vs Programming-world representation
* Class
* Object
* Blueprint of an Object
* Creating an Object
* `new` Keyword
* Dynamic Memory Allocation
* Static Memory Allocation
* Reference Variable
* Heap and Stack
* Dot (`.`) Operator
* Naming Conventions
* Characteristics and Behaviour of an Object

---

# 1. Object-Oriented Programming

Consider a real-world **Student**.

A student can have different characteristics such as:

```text
Name
Age
Roll No
College
```

For example:

```text
Student 1:
Name    → Aditya
Age     → 28
Roll No → 101
College → ABES
```

Another student:

```text
Student 2:
Name    → Rohit
Age     → 20
Roll No → 102
College → ABES
```

If we represent these students using independent variables, we need a separate set of variables for every student.

```java
String name = "Aditya";
int age = 28;
int rollNo = 101;
String college = "ABES";

String name2 = "Rohit";
int age2 = 20;
int rollNo2 = 102;
String college2 = "ABES";
```

This approach creates several problems.

---

# 2. Problems with Independent Variables

### Problem 1 — Too Many Independent Variables

We need a lot of independent variables to represent one student.

```text
name
age
rollNo
college
```

For every new student, another set of variables would be required.

---

### Problem 2 — Passing Data Becomes Difficult

Suppose we want to pass the student information to a function.

We may need to pass all the variables separately:

```text
name
age
rollNo
college
```

This makes the code difficult to manage.

---

### Problem 3 — Repeating Variables for Every Student

For a new student, we need to create a new set of variables.

```text
Student 1 → name, age, rollNo, college
Student 2 → name, age, rollNo, college
Student 3 → name, age, rollNo, college
...
```

---

### Problem 4 — No Authority Over Data

The data is represented using separate variables, so there is no proper structure or authority over the complete student data.

---

# 3. Basic Concept of OOP

The basic idea of OOP is:

> Instead of representing every characteristic using independent variables, group related characteristics together into a single unit.

In the real world, a **Student** has:

```text
Name
Age
Roll No
College
```

In the programming world, we can represent the same concept using an **object**.

```text
Student Object
┌───────────────┐
│ Name          │
│ Age           │
│ Roll No       │
│ College       │
└───────────────┘
```

The idea is:

```text
Real World
    ↓
Student
    ↓
Name, Age, Roll No, College
    ↓
Programming World
    ↓
Object
```

Instead of creating separate variables for every characteristic, we create one object that contains these characteristics.

---

# 4. Real World vs Programming World

## Real World

A student is a real-world entity.

```text
Student
   │
   ├── Name
   ├── Age
   ├── Roll No
   └── College
```

There can be different students:

```text
Arun
Varun
```

Both are students, and both have the same basic characteristics:

```text
Name
Age
Roll No
College
```

But their actual values can be different.

---

## Programming World

We represent the idea of a student using a **class**.

```java
class Student {

    String name;
    int age;
    int rollNo;
    String college;
}
```

The class contains the characteristics that a Student object should have.

---

# 5. Class

A **class** represents the structure or blueprint of an object.

Example:

```java
class Student {

    String name;
    int age;
    int rollNo;
    String college;
}
```

The class defines:

```text
Student
 ├── name
 ├── age
 ├── rollNo
 └── college
```

These characteristics describe what a Student object will contain.

### Class as a Blueprint

A class can be thought of as a:

> **Blueprint of an object**

The class defines what characteristics an object should have.

---

# 6. Abstract Idea of a Class

In the real world, we have the concept of a **Student**.

The student concept tells us that a student has characteristics such as:

```text
Name
Age
Roll No
College
```

But actual students can be different.

For example:

```text
Arun
Varun
```

Both are students, but they can have different values for their characteristics.

Similarly, in programming:

```java
class Student {

    String name;
    int age;
    int rollNo;
    String college;
}
```

The class represents the general idea or structure of a Student.

Actual objects will contain their own values.

---

# 7. Creating an Object

Consider the class:

```java
class Student {

    String name;
    int rollNo;
    int age;
    String college;
}
```

To create an object:

```java
Student s1 = new Student();
```

This statement contains two important parts:

```text
Student s1
```

and

```text
new Student()
```

---

## 7.1 Declaration

```java
Student s1;
```

Here:

```text
Student → Type
s1      → Reference Variable
```

The variable `s1` is a reference variable.

It will store the reference to a Student object.

---

## 7.2 Object Creation

```java
new Student();
```

The `new` keyword is used to create the object.

Conceptually:

```text
new Student()
      ↓
Object created
      ↓
Memory allocated
```

---

# 8. `new` Keyword

The `new` keyword is used for **dynamic memory allocation**.

Example:

```java
Student s1 = new Student();
```

The `new` keyword creates an object and allocates memory for it.

Conceptually:

```text
new Student()
      ↓
Heap Memory
      ↓
Student Object
```

The object contains the characteristics defined inside the class:

```text
┌─────────────────────┐
│ name                │
│ age                 │
│ rollNo              │
│ college             │
└─────────────────────┘
```

---

# 9. Dynamic Memory Allocation

The `new` keyword is associated with **dynamic memory allocation**.

```java
Student s1 = new Student();
```

The object memory is allocated during runtime.

Conceptually:

```text
Code
 ↓
Runtime
 ↓
new Student()
 ↓
Memory allocation
```

The memory is allocated when the code runs.

---

# 10. Static Memory Allocation

Consider:

```java
int x = 4;
```

This represents **static memory allocation** in the notes.

The memory is allocated during compile time.

```text
int x = 4
   ↓
Static Memory Allocation
   ↓
Memory allocated during compile time
```

---

# 11. Stack and Heap

Consider:

```java
Student s1 = new Student();
```

Conceptually, two things are involved:

```text
Stack
  │
  │ s1
  │
  ↓
Heap
  │
  │ Student Object
  ↓
┌─────────────────────┐
│ name                │
│ age                 │
│ rollNo              │
│ college             │
└─────────────────────┘
```

### Stack

The reference variable:

```java
Student s1
```

is represented conceptually on the stack.

### Heap

The actual object created using:

```java
new Student()
```

is created in heap memory.

---

# 12. Reference Variable

Consider:

```java
Student s1 = new Student();
```

Here:

```text
s1
```

is a **reference variable**.

It refers to the object created in heap memory.

Conceptually:

```text
Stack                         Heap

┌───────────┐                 ┌─────────────────┐
│    s1     │ ─────────────→  │ Student Object  │
└───────────┘                 ├─────────────────┤
                              │ name            │
                              │ age             │
                              │ rollNo          │
                              │ college         │
                              └─────────────────┘
```

Therefore:

> `s1` is not the actual object. It is a reference pointing to the object in heap memory.

---

# 13. Important Understanding of `s1`

Consider:

```java
Student s1 = new Student();
```

`new Student()` creates the actual object.

```text
new Student()
      ↓
Actual Object
      ↓
Heap
```

Whereas:

```text
s1
```

is only a reference variable that points to that object.

Conceptually:

```text
s1 ─────────────→ Object
                  ↑
                 Heap
```

So:

> The reference variable stores the reference/address of an object in heap memory.

---

# 14. Accessing Object Data

Once an object is created:

```java
Student s1 = new Student();
```

we can access its characteristics using the **dot (`.`) operator**.

Example:

```java
s1.name = "Yash";
s1.age = 23;
s1.rollNo = 101;
s1.college = "ABES";
```

Conceptually:

```text
s1
 │
 ↓
┌─────────────────────┐
│ name    → "Yash"    │
│ age     → 23        │
│ rollNo  → 101       │
│ college → "ABES"    │
└─────────────────────┘
```

---

# 15. Dot (`.`) Operator

The dot operator is used to access the **fields of an object**.

Example:

```java
s1.name
s1.age
s1.rollNo
s1.college
```

Here:

```text
s1 → Object reference
.  → Dot operator
name / age / rollNo / college → Fields
```

Conceptually:

```text
object reference
       ↓
      s1
       .
       ↓
     field
```

Therefore:

> The dot operator is used to access the fields of an object.

---

# 16. Multiple Objects of the Same Class

Consider:

```java
Student s1 = new Student();
Student s2 = new Student();
```

Both `s1` and `s2` are objects of the `Student` class.

Each object has its own characteristics.

Conceptually:

```text
Stack                          Heap

┌───────────┐                  ┌─────────────────┐
│    s1     │ ───────────────→ │ Student Object  │
├───────────┤                  ├─────────────────┤
│    s2     │ ───────────────→ │ Student Object  │
└───────────┘                  └─────────────────┘
```

The two objects are separate.

Therefore, changing the data of one object does not mean that the other object automatically gets the same data.

Example:

```java
s1.name = "Yash";
s1.age = 23;
s1.rollNo = 101;
s1.college = "ABES";

s2.name = "Om";
s2.age = 22;
s2.rollNo = 102;
s2.college = "ABES";
```

Each object maintains its own characteristics.

---

# 17. Characteristics of an Object

An object can have multiple characteristics.

For a Student:

```text
Student
   │
   ├── Name
   ├── Age
   └── Roll No
```

In programming, these characteristics are represented using variables inside the class.

Example:

```java
class Student {

    String name;
    int age;
    int rollNo;
}
```

These variables represent the characteristics of the object.

---

# 18. Representing Behaviour of an Object

An object does not only have characteristics.

It can also have **behaviour**.

For a Student:

```text
Characteristics
   ├── Name
   ├── Age
   └── Roll No

Behaviour
   └── Mark Attendance
```

In programming, behaviour is represented using **functions/methods**.

Example:

```java
class Student {

    String name;
    int age;
    int rollNo;

    void markAttendance() {
        // behaviour
    }
}
```

So:

```text
Object
 │
 ├── Characteristics → Variables
 │
 └── Behaviour       → Functions / Methods
```

---

# 19. Calling Object Behaviour

Consider:

```java
Student s1 = new Student();
```

The object's characteristics can be accessed using the dot operator:

```java
s1.name;
```

Similarly, the object's behaviour can be accessed using the dot operator:

```java
s1.markAttendance();
```

The dot operator is therefore used to access both:

```text
Object → Fields
Object → Methods
```

Example:

```java
Student s1 = new Student();

s1.name;
s1.markAttendance();
```

---

# 20. Complete Example

```java
class Student {

    String name;
    int age;
    int rollNo;
    String college;

    void markAttendance() {
        // behaviour
    }
}
```

Creating an object:

```java
Student s1 = new Student();
```

Assigning characteristics:

```java
s1.name = "Yash";
s1.age = 23;
s1.rollNo = 101;
s1.college = "ABES";
```

Calling behaviour:

```java
s1.markAttendance();
```

Conceptually:

```text
                    Student Class
                         │
          ┌──────────────┴──────────────┐
          │                             │
   Characteristics                  Behaviour
          │                             │
   ┌──────┼──────┐              markAttendance()
   │      │      │
 name    age   rollNo
```

---

# 21. Naming Conventions

The notes follow these naming conventions:

### Variables

Use **camelCase**.

Example:

```java
firstName
```

---

### Classes

Start with a **capital letter**.

Example:

```java
Student
```

---

### Functions / Methods

Use **camelCase** and start with a lowercase letter.

Example:

```java
firstName()
```

---

# 22. Quick Revision

```text
OOP
 │
 ├── Class
 │     └── Blueprint of an object
 │
 ├── Object
 │     ├── Characteristics
 │     │      └── Variables / Fields
 │     │
 │     └── Behaviour
 │            └── Functions / Methods
 │
 ├── new Keyword
 │     └── Dynamic memory allocation
 │
 ├── Reference Variable
 │     └── Refers to an object in heap memory
 │
 └── Dot Operator
       └── Accesses object's fields and methods
```

---

# 23. Key Takeaways

* OOP provides a way to represent real-world entities in programming.
* A **class** represents the structure or blueprint of an object.
* An **object** represents an actual instance of a class.
* A class can contain characteristics and behaviour.
* Characteristics are represented using variables/fields.
* Behaviour is represented using functions/methods.
* The `new` keyword is used for dynamic memory allocation and object creation.
* The actual object is created in heap memory.
* The variable such as `s1` acts as a reference to the object.
* The dot (`.`) operator is used to access an object's fields and methods.
* Multiple objects can be created from the same class.
* Each object maintains its own characteristics.
* Variables follow camelCase naming.
* Classes start with a capital letter.
* Functions/methods follow camelCase naming.
