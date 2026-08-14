# Java Arrays

Arrays are one of the most fundamental data structures in Java. They allow us to store multiple values of the **same data type** under a single variable name.

This section covers:

* 1-D Arrays
* Array declaration and initialization
* Array indexing
* `length`
* 2-D Arrays
* Jagged Arrays
* Array memory representation
* Random Access
* Row-Major and Column-Major formulas
* Array traversal
* Common interview questions

---

## 1. What is an Array?

An **array** is a fixed-size data structure used to store multiple values of the **same type**.

Instead of creating separate variables:

```java
int a = 10;
int b = 20;
int c = 30;
```

we can use:

```java
int[] arr = {10, 20, 30};
```

Conceptually:

```text
arr
 ↓
┌─────┬─────┬─────┐
│ 10  │ 20  │ 30  │
└─────┴─────┴─────┘
   0     1     2
```

The position of an element is called its index.

Java array indexing starts from `0`.

Therefore:

```text
arr[0] → first element
arr[1] → second element
arr[2] → third element
```

---

## 2. Why Do We Need Arrays?

Suppose we need to store marks of 100 students.

Without an array:

```java
int marks1;
int marks2;
int marks3;
// ...
int marks100;
```

This is difficult to manage.

With an array:

```java
int[] marks = new int[100];
```

Now all 100 values can be accessed using one variable:

```text
marks[0]
marks[1]
marks[2]
...
marks[99]
```

### Advantages

* Stores multiple values using one variable.
* Easy to traverse using loops.
* Provides constant-time indexed access.
* Useful for storing collections of fixed-size data.
* Forms the foundation for many DSA problems.

---

## 3. Array Declaration

The general syntax is:

```java
dataType[] arrayName;
```

Example:

```java
int[] rollNumbers;
```

Here:

```text
int          → Data Type
[]           → Array notation
rollNumbers  → Reference variable
```

An array can be created using `new`:

```java
int[] rollNumbers = new int[3];
```

This creates an array capable of storing 3 integers.

Conceptually:

```text
rollNumbers
     │
     ↓
┌───────┬───────┬───────┐
│       │       │       │
└───────┴───────┴───────┘
   0       1       2
```

---

## 4. Array Initialization

An array can be initialized directly:

```java
int[] numbers = {10, 20, 30};
```

Or using `new`:

```java
int[] numbers = new int[3];

numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
```

For an `int` array, elements are initially initialized to `0`.

```java
int[] arr = new int[3];
```

Conceptually:

```text
┌─────┬─────┬─────┐
│  0  │  0  │  0  │
└─────┴─────┴─────┘
   0     1     2
```

---

## 5. Array Indexing

Every array element is accessed using its index.

```java
int[] arr = {101, 102, 103};

System.out.println(arr[0]); // 101
System.out.println(arr[1]); // 102
System.out.println(arr[2]); // 103
```

Conceptually:

```text
Index:    0      1      2
          ↓      ↓      ↓
        ┌─────┬─────┬─────┐
arr  →  │ 101 │ 102 │ 103 │
        └─────┴─────┴─────┘
```

### Important

The first element is always at index `0`.

For an array of size `n`:

```text
Valid indexes:

0 → n - 1
```

Accessing an invalid index causes:

```text
ArrayIndexOutOfBoundsException
```

Example:

```java
int[] arr = new int[3];

System.out.println(arr[3]); // Error at runtime
```

Valid indexes are only:

```text
0, 1, 2
```

---

## 6. Array Length

Java arrays provide the `length` property to determine their size.

```java
int[] arr = {10, 20, 30, 40};

System.out.println(arr.length);
```

Output:

```text
4
```

### Important

For arrays:

```java
arr.length
```

is a property, not a method.

Correct:

```java
arr.length
```

Incorrect:

```java
arr.length()
```

---

## 7. Traversing a 1-D Array

The most common way to traverse an array is using a `for` loop.

```java
int[] arr = {10, 20, 30, 40};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

Flow:

```text
i = 0
 ↓
arr[0]
 ↓
i++
 ↓
arr[1]
 ↓
i++
 ↓
...
 ↓
i < arr.length
```

### Enhanced for-loop

Java also provides the enhanced `for` loop:

```java
for (int value : arr) {
    System.out.println(value);
}
```

Use the normal `for` loop when the index is required.

Use the enhanced `for` loop when only the values are needed.

---

## 8. How Arrays Are Represented Conceptually in Memory

Consider:

```java
int[] arr = new int[5];
```

Conceptually, the array contains five integer elements:

```text
arr
 │
 ↓
