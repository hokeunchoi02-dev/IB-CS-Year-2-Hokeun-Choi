## Task #9: Create a class that receives a 2D array and returns the average across columns and across rows.

```.java
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
}
```

### Proof of Work:
<img width="958" height="659" alt="Screenshot 2026-10-15 at 17 26 03" src="https://github.com/user-attachments/assets/ea73c67a-6d92-4778-97e5-267d36f9e155" />


## Task #10: Create a class that receives a 2D array and a integer, returns the array scaled by the constant:

```.java
public class Matrix {
    private int[][] matrix;
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }
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
}
```

### Proof of Work:
<img width="958" height="657" alt="Screenshot 2026-10-15 at 17 28 23" src="https://github.com/user-attachments/assets/6e735242-328d-4e26-b99d-63f85ff66a92" />


## Task #11: Create a class that receives a constant n and returns a identity matrix of size n x n :

```.java
public class Matrix {
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
}
```

### Proof of Work:
<img width="958" height="447" alt="Screenshot 2026-10-15 at 17 29 37" src="https://github.com/user-attachments/assets/2fa87574-5d80-448f-b645-98643983a0b3" />


## Task #12: Create a method that receives a matrix of size n x m: the output is a 1D “vectorized” version of the input.

```.java
public class Matrix {
    private int[][] matrix;
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }
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
}
```
### Proof of Work:
<img width="958" height="447" alt="Screenshot 2026-10-15 at 17 32 27" src="https://github.com/user-attachments/assets/12db775d-e3e2-4549-ad00-e7f0d35be10f" />


## Task #13: Create a method that receives a 1D array and builds a square matrix, use zero-padded.

```.java
public class Matrix {
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
}
```

### Proof of Work:
<img width="958" height="635" alt="Screenshot 2026-10-15 at 17 33 26" src="https://github.com/user-attachments/assets/365a1647-cfd8-45bc-9190-9c28c46a697b" />


## Task #14: Create a method that creates a ascending diagonal matrix

```.java
public class Matrix {
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
}
```

## Proof of Work:
<img width="958" height="558" alt="Screenshot 2026-10-15 at 17 35 22" src="https://github.com/user-attachments/assets/cf6cfa89-7691-4a3e-91a1-62abf8c93e41" />


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
<img width="958" height="558" alt="Screenshot 2026-10-15 at 17 36 04" src="https://github.com/user-attachments/assets/16fa8509-204d-46ad-adbf-94846c0325dd" />

## Task #16: Create a method that calculates the minimum number of bits required for an ADC to measure the smallest voltage difference specified in an array of voltage values, given the minimum and maximum input voltage range.

```.java

public static int calculateResolution(double min, double max, double[] readings) {

    // Step 1: Bubble Sort
    for (int i = 0; i < readings.length - 1; i++) {
        for (int j = 0; j < readings.length - 1 - i; j++) {
            if (readings[j] > readings[j + 1]) {
                double temp = readings[j];
                readings[j] = readings[j + 1];
                readings[j + 1] = temp;
            }
        }
    }

    // Step 2: Find the smallest gap
    double gap = max - min;

    for (int i = 0; i < readings.length - 1; i++) {
        double diff = readings[i + 1] - readings[i];

        if (diff > 0 && diff < gap) {
            gap = diff;
        }
    }

    // Step 3: Find minimum bits
    double step = max - min;
    int result = 0;

    while (step > gap) {
        step = step / 2;
        result++;
    }

    return result;
}
```

## Proof of Work:
<img width="948" height="486" alt="Screenshot 2026-10-15 at 18 38 48" src="https://github.com/user-attachments/assets/ae60526e-abf4-4d84-8a77-9cba423f3bd7" />

## All Matrix.java(Task 9 to 14):
```.java

public class Matrix {

    private int[][] matrix;
    private int[] numbers;
    private int size;

    // Constructor for 2D arrays (Tasks 9, 10, 12)
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // Constructor for matrix size (Task 11)
    public Matrix(int size) {
        this.size = size;
    }

    // Constructor for 1D arrays (Task 13)
    public Matrix(int[] numbers) {
        this.numbers = numbers;
    }

    // No-argument constructor for Task 14
    public Matrix() {
    }


    // ==================== Task 9 ====================
    // Row Average
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

    // Column Average
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


    // ==================== Task 10 ====================
    // Scale Matrix
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


    // ==================== Task 11 ====================
    // Identity Matrix
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


    // ==================== Task 12 ====================
    // Convert 2D Array to 1D Array
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


    // ==================== Task 13 ====================
    // Convert 1D Array to Square Matrix
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


    // ==================== Task 14 ====================
    // Ascending Diagonal Matrix
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


    // ==================== Display Methods ====================
    // Method Overloading

    // Display double[] (Task 9)
    public void show(double[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    // Display int[][] (Tasks 10, 11, 13, 14)
    public void show(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Display int[] (Task 12)
    public void show(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
```

#Proof of Work from Matrix.java:
<img width="932" height="381" alt="Screenshot 2026-10-15 at 13 45 53" src="https://github.com/user-attachments/assets/45031cf9-6744-486c-8a2a-88c88dc69ac4" />
