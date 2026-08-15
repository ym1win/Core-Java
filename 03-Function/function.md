# ☕ Java Functions


---

## 📌 Topics Covered

* [Functions / Methods](#-functions--methods)
* [Function Calling](#-function-calling)
* [Function Overloading](#-function-overloading)
* [Function Chaining](#-function-chaining)
* [Recursion](#-recursion)
* [Key Takeaways](#-key-takeaways)

---

## 🔹 Functions / Methods

A **function (method)** is a reusable block of code that performs a specific task.

Instead of writing the same logic multiple times, we can define it once inside a method and call it whenever required.

### Basic Syntax

```java
static returnType functionName(parameters) {
    // code
    return value;
}
```

### Example

```java
static int sum(int a, int b) {
    int result = a + b;
    return result;
}
```

Here:

| Part            | Meaning                                         |
| --------------- | ----------------------------------------------- |
| `static`        | Method can be called without creating an object |
| `int`           | Return type of the method                       |
| `sum`           | Method name                                     |
| `int a, int b`  | Parameters                                      |
| `return result` | Value returned by the method                    |

---

## 🔹 Function Calling

A method is executed when we **call** it.

```java
public static void main(String[] args) {

    int i = 4;
    int j = 4;

    int result = sum(i, j);

    System.out.println(result);
}
```

### How it works

```text
main()
   ↓
sum(i, j)
   ↓
a + b
   ↓
result
   ↓
return result
```

When we call:

```java
sum(i, j);
```

* `sum` → function name
* `i, j` → arguments
* Arguments provide values to the parameters of the function.

---

# 🔥 Function Overloading

**Function/Method Overloading** means having multiple methods with the **same name** but **different parameter lists**.

The difference can be based on:

1. Number of parameters
2. Data type of parameters
3. Order of parameters

### Example 1 — Different Number of Parameters

```java
static int sum(int a, int b) {
    return a + b;
}

static int sum(int a, int b, int c) {
    return a + b + c;
}
```

Both methods have the same name:

```java
sum()
```

but different numbers of parameters.

---

### Example 2 — Different Data Types

```java
static int sum(int a, int b) {
    return a + b;
}

static int sum(double a, double b) {
    return (int) (a + b);
}
```

The parameter types are different:

```text
int, int
double, double
```

---

### Example 3 — Different Order of Parameters

```java
static void greet(String name, int age) {
    System.out.println("Hi " + name + " Age " + age);
}

static void greet(int age, String name) {
    System.out.println("Hi " + name + " Age " + age);
}
```

The parameter order is different:

```text
String, int
int, String
```

---

## ⚡ Important Rule

> **Changing only the return type does NOT create method overloading.**

❌ Invalid example:

```java
static int sum(int a, int b) {
    return a + b;
}

static double sum(int a, int b) {
    return a + b;
}
```

This is **not valid method overloading** because the parameter list is exactly the same.

---

## 🧠 Compile-Time Polymorphism

Method overloading is an example of **compile-time polymorphism**.

The compiler determines which overloaded method should be called **at compile time** based on the arguments passed.

```text
                 sum()
                  │
        ┌─────────┼─────────┐
        ↓         ↓         ↓
    2 params   3 params   double params
```

---

# 🔗 Function Chaining

**Function chaining** refers to a sequence where one method calls another method, which may call another method, and so on.

### Example

```java
static void A() {
    B();
}

static void B() {
    C();
}

static void C() {
    System.out.println("Inside C");
}

public static void main(String[] args) {
    A();
}
```

### Execution Flow

```text
main()
  ↓
 A()
  ↓
 B()
  ↓
 C()
```

The control flow moves from one method to another.

### Why is it called chaining?

Because the execution forms a chain:

```text
Method A → Method B → Method C
```

---

# 🔄 Recursion

**Recursion** is a technique where a function calls **itself**.

### Basic Structure

```java
void function() {

    // Base Case

    function(); // Recursive Call
}
```

A recursive function generally requires two important parts:

### 1. Base Case

The **base case** is the condition that stops the recursion.

Without a proper base case, the function may continue calling itself indefinitely.

### 2. Recursive Call

The function calls itself with a modified value.

---

## Example: Print Numbers Using Recursion

```java
static void printNum(int n) {

    if (n == 0) {
        return;
    }

    printNum(n - 1);

    System.out.println(n);
}
```

Call:

```java
printNum(5);
```

### Execution

```text
printNum(5)
    ↓
printNum(4)
    ↓
printNum(3)
    ↓
printNum(2)
    ↓
printNum(1)
    ↓
printNum(0)
    ↓
   return
```

After reaching the base case, the previous function calls start completing.

### Output

```text
1
2
3
4
5
```

---

## 🧩 Recursion Flow

```text
printNum(5)
     ↓
printNum(4)
     ↓
printNum(3)
     ↓
printNum(2)
     ↓
printNum(1)
     ↓
printNum(0)  ← Base Case
     ↑
    return
     ↑
    1
     ↑
    2
     ↑
    3
     ↑
    4
     ↑
    5
```

This happens because the recursive calls are stored in the **call stack**.

---

# 📊 Function Overloading vs Recursion

| Feature           | Function Overloading                         | Recursion                                |
| ----------------- | -------------------------------------------- | ---------------------------------------- |
| Meaning           | Same method name with different parameters   | Method calls itself                      |
| Main purpose      | Multiple ways to perform a similar operation | Solve problems using repeated self-calls |
| Polymorphism      | Compile-time polymorphism                    | Not itself a form of polymorphism        |
| Important concept | Parameter list                               | Base case + recursive call               |
| Example           | `sum(int,int)` and `sum(int,int,int)`        | `printNum(n-1)`                          |

---

# 📝 Key Takeaways

* A **function/method** is a reusable block of code.
* A method can accept **parameters** and may return a value.
* Values passed during a method call are called **arguments**.
* **Method overloading** allows multiple methods with the same name but different parameter lists.
* Overloading can be based on:

    * Number of parameters
    * Data type of parameters
    * Order of parameters
* Changing **only the return type** does not cause method overloading.
* Method overloading is an example of **compile-time polymorphism**.
* **Function chaining** occurs when methods call other methods in sequence.
* **Recursion** occurs when a method calls itself.
* A recursive method should have a proper **base case** to terminate.
* Recursive calls are managed using the **call stack**.

---

## 🚀 Quick Revision

```text
FUNCTION
   │
   ├── Reusable block of code
   │
   ├── Parameters
   │
   ├── Return Type
   │
   └── Function Calling
          │
          ├── Function Overloading
          │      ├── Different number of parameters
          │      ├── Different data types
          │      └── Different parameter order
          │
          ├── Function Chaining
          │      └── A() → B() → C()
          │
          └── Recursion
                 ├── Base Case
                 └── Recursive Call
```

---


