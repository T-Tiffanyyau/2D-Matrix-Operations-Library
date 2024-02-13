# 2D Matrix Operations Library
## Description
This Java library provides a simple yet effective implementation for 2D matrix operations. Developed by Daniel Kopta and Tiffany Yau, it offers basic functionalities such as matrix multiplication, addition, and transposition, making it suitable for educational purposes or small-scale projects requiring matrix operations.

## Installation
Ensure you have Java installed on your system.
Download the Matrix.java file from the repository.
Include it in your Java project.
## Usage
To use this library, create an instance of the Matrix class with a 2D array. Here's an example:

```
int[][] data = {{1, 2}, {3, 4}};
Matrix matrix = new Matrix(data);
```
### Operations
Multiplication: matrix.times(otherMatrix)
Addition: matrix.plus(otherMatrix)
Transpose: matrix.transpose()
### Example
```
Matrix matrix1 = new Matrix(new int[][]{{1, 2}, {3, 4}});
Matrix matrix2 = new Matrix(new int[][]{{5, 6}, {7, 8}});

// Multiplication
Matrix product = matrix1.times(matrix2);

// Addition
Matrix sum = matrix1.plus(matrix2);

// Transpose
Matrix transpose = matrix1.transpose();
```

Last updated: August 18, 2021