┌────┬────┬────┬────┬────┐
│  0 │  0 │  0 │  0 │  0 │
└────┴────┴────┴────┴────┘
  0    1    2    3    4
```

For a primitive array such as `int[]`, the elements contain primitive values.

The variable `arr` is a reference variable that refers to the array object.

```text
Reference Variable          Array Object

      arr
       │
       │ reference
       ↓
┌───────────────────────────────┐
│   0   │   0   │   0   │ ...   │
└───────────────────────────────┘
```

Java arrays are objects, and an array variable stores a reference to the array object.

---

## 9. Array and Memory: Important Clarification

Arrays are commonly described in data structures as having elements stored in a sequential/contiguous layout, which enables efficient indexed access.

However, Java does not expose physical memory addresses to programmers, and the Java Language Specification does not require arrays to be physically contiguous in memory.

Therefore, address formulas should be understood as conceptual array-layout formulas, not as a way to obtain an actual JVM memory address.

---

## 10. Random Access

One of the biggest advantages of arrays is random access.

If we know the index of an element, we can directly access it:

```java
arr[i]
```

We do not need to traverse all previous elements.

Therefore:

```text
Access by index → O(1)
```

For a conceptual array layout:

```text
Address of arr[i]

= Base Address + (Index × Size of each element)
```

Therefore:

```text
Address(arr[i])
=
Base Address + (i × DataTypeSize)
```

### Example

Suppose:

```text
Base Address = 100
Data Type = int
Size of int = 4 bytes
Index = 3
```

Then:

```text
Address(arr[3])
= 100 + (3 × 4)
= 112
```

Conceptually:

```text
Base Address
     ↓
100    104    108    112
 ↓      ↓      ↓      ↓
arr[0] arr[1] arr[2] arr[3]
```

Random access is possible because the location of an indexed element can be calculated directly.

---

## 11. Why Array Access is O(1)

For an array:

```java
arr[i]
```

the required index is directly used to determine the element's position.

The number of elements before `i` does not affect the number of operations needed to access `arr[i]`.

Therefore:

```text
Access Time = O(1)
```

This is called constant-time random access.

---

## 12. 2-D Arrays

A 2-D array can be used to represent data in rows and columns.

Example:

```java
int[][] marks = new int[3][3];
```

Conceptually:

```text
             Columns
          0     1     2

       ┌─────┬─────┬─────┐
Row 0  │     │     │     │
       ├─────┼─────┼─────┤
Row 1  │     │     │     │
       ├─────┼─────┼─────┤
Row 2  │     │     │     │
       └─────┴─────┴─────┘
```

An element is accessed using:

```java
marks[row][column]
```

Example:

```java
marks[0][1]
```

means:

```text
row = 0
column = 1
```

---

## 13. Example of a 2-D Array

Consider:

```java
int[][] marks = {
    {50, 30, 90},
    {60, 40, 80},
    {70, 50, 70}
};
```

Representation:

```text
          Maths English Physics
          0     1       2

Row 0 →  [50]  [30]    [90]
Row 1 →  [60]  [40]    [80]
Row 2 →  [70]  [50]    [70]
```

Accessing:

```java
marks[0][0] // 50
marks[1][2] // 80
marks[2][1] // 50
```

---

## 14. Java 2-D Arrays are Arrays of Arrays

A very important Java-specific concept:

```java
int[][] arr = new int[3][3];
```

is conceptually an array whose elements are references to other arrays.

```text
arr
 │
 ├──→ Row 0
 ├──→ Row 1
 └──→ Row 2
```

Each row is itself an array.

This is why Java supports arrays with different row lengths.

---

## 15. Jagged Array / 2-D Array of Different Sizes

A jagged array is a 2-D array in which different rows can have different lengths.

Example:

```java
int[][] marks = new int[3][];

marks[0] = new int[2];
marks[1] = new int[3];
marks[2] = new int[4];
```

Conceptually:

```text
marks
 │
 ├──→ [ ][ ]
 │
 ├──→ [ ][ ][ ]
 │
 └──→ [ ][ ][ ][ ]
```

So:

```text
marks[0].length = 2
marks[1].length = 3
marks[2].length = 4
```

### Important

When working with a jagged array, do not assume that every row has the same number of columns.

Use:

```java
marks[row].length
```

instead of a fixed column count.

---

## 16. Traversing a 2-D Array

For a regular rectangular 2-D array:

```java
int[][] marks = new int[3][3];

