# Java Internals: Objects, Memory Layout & References

A concise deep dive into some important Java concepts:

* Object memory layout
* Object headers and metadata
* Exact data and padding
* Call by Value vs reference behavior
* Object reference passing
* Shallow Copy vs Deep Copy

---

##  Table of Contents

* [1. Objects Deep Dive](#1-objects-deep-dive)

    * [Object Example](#object-example)
    * [Object Memory Layout](#object-memory-layout)
    * [Header Size](#header-size)
    * [Exact Data](#exact-data)
    * [Padding](#padding)
* [2. Call by Value](#2-call-by-value)
* [3. Object References in Java](#3-object-references-in-java)
* [4. Shallow Copy](#4-shallow-copy)
* [5. Deep Copy](#5-deep-copy)

---
# 1. Objects Deep Dive

Consider the following class:

```java
class Student {
    String name;
    int age;
    int rollNo;
    String college;
}
```

A `Student` object contains data associated with its fields.

Conceptually:

```text
Student Object
┌─────────────────┐
│ Header          │
├─────────────────┤
│ name            │
│ age             │
│ rollNo          │
│ college         │
├─────────────────┤
│ Padding         │
└─────────────────┘
```

The total object size can be understood as:

```text
Object Size = Header + Exact Data + Padding
```

---

## Object Memory Layout

An object in memory can be divided into three major parts:

### 1️⃣ Header

The object header contains information such as:

* Mark Word / object-related metadata
* Class pointer
* Other JVM-related information

### 2️⃣ Exact Data

This is the actual memory required by the instance fields.

For example:

```java
class Student {
    String name;
    int age;
    int rollNo;
    String college;
}
```

The fields contribute to the object's instance data.

Conceptually:

```text
name      → reference
age       → 4 bytes
rollNo    → 4 bytes
college   → reference
```

> The actual memory representation can depend on the JVM and runtime configuration.

---

## Header Size

According to the notes, the object header is represented as containing metadata and class-related information.

Conceptually:

```text
┌─────────────────────────┐
│ Mark Word / Metadata    │
├─────────────────────────┤
│ Class Pointer           │
└─────────────────────────┘
```

The header helps the JVM manage and identify the object.

---

## Exact Data

The **exact data** section represents the memory occupied by the object's instance fields.

Example:

```java
class Student {
    String name;
    int age;
    int rollNo;
    String college;
}
```

Conceptually:

```text
Student
│
├── name
├── age
├── rollNo
└── college
```

The memory required depends on the type of each field.

---

## Padding

Sometimes the JVM adds **padding bytes** to an object.

Why?

Because objects are generally aligned according to memory alignment requirements.

Example:

```text
Exact Data + Padding
```

If an object's data does not fit neatly into the required alignment boundary, extra bytes may be added.

Conceptually:

```text
Required object size: multiple of N

Actual data:      28 bytes
Additional space:  4 bytes
──────────────────────────
Total size:      32 bytes
```

So:

```text
Total Object Size
=
Object Header
+
Exact Data
+
Padding
```

---

# 2. Call by Value

Java is **strictly pass by value**.

When a variable is passed to a method, Java passes a **copy of that variable's value**.

For primitive values:

```java
public class Main {

    static void changeValue(int number) {
        number = 100;
    }

    public static void main(String[] args) {
        int number = 10;

        changeValue(number);

        System.out.println(number);
    }
}
```

Output:

```text
10
```

Why?

Because `changeValue()` receives a copy:

```text
Original variable
number = 10

        │
        ▼

Copy passed to method
number = 10
```

Changing the copied value does not modify the original variable.

---

# 3. Object References in Java

With objects, the situation can appear different.

Consider:

```java
Student student = new Student();
```

A variable such as `student` stores a reference value that points to an object.

Conceptually:

```text
Reference Variable
       │
       ▼
┌───────────────┐
│    Student    │
├───────────────┤
│ name          │
│ age           │
│ rollNo        │
│ college       │
└───────────────┘
```

When an object reference is passed to a method, Java passes a **copy of the reference value**.

```text
Original Reference ──┐
                     │
                     ▼
                  Object
                     ▲
                     │
Copied Reference ─────┘
```

Therefore, both references can point to the same object.

Because of this, changes made to the object's internal state through the copied reference can be visible through the original reference as well.

Example:

```java
class Student {
    String name;
}

public class Main {

    static void updateStudent(Student student) {
        student.name = "Rahul";
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Aman";

        updateStudent(student);

        System.out.println(student.name);
    }
}
```

Output:

```text
Rahul
```

This happens because both references point to the same object.

---

# Important Note: Java Is Not Call by Reference

A common misconception is:

> "Java passes objects by reference."

More accurately:

```text
Java is always Pass by Value.
```

For object variables:

```text
The value being copied = the object reference.
```

So when a method receives an object:

```text
Original Reference ─────┐
                        ▼
                     Object
                        ▲
                        │
Copied Reference ───────┘
```

Both references may point to the same object, but the reference itself was passed by value.

---

# 4. Shallow Copy

A **shallow copy** creates a new object, but copies the references of nested objects.

Conceptually:

```text
Original Object
│
├── primitive values
└── reference ────────────┐
                          ▼
                     Nested Object
                          ▲
                          │
Copied Object ────────────┘
```

Example structure:

```text
Original
┌─────────────┐
│ data        │
│ nested ─────┼──────┐
└─────────────┘      │
                     ▼
                Nested Object
                     ▲
                     │
┌─────────────┐      │
│ Copy        │──────┘
│ nested      │
└─────────────┘
```

The outer object is copied, but nested references may still point to the same object.

Therefore:

```text
Modification to a shared nested object
can be reflected in both objects.
```

---

# 5. Deep Copy

A **deep copy** creates a completely independent copy.

This includes creating separate copies of nested objects.

Conceptually:

```text
Original Object
│
└── Nested Object A


Copied Object
│
└── Nested Object B
```

The nested objects are separate:

```text
Original
┌─────────────┐
│ nested ─────┼──────► Nested Object A
└─────────────┘


Copy
┌─────────────┐
│ nested ─────┼──────► Nested Object B
└─────────────┘
```

Therefore:

```text
Changes to the copied object
do not affect the original object.
```

---

# Shallow Copy vs Deep Copy

| Feature                         | Shallow Copy | Deep Copy |
| ------------------------------- | ------------ | --------- |
| Creates new outer object        | Yes          | Yes       |
| Copies nested references        | Yes          | No        |
| Creates new nested objects      | No           | Yes       |
| Nested objects are shared       | Usually yes  | No        |
| Changes can affect both objects | Yes          | No        |

---

# Quick Summary

```text
OBJECT MEMORY
│
├── Header
│   ├── Metadata
│   └── Class Pointer
│
├── Exact Data
│   └── Instance Fields
│
└── Padding
    └── Memory Alignment
```

```text
JAVA METHOD PASSING
│
└── Always Pass by Value
    │
    ├── Primitive
    │   └── Copy of actual value
    │
    └── Object Variable
        └── Copy of reference value
```

```text
COPYING
│
├── Shallow Copy
│   └── Nested references may be shared
│
└── Deep Copy
    └── Independent nested objects
```

---

## 🚀 Key Takeaways

* Java objects contain a conceptual combination of **header, instance data, and padding**.
* Object headers contain JVM-related metadata and class information.
* Exact data represents the object's instance fields.
* Padding may be used for memory alignment.
* Java is **always pass by value**.
* When an object variable is passed to a method, a **copy of its reference value** is passed.
* This allows multiple references to point to the same object.
* A **shallow copy** may share nested object references.
* A **deep copy** creates independent copies of nested objects.

---

