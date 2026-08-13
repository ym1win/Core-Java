# Java Basics

This section contains my learning notes and code from the Java Basics part of the Coder Army Java course.

## Topics Covered

- Java Introduction
- JDK, JRE and JVM
- Java Program Execution
- Variables and Data Types
- Type Casting
- Operators
- Conditional Statements
- Loops

## Important Concepts

> Detailed explanations are maintained in my handwritten notes.
> This README contains only the key points I want to remember and revise quickly.

# Java Basics

Java fundamentals covering the Java platform, JVM architecture, data types, type conversion, operators, and control flow.

---

## 1. Introduction to Java

Java was designed to address several limitations commonly associated with traditional compiled languages, especially:

* **Platform dependency**
* Complexity
* Manual memory management
* Security concerns

Java focuses on:

* **Platform independence**
* Simplicity
* Security
* Automatic memory management

---

# 2. Platform Dependency vs Platform Independence

## Platform

A platform can be thought of as the combination of the **operating system and hardware environment** on which a program executes.

Examples:

* Windows
* Linux
* macOS
* Different processor architectures

## Why are traditional compiled programs platform-dependent?

A typical C/C++ program is compiled into **machine code** for a particular target environment.

```text
C/C++ Source Code
        ↓
     Compiler
        ↓
Platform-specific Machine Code
        ↓
     Hardware / OS
```

The same source code may need to be compiled separately for different target platforms.

---

# 3. How Java Achieves Platform Independence

Java introduces an intermediate representation called **bytecode**.

```text
Java Source Code
       ↓
     javac
       ↓
   Bytecode (.class)
       ↓
      JVM
       ↓
 Machine Code
       ↓
    Hardware
```

The important idea is:

```text
Same Java Source Code
        ↓
    Same Bytecode
        ↓
  ┌──────┼──────┐
  ↓      ↓      ↓
 JVM    JVM    JVM
  ↓      ↓      ↓
Windows Linux macOS
```

The JVM implementation is platform-specific, but the **bytecode is platform-neutral**.

> **Java is platform-independent because Java source code is compiled into platform-neutral bytecode that can run on different platforms through compatible JVM implementations.**

## Platform Independence vs Portability

| Concept                   | Meaning                                                                                                        |
| ------------------------- | -------------------------------------------------------------------------------------------------------------- |
| **Platform Independence** | Property of Java that allows the same bytecode to execute on different platforms using compatible JVMs         |
| **Portability**           | Ability to move/run the same application across different platforms with little or no source-code modification |

> **Platform independence is the property; portability is the resulting benefit.**

---

# 4. JVM — Java Virtual Machine

**JVM** executes Java bytecode.

```text
.class Bytecode
       ↓
      JVM
       ↓
  Machine Code
       ↓
      CPU
```

The JVM itself is **platform-specific**.

For example, a JVM implementation for Windows is different from one for Linux, but both can execute compatible Java bytecode.

### Main Responsibilities of JVM

* Executes bytecode
* Converts bytecode into machine-level instructions
* Provides runtime services
* Performs memory management and garbage collection
* Provides runtime security mechanisms

---

# 5. Compiler, Interpreter and JIT Compiler

## Compiler

A compiler translates source code into another form before execution.

For Java:

```text
.java
  ↓
javac
  ↓
.class (Bytecode)
```

The `javac` compiler is part of the JDK.

## Interpreter

The JVM can interpret bytecode and execute it.

Conceptually:

```text
Bytecode
   ↓
Interpreter
   ↓
Machine Instructions
```

## JIT Compiler

**JIT = Just-In-Time Compiler**

The JVM can identify frequently executed code and compile it into native machine code for faster execution.

```text
Bytecode
   ↓
  JVM
  ├── Interpreter
  └── JIT Compiler
          ↓
     Machine Code
```

Therefore, Java should not be described as simply "compiled" or simply "interpreted".

> Java source code is compiled to bytecode, and the JVM executes that bytecode using mechanisms such as interpretation and JIT compilation.

---

# 6. JRE — Java Runtime Environment

**JRE = JVM + Runtime Libraries**

JRE provides the environment required to **run** Java applications.

```text
JRE
├── JVM
└── Java Runtime Libraries
```

A JVM alone is not the complete runtime environment because Java programs also depend on runtime libraries.

---

# 7. JDK — Java Development Kit

**JDK** provides the tools required to **develop** Java applications.

Conceptually:

```text
JDK
├── JRE
│   ├── JVM
│   └── Runtime Libraries
│
└── Development Tools
    ├── javac
    ├── Debugging tools
    └── Other development utilities
```