for (int row = 0; row < marks.length; row++) {

    for (int col = 0; col < marks[row].length; col++) {

        marks[row][col] = 10;
    }
}
```

The outer loop controls the rows.

The inner loop controls the columns.

```text
Outer Loop
    ↓
  Rows
    ↓
Inner Loop
    ↓
 Columns
```

### Better approach

Instead of hard-coding:

```text
row < 3
col < 3
```

prefer:

```java
row < marks.length
col < marks[row].length
```

This works for both rectangular and jagged arrays.

---

## 17. Traversing a 2-D Array with Input

Example:

```java
Scanner sc = new Scanner(System.in);

int[][] marks = new int[3][3];

for (int row = 0; row < marks.length; row++) {

    for (int col = 0; col < marks[row].length; col++) {

        marks[row][col] = sc.nextInt();
    }
}
```

The same structure can be used for printing:

```java
for (int row = 0; row < marks.length; row++) {

    for (int col = 0; col < marks[row].length; col++) {

        System.out.print(marks[row][col] + " ");
    }

    System.out.println();
}
```

---

## 18. 2-D Array Memory Representation

For a traditional rectangular row-major layout, the conceptual address formula is:

```text
Address(A[i][j])
=
Base Address
+
((i × NumberOfColumns) + j) × DataTypeSize
```

Where:

```text
i = Row Index
j = Column Index
N = Number of Columns
DataTypeSize = Size of one element in bytes
```

Therefore:

```text
Address(A[i][j])
=
BA + ((i × N) + j) × DataTypeSize
```

---

## 19. Row-Major Order

In row-major order, elements of each row are stored sequentially before moving to the next row.

For:

```text
[ 1  2  3 ]
[ 4  5  6 ]
[ 7  8  9 ]
```

the conceptual order is:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9
```

Formula:

```text
Address(A[i][j])
=
BA + ((i × N) + j) × DataTypeSize
```

Where:

```text
N = Number of Columns
```

### Memory Trick

```text
Row-Major
= Row × Columns + Column

(i × N) + j
```

---

## 20. Column-Major Order

In column-major order, elements of each column are stored sequentially before moving to the next column.

For:

```text
[ 1  2  3 ]
[ 4  5  6 ]
[ 7  8  9 ]
```

the conceptual order is:

```text
1 → 4 → 7 → 2 → 5 → 8 → 3 → 6 → 9
```

Formula:

```text
Address(A[i][j])
=
BA + ((j × M) + i) × DataTypeSize
```

Where:

```text
M = Number of Rows
```

### Memory Trick

```text
Column-Major
= Column × Rows + Row

(j × M) + i
```

---

## 21. Row-Major vs Column-Major

| Feature           | Row-Major                | Column-Major             |
| ----------------- | ------------------------ | ------------------------ |
| Primary traversal | Row by row               | Column by column         |
| Formula           | `BA + ((i × N) + j) × W` | `BA + ((j × M) + i) × W` |
| N                 | Number of columns        | —                        |
| M                 | —                        | Number of rows           |
| Memory order      | Complete row first       | Complete column first    |

Where:

```text
BA = Base Address
W  = Data Type Size
i  = Row Index
j  = Column Index
```

```text
Row-Major → Row × Columns + Column

Column-Major → Column × Rows + Row
```

---

## 22. Important Difference: Java 2-D Arrays vs Traditional Matrix Layout

The row-major and column-major formulas are useful for understanding 2-D array memory layout in data structures and computer organization.

However, Java's:

```java
int[][]
```

is an array of arrays.

It does not guarantee that all rows form one physically contiguous memory block.

Therefore, the direct formula:

```text
BA + ((i × N) + j) × W
```

should be treated as a conceptual row-major formula, not an actual JVM memory-address calculation for `int[][]`.

---

## 23. Time Complexity of Common Array Operations

| Operation             | Time Complexity |
| --------------------- | --------------- |
| Access by index       | `O(1)`          |
| Update by index       | `O(1)`          |
| Linear Search         | `O(n)`          |
| Traversal             | `O(n)`          |
| Insert at beginning   | `O(n)`          |
| Insert at middle      | `O(n)`          |
| Delete from beginning | `O(n)`          |
| Delete from middle    | `O(n)`          |

