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
<img width="494" height="346" alt="Screenshot 2026-10-15 at 08 30 50" src="https://github.com/user-attachments/assets/881429cd-6849-426e-94db-b9c5a4f7ed5e" />
<img width="494" height="69" alt="Screenshot 2026-10-15 at 08 31 07" src="https://github.com/user-attachments/assets/bce7ccfe-59d8-4b0c-9c0b-641d4a3e87b9" />

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
<img width="494" height="242" alt="Screenshot 2026-10-15 at 08 31 26" src="https://github.com/user-attachments/assets/ac13562c-2e2c-4da6-90bf-d9b7900619c9" />
<img width="494" height="63" alt="Screenshot 2026-10-15 at 08 31 50" src="https://github.com/user-attachments/assets/87f8a15d-f8ae-423b-9303-25ebceba1c8f" />

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
<img width="494" height="128" alt="Screenshot 2026-10-15 at 08 32 04" src="https://github.com/user-attachments/assets/dbb8bcb2-c33f-4633-b1b0-82cbd4e36e5c" />
<img width="494" height="57" alt="Screenshot 2026-10-15 at 08 32 21" src="https://github.com/user-attachments/assets/bb05a146-3758-4f77-8f56-920af5891583" />

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
<img width="494" height="149" alt="Screenshot 2026-10-15 at 08 32 37" src="https://github.com/user-attachments/assets/1a8d8600-4d46-4055-9156-8d4cd6de544c" />
<img width="494" height="30" alt="Screenshot 2026-10-15 at 08 32 52" src="https://github.com/user-attachments/assets/ff552d7a-740c-4198-8b1a-5c792996db4b" />

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
<img width="494" height="182" alt="Screenshot 2026-10-15 at 08 33 07" src="https://github.com/user-attachments/assets/01498da6-2a5d-4934-b8f6-49a411a42549" />
<img width="494" height="73" alt="Screenshot 2026-10-15 at 08 33 22" src="https://github.com/user-attachments/assets/8047e333-4cc5-4579-9dec-d5ec7f3cc2f6" />

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
<img width="494" height="127" alt="Screenshot 2026-10-15 at 08 33 41" src="https://github.com/user-attachments/assets/e4b5cd08-8688-4e6a-ba73-df409bd364cb" />
<img width="494" height="73" alt="Screenshot 2026-10-15 at 08 33 57" src="https://github.com/user-attachments/assets/3b3ef63d-1e58-4a9b-a3f9-0d1943d98c20" />

## Task #15: Create a method that calculates the error in representation of a ADC with a range 0-5v and resolution 6 bits for and voltage measured from an analog input.

```.java
public class calculateADCError{
    public double calculateADCError(double analog) {
        double step = 5.0 / Math.pow(2, 6);

        double remainder = analog % step;

        double error = Math.min(remainder, step - remainder);

        return error;
    }
}
```

## Proof of Work:
<img width="494" height="134" alt="Screenshot 2026-10-15 at 08 45 05" src="https://github.com/user-attachments/assets/0257604b-d2b4-4e3f-8be4-9081a249e9a5" />
<img width="494" height="17" alt="Screenshot 2026-10-15 at 08 45 17" src="https://github.com/user-attachments/assets/a974cb2d-7c70-49e3-a138-eb02b9a70318" />