### JVM vs JRE vs JDK

| Component | Purpose                          |
| --------- | -------------------------------- |
| **JVM**   | Executes Java bytecode           |
| **JRE**   | Provides runtime environment     |
| **JDK**   | Provides development environment |

### Relationship

```text
JDK
 ↓
JRE
 ↓
JVM
```

> **JDK is used to develop Java programs, while JRE provides the runtime environment in which Java programs execute.**

---

# 8. Complete Java Execution Flow

```text
Java Source Code (.java)
          ↓
       javac
          ↓
    Bytecode (.class)
          ↓
         JVM
          ↓
   Interpreter / JIT
          ↓
     Machine Code
          ↓
         CPU
          ↓
        Output
```

This architecture is the fundamental reason Java applications can be moved across platforms without recompiling the source code for every operating system, provided a compatible JVM is available.

---

# 9. Why Java is Simple

Java was designed to reduce several sources of complexity found in lower-level programming.

Important characteristics include:

* No C/C++-style explicit pointers
* No pointer arithmetic
* No multiple inheritance of classes
* Automatic memory management through Garbage Collection
* A relatively simple object-oriented programming model

> Java removes several low-level complexities while still providing powerful programming features.

---

# 10. Java Security

Java provides several mechanisms that contribute to a secure execution environment.

At a high level:

```text
Bytecode
   ↓
JVM Runtime Environment
   ↓
Security Checks / Controlled Execution
   ↓
Application Execution
```

The historical **sandbox model** is an important concept associated with Java's security architecture.

> Java's runtime environment provides controlled execution and safety mechanisms for Java programs.

---

# 11. Variables and Data Types

A variable is a named storage location used to hold a value.

Example:

```java
int x = 10;
```

Here:

* `int` → **Data Type**
* `x` → **Identifier / Variable Name**
* `10` → **Literal**
* `=` → Assignment operator

Conceptually:

```text
int x = 10;
│   │   │
│   │   └── Literal
│   └────── Identifier
└────────── Data Type
```

Java is a **statically typed language**.

This means the type of a variable is determined at compile time.

```java
int age = 23;
double price = 99.5;
char grade = 'A';
```

---

# 12. Data Types in Java

Java data types can broadly be divided into:

```text
Data Types
├── Primitive Types
└── Reference Types
```

## Primitive Data Types

Java has **8 primitive data types**:

| Type      |             Size | Example                |
| --------- | ---------------: | ---------------------- |
| `byte`    |           8 bits | `byte b = 10;`         |
| `short`   |          16 bits | `short s = 100;`       |
| `int`     |          32 bits | `int n = 1000;`        |
| `long`    |          64 bits | `long l = 100000L;`    |
| `float`   |          32 bits | `float f = 1.5f;`      |
| `double`  |          64 bits | `double d = 1.5;`      |
| `char`    |          16 bits | `char c = 'A';`        |
| `boolean` | Language-defined | `boolean flag = true;` |

> `boolean` does not have a fixed size specified in bits by the Java language specification in the same way as the integer and floating-point types.

## Reference Types

Reference types include:

* Classes
* Objects
* Arrays
* Interfaces
* `String`

Example:

```java
String name = "Yash";
int[] numbers = {1, 2, 3};
```

A reference variable stores a **reference to an object/array**, rather than directly storing the complete object as a primitive value does.

---

# 13. Integer Range

For a signed integer type containing `n` bits:

```text
Minimum = -2^(n-1)
Maximum =  2^(n-1) - 1
```

For example, `byte` has 8 bits:

```text
Range = -2^7 to 2^7 - 1
      = -128 to 127
```

So:

```java
byte b = 127;   // valid
byte c = -128;  // valid
```

---

# 14. How Java Represents Negative Integers

Java uses **two's complement representation** for signed integer types.

Example:

```text
+42
= 00101010
```

### Step 1 — Find 1's Complement

```text
00101010
    ↓
11010101
```

### Step 2 — Add 1

```text
11010101
+      1
---------
11010110
```

Therefore:

```text
-42 → 11010110
```

The **most significant bit (MSB)** indicates the sign for signed integer representations:

```text
MSB = 0 → non-negative
MSB = 1 → negative
```

To decode a negative two's-complement value, interpret the bit pattern accordingly.

---

# 15. Floating-Point Representation

Floating-point values such as `float` and `double` are represented using the IEEE 754 floating-point format.

A simplified view:

```text
┌────────┬──────────┬──────────────────────┐
│ Sign   │ Exponent │ Fraction / Mantissa  │
└────────┴──────────┴──────────────────────┘
```

For `float`:

```text
1 bit  → Sign
8 bits → Exponent
23 bits → Fraction
```

For `double`:

```text
1 bit  → Sign
11 bits → Exponent
52 bits → Fraction
```

The exponent uses a **bias**:

```text
float  → bias = 127
double → bias = 1023
```

The detailed binary conversion of floating-point numbers is useful for understanding how values are represented internally, but normally does not need to be memorized for everyday Java programming.

---

# 16. Type Conversion in Java

Type conversion means converting a value from one data type to another.

```text
Type Conversion
├── Implicit / Widening
└── Explicit / Narrowing
```

## 16.1 Implicit Conversion — Widening

When a value is converted from a smaller compatible numeric type to a wider type, Java can perform the conversion automatically.

```java
byte b = 24;
int i = b;

System.out.println(i);  // 24
```

Conceptually:

```text
byte → short → int → long → float → double
```

The destination type must be capable of representing the source value without the kind of narrowing loss associated with converting to a smaller integer type.

> Widening conversion is generally performed automatically.

---

## 16.2 Explicit Conversion — Narrowing

When converting from a wider type to a narrower type, explicit casting is required.

```java
int i = 300;
byte b = (byte) i;

System.out.println(b);
```

Why is casting required?

Because the destination type has a smaller range.

```text
int
 ↓
byte
```

Java does not automatically perform this potentially lossy conversion.

---

# 17. Truncation

When a floating-point value is explicitly converted to an integer type, the fractional part is discarded.

```java
float value = 16.25f;
int result = (int) value;

System.out.println(result);  // 16
```

The `.25` is removed.

> **Casting a floating-point value to an integer truncates the fractional part; it does not round to the nearest integer.**

---

# 18. Overflow During Narrowing

Narrowing conversion can produce a value that differs from the original value when the destination type cannot represent the original value.

Example:

```java
int i = 300;
byte b = (byte) i;

System.out.println(b);
```

A `byte` has only 8 bits and a range of:

```text
-128 to 127
```

Therefore, `300` cannot be represented directly as a `byte`. The narrowing conversion keeps the low-order bits, which results in a different value.

> Narrowing conversion can cause information loss.

---

# 19. Automatic Type Promotion

During arithmetic expressions, Java may automatically promote smaller numeric types.

For example:

```java
byte b = 50;
// b = b * 2;   // Compile-time error
```

The arithmetic expression promotes `b` to `int`, so the result of `b * 2` is an `int`.

Correct approach:

```java
byte b = 50;
b = (byte) (b * 2);
```

### Common Promotion Rules

* `byte`, `short`, and `char` are generally promoted to `int` in arithmetic expressions.
* If one operand is `long`, the expression is promoted to `long`.
* If one operand is `float`, the expression is promoted to `float`.
* If one operand is `double`, the expression is promoted to `double`.

Example:

```java
int a = 10;
double b = 2.5;

double result = a + b;
```

---

# 20. Java Operators

Operators perform operations on values and variables.

## Arithmetic Operators

```text
+   -   *   /   %
```

Compound assignment operators:

```text
+=   -=   *=   /=   %=
```

Example:

```java
int a = 10;
int b = 3;

System.out.println(a + b);  // 13
System.out.println(a % b);  // 1
```

---

## Unary Operators

```text
++   --   !   ~
```

Examples:

```java
int x = 5;

x++;
x--;

boolean flag = true;
System.out.println(!flag);
```

---

## Relational Operators

```text
>   <   >=   <=   ==   !=
```

These produce a boolean result.

```java
int a = 10;
int b = 20;

System.out.println(a < b);   // true
```

---

## Logical Operators

```text
&&   ||   !
```

Used with boolean expressions.

```java
int age = 20;

System.out.println(age >= 18 && age <= 60);
```

---

## Bitwise Operators

```text
&    |    ^    ~
<<   >>   >>>
```

They operate at the bit level.

| Operator | Meaning              |            |
| -------- | -------------------- | ---------- |
| `&`      | Bitwise AND          |            |
| `        | `                    | Bitwise OR |
| `^`      | Bitwise XOR          |            |
| `~`      | Bitwise NOT          |            |
| `<<`     | Left Shift           |            |
| `>>`     | Signed Right Shift   |            |
| `>>>`    | Unsigned Right Shift |            |

---

# 21. Useful Bitwise Operations

## Check Odd or Even

The least significant bit determines whether an integer is odd or even.

```java
if ((n & 1) == 1) {
    System.out.println("Odd");
} else {
    System.out.println("Even");
}
```

Why?

```text
Odd  → last bit = 1
Even → last bit = 0
```

Therefore:

```text
n & 1
```

checks the least significant bit.

---

## Find the Unique Element Using XOR

XOR has two important properties:

```text
x ^ x = 0
x ^ 0 = x
```

Therefore, if every element appears twice except one:

```java
int[] arr = {2, 3, 4, 3, 2};

int ans = 0;

for (int x : arr) {
    ans ^= x;
}

System.out.println(ans);  // 4
```

Why does this work?

```text
2 ^ 3 ^ 4 ^ 3 ^ 2

= (2 ^ 2) ^ (3 ^ 3) ^ 4

= 0 ^ 0 ^ 4

= 4
```

> XOR is useful for finding the unique element when every other element occurs exactly twice.

---

# 22. Operator Precedence

When an expression contains multiple operators, Java follows operator precedence rules.

A simplified order from higher to lower precedence is:

```text
()
 ↓
Unary operators
 ↓
* / %
 ↓
+ -
 ↓
Shift
 ↓
Relational
 ↓
Equality
 ↓
Bitwise
 ↓
Logical
 ↓
Assignment
```

For operators with the same precedence, associativity determines the evaluation direction.

> When in doubt, use parentheses to make the intended evaluation order explicit.

---

# 23. Flow of Control

Java programs control execution using three broad categories:

```text
Flow of Control
├── Selection
├── Iteration
└── Jump Statements
```

---

# 24. Selection Statements

Selection allows a program to choose between different execution paths.

Java provides:

* `if`
* `if-else`
* `if-else-if`
* `switch`

Example:

```java
int marks = 75;

if (marks >= 90) {
    System.out.println("A");
} else if (marks >= 60) {
    System.out.println("B");
} else {
    System.out.println("C");
}
```

### Nested `if`

An `if` statement can be placed inside another `if`.

```java
if (condition1) {
    if (condition2) {
        // statements
    }
}
```

---

# 25. Switch Statement

`switch` is useful when one expression needs to be compared against multiple possible cases.

```java
int day = 2;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    default:
        System.out.println("Invalid day");
}
```

### `break`

`break` terminates the switch statement at that point.

Without an appropriate `break`, execution may continue into subsequent cases (**fall-through**).

---

# 26. Iteration Statements

Iteration is used when a block of code needs to execute repeatedly.

Java provides:

* `while`
* `do-while`
* `for`

The main difference is **when the condition is checked**.

### `while`

The condition is checked before each iteration.

```java
while (condition) {
    // statements
}
```

### `do-while`

The body executes at least once because the condition is checked after the body.

```java
do {
    // statements
} while (condition);
```

### `for`

Useful when initialization, condition, and update can be expressed together.

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

---

# 27. Jump Statements

Important jump statements include:

```text
break
continue
```

## `break`

Immediately terminates the nearest applicable loop or switch.

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;
    }

    System.out.println(i);
}
```

## `continue`

Skips the remaining statements of the current iteration and proceeds to the next iteration.

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
4
5
```

> `break` exits the loop; `continue` skips the current iteration.

---

# 28. Quick Revision

## Java Execution

```text
Java Source
    ↓
   javac
    ↓
Bytecode (.class)
    ↓
   JVM
    ├── Interpreter
    └── JIT Compiler
    ↓
Machine Code
    ↓
Hardware
```

## JDK, JRE and JVM

```text
JDK
 ↓
JRE
 ↓
JVM
```

## Data Types

```text
Data Types
├── Primitive
│   ├── byte
│   ├── short
│   ├── int
│   ├── long
│   ├── float
│   ├── double
│   ├── char
│   └── boolean
│
└── Reference
    ├── String
    ├── Arrays
    ├── Classes
    ├── Objects
    └── Interfaces
```

## Type Conversion

```text
Type Conversion
├── Widening → usually automatic
└── Narrowing → explicit casting
```

## Flow of Control

```text
Flow of Control
├── Selection
│   ├── if
│   ├── if-else
│   ├── if-else-if
│   └── switch
│
├── Iteration
│   ├── while
│   ├── do-while
│   └── for
│
└── Jump
    ├── break
    └── continue
```

> **Key Takeaways**
>
> * Java source code is compiled into platform-neutral bytecode.
> * JVM is platform-specific and executes bytecode.
> * JDK is used for development; JRE provides the runtime environment.
> * Java uses static typing and has 8 primitive data types.
> * Widening conversion is generally automatic; narrowing requires explicit casting.
> * Arithmetic expressions can promote `byte`, `short`, and `char` to `int`.
> * Bitwise operators work at the bit level and are especially useful in DSA.
> * Java provides selection, iteration, and jump statements for controlling program flow.
