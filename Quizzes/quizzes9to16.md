## Task #9: Create a class that receives a 2D array and returns the average across columns and across rows.

```java
public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public double[] rowAverage() {
        double[] averages = new double[matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            int sum = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
            averages[row] = (double) sum / matrix[row].length;
        }
        return averages;
    }

    public double[] columnAverage() {
        double[] averages = new double[matrix[0].length];

        for (int col = 0; col < matrix[0].length; col++) {
            int sum = 0;
            for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][col];
            }
            averages[col] = (double) sum / matrix.length;
        }
        return averages;
    }

    public void show(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }//this is for  another quizzes: .show()
}
```

### Proof of Work:
<img width="1085" height="866" alt="Screenshot 2026-10-14 at 20 02 01" src="https://github.com/user-attachments/assets/1adfa085-f881-4e3c-932b-2f95df6c1216" />

## Task #10: Create a class that receives a 2D array and a integer, returns the array scaled by the constant:

```java
public int[][] scale(int scale) {
    int[][] result = new int[matrix.length][];

    for (int row = 0; row < matrix.length; row++) {
        result[row] = new int[matrix[row].length];

        for (int col = 0; col < matrix[row].length; col++) {
            result[row][col] = matrix[row][col] * scale;
        }
    }

    return result;
}

public void show(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
```

### Proof of Work:
<img width="1085" height="866" alt="Screenshot 2026-10-14 at 20 10 51" src="https://github.com/user-attachments/assets/8a39e6f3-0b0c-4abe-a866-c46cd2d0dd01" />

## Task #11: Create a class that receives a constant n and returns a identity matrix of size n x n :

```java
private int size;
public Matrix(int size) {
    this.size = size;
}

public int[][] identity() {
    int[][] identityMatrix = new int[size][size];

    for (int row = 0; row < size; row++) {
        for (int col = 0; col < size; col++) {
            if (row == col) {
                identityMatrix[row][col] = 1;
            }
        }
    }

    return identityMatrix;
}
```

### Proof of Work:
<img width="1090" height="900" alt="Screenshot 2026-10-15 at 07 57 47" src="https://github.com/user-attachments/assets/4ba90db5-b5f7-4234-8942-0e12b89f7da4" />

## Task #12: Create a method that receives a matrix of size n x m: the output is a 1D “vectorized” version of the input.

```java
public int[] vectorize() {
    int[] result = new int[matrix.length * matrix[0].length];

    int index = 0;

    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[row].length; col++) {
            result[index] = matrix[row][col];
            index++;
        }
    }

    return result;
}
```
### Proof of Work:
<img width="1090" height="900" alt="Screenshot 2026-10-15 at 08 13 43" src="https://github.com/user-attachments/assets/953c7137-f552-4b7e-aa25-1d691a156f22" />

## Task #13: Create a method that receives a 1D array and builds a square matrix, use zero-padded.

```java
private int[] numbers;

public Matrix(int[] numbers) {
    this.numbers = numbers;
}

public int[][] toMatrix() {
    int n = 1;

    while (n * n < numbers.length) {
        n++;
    }

    int[][] result = new int[n][n];
    int index = 0;

    for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
            if (index < numbers.length) {
                result[row][col] = numbers[index];
                index++;
            }
        }
    }

    return result;
}
```

### Proof of Work:
<img width="1090" height="900" alt="Screenshot 2026-10-15 at 08 11 05" src="https://github.com/user-attachments/assets/daef4bd9-4afc-41d3-91cc-a97bfa0d4d16" />

## Task #14: Create a method that creates a ascending diagonal matrix

```.java
public Matrix() {
}// No-argument constructor for Task 14 (creates a Matrix object without specifying its size)
public int[][] diagonal(int size) {
    int[][] result = new int[size][size];

    for (int row = 0; row < size; row++) {
        for (int col = 0; col < size; col++) {
            if (row == col) {
                result[row][col] = row + 1;
            }
        }
    }

    return result;
}
```

## Proof of Work:
<img width="1090" height="900" alt="Screenshot 2026-10-15 at 08 17 31" src="https://github.com/user-attachments/assets/5b818198-69da-4a6a-97ea-d0b18bcfdb73" />


## Task #15: Create a method that calculates the error in representation of a ADC with a range 0-5v and resolution 6 bits for and voltage measured from an analog input.