A normal Java array has fixed size. If resizing is required, a new array must be created and elements copied.

---

## 24. Advantages of Arrays

* Simple data structure
* Fast indexed access
* Good cache locality in common implementations
* Easy traversal
* Useful for storing homogeneous data
* Forms the basis of many other data structures and algorithms

---

## 25. Limitations of Arrays

* Fixed length after creation
* Stores elements of a single array type
* Insertion/deletion in the middle can be expensive
* Requires careful index management
* Resizing a normal Java array requires creating another array

When dynamic resizing is required, Java provides collection classes such as:

```java
ArrayList<Integer>
```

---

## 26. Arrays vs ArrayList

| Feature             | Array                          | ArrayList                  |
| ------------------- | ------------------------------ | -------------------------- |
| Size                | Fixed                          | Dynamically resizable      |
| Stores              | Primitive types and references | Objects / wrapper types    |
| Access              | `O(1)`                         | `O(1)` average             |
| Insertion in middle | `O(n)`                         | `O(n)`                     |
| Syntax              | `int[] arr`                    | `ArrayList<Integer>`       |
| Primitive storage   | Yes                            | Uses wrapper types         |
| Part of             | Java language                  | Java Collections Framework |

Example:

```java
int[] arr = new int[5];
```

vs.

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

## 27. Common Mistakes

### Mistake 1: Using `length()`

Wrong:

```java
arr.length();
```

Correct:

```java
arr.length;
```

---

### Mistake 2: Starting from index 1

Wrong:

```java
for (int i = 1; i <= arr.length; i++)
```

Correct:

```java
for (int i = 0; i < arr.length; i++)
```

---

### Mistake 3: Using fixed column size for a jagged array

Avoid:

```java
for (int col = 0; col < 3; col++)
```

Prefer:

```java
for (int col = 0; col < arr[row].length; col++)
```

---

### Mistake 4: Confusing `arr.length` and `arr[row].length`

For:

```java
int[][] arr = new int[3][5];
```

```text
arr.length       → 3 rows
arr[0].length    → 5 columns
```

---

### Mistake 5: Assuming Java 2-D arrays are always one flat block

Java represents:

```java
int[][]
```

as an array of arrays.

Rows can have different lengths.

---

# 28. Interview Questions

## Q1. What is an array?

An array is a fixed-size data structure that stores multiple values of the same array type and allows indexed access to its elements.

---

## Q2. Why does array indexing start from 0?

The index represents an offset from the first element.

Conceptually:

```text
Address(arr[i])
=
Base Address + (i × Element Size)
```

For the first element:

```text
i = 0
```

so its offset is zero.

Therefore, indexing naturally begins at `0`.

---

## Q3. Why is array access O(1)?

Because the location of an indexed element can be calculated directly using its index.

```text
Address(arr[i])
=
Base Address + (i × Element Size)
```

The number of other elements does not affect the access operation.

Therefore:

```text
arr[i] → O(1)
```

---

## Q4. What is the difference between `arr.length` and `arr.length()`?

For Java arrays:

```java
arr.length
```

is a property.

It is not a method.

`length()` is not valid for arrays.

---

## Q5. What happens if we access an invalid array index?

Example:

```java
int[] arr = new int[3];

System.out.println(arr[3]);
```

This causes:

```text
ArrayIndexOutOfBoundsException
```

because valid indexes are:

```text
0, 1, 2
```

---

## Q6. Can the size of a Java array be changed after creation?

No.

Once an array is created:

```java
int[] arr = new int[5];
```

its length is fixed.

If more space is required, a new array must be created.

---

## Q7. What is a 2-D array in Java?

A 2-D array is an array whose elements are themselves arrays.

Example:

```java
int[][] arr = new int[3][4];
```

Conceptually:

```text
arr
 ├──→ row 0
 ├──→ row 1
 └──→ row 2
```

---

## Q8. Is a Java 2-D array actually a matrix?

Not necessarily.

A Java 2-D array is an array of arrays.

It can represent a rectangular matrix:

```java
int[][] arr = new int[3][3];
```

but it can also represent a jagged structure:

```java
int[][] arr = new int[3][];

arr[0] = new int[2];
arr[1] = new int[4];
arr[2] = new int[3];
```

---

## Q9. What is a jagged array?

A jagged array is a 2-D array where different rows have different lengths.

Example:

```java
int[][] arr = {
    {1, 2},
    {3, 4, 5},
    {6, 7, 8, 9}
};
```

Here:

```text
arr[0].length = 2
arr[1].length = 3
arr[2].length = 4
```

---

## Q10. What is the difference between `arr.length` and `arr[i].length` in a 2-D array?

For:

```java
int[][] arr = new int[3][5];
```

```text
arr.length
```

gives the number of rows:

```text
3
```

while:

```text
arr[i].length
```

gives the length of row `i`:

```text
5
```

For jagged arrays, `arr[i].length` may be different for every row.

---

## Q11. What is random access?

Random access means accessing an element directly using its index without traversing previous elements.

Example:

```java
arr[500];
```

For an array:

```text
Access = O(1)
```

---

## Q12. What is the address formula for a 1-D array?

Conceptually:

```text
Address(arr[i])
=
Base Address + (i × DataTypeSize)
```

Where:

```text
i            = Index
DataTypeSize = Size of one element in bytes
```

---

## Q13. What is the row-major address formula?

For a rectangular 2-D array:

```text
Address(A[i][j])
=
BA + ((i × N) + j) × W
```

Where:

```text
BA = Base Address
i  = Row Index
j  = Column Index
N  = Number of Columns
W  = Size of one element
```

Memory trick:

```text
Row × Columns + Column
```

---

## Q14. What is the column-major address formula?

Conceptually:

```text
Address(A[i][j])
=
BA + ((j × M) + i) × W
```

Where:

```text
M = Number of Rows
```

Memory trick:

```text
Column × Rows + Row
```

---

## Q15. Does Java use row-major or column-major memory layout for `int[][]`?

Java `int[][]` is an array of arrays, not a single flat 2-D array whose storage order is specified as row-major or column-major.

Therefore, we should not claim that Java's `int[][]` has a guaranteed row-major physical memory layout.

The row-major formula is still useful as a conceptual DSA/computer-organization formula.

---

## Q16. Why are arrays called homogeneous data structures?

Because the elements of an array have the same array component type.

Example:

```java
int[] arr = {10, 20, 30};
```

All elements are `int`.

Similarly:

```java
double[] arr;
```

stores `double` values.

---

## Q17. Can an array store objects?

Yes.

Example:

```java
Student[] students = new Student[10];
```

The array stores references to `Student` objects.

---

## Q18. Are Java arrays objects?

Yes.

Arrays are objects in Java.

Therefore:

```java
int[] arr = new int[5];
```

creates an array object, and `arr` stores a reference to that object.

---

## Q19. Where is a Java array stored: Stack or Heap?

The array object is created on the heap.

The array variable itself is a reference variable, and depending on where the variable is declared, that reference may be stored as part of a stack frame, an object, or another runtime structure.

The important distinction is:

```text
Reference
   ↓
Heap Array Object
```

---

## Q20. What is the time complexity of accessing an array element?

```java
arr[i]
```

takes:

```text
O(1)
```

because indexed access is direct.

---

## Q21. What is the time complexity of searching an unsorted array?

For linear search:

```text
Best Case  → O(1)
Worst Case → O(n)
Average    → O(n)
```

Example:

```java
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        return i;
    }
}
```

---

## Q22. Why is insertion at the beginning of an array O(n)?

Suppose:

```text
[10, 20, 30, 40]
```

and we want to insert `5` at index `0`.

Existing elements need to be shifted:

```text
[10, 20, 30, 40]
 ↓   ↓   ↓   ↓
shift right
 ↓   ↓   ↓   ↓
[5, 10, 20, 30, 40]
```

Multiple elements may need to move.

Therefore:

```text
Insertion at beginning → O(n)
```

---

## Q23. Why is deletion from the beginning O(n)?

After deleting the first element, the remaining elements may need to be shifted left.

```text
[10, 20, 30, 40]
 ↓
delete 10

[20, 30, 40]
```

The shifting operation can involve many elements.

Therefore:

```text
Deletion from beginning → O(n)
```

---

## Q24. Array vs Linked List — which has faster random access?

Array.

Array:

```text
Access by index → O(1)
```

Linked List:

```text
Access by index → O(n)
```

A linked list generally needs to traverse nodes to reach a particular position.

---

## Q25. Array vs ArrayList — what is the main difference?

The biggest difference is size management.

```text
Array
→ Fixed size
```

```text
ArrayList
→ Dynamically resizable
```

Example:

```java
int[] arr = new int[5];
```

vs.

```java
ArrayList<Integer> list = new ArrayList<>();
```
