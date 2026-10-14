public class Matrix {

    private int[][] matrix;
    private int[] numbers;
    private int size;


    // for 2D array
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }


    // for size
    public Matrix(int size) {
        this.size = size;
    }


    // Task 13 - 1D array를 받을 때
    public Matrix(int[] numbers) {
        this.numbers = numbers;
    }


    // Task 9 - Row Average
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


    // Task 9 - Column Average
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


    // Task 10 - Scale Matrix
    public int[][] scale(int scale) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] *= scale;
            }
        }

        return matrix;
    }


    // Task 11 - Identity Matrix
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


    // Task 13 - 1D array -> square matrix
    public int[][] toMatrix() {

        int n = (int) Math.ceil(Math.sqrt(numbers.length));

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


    // Matrix 출력
    public void show(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }


    public int[] vectorize() {

        int[] result =
            new int[matrix[0].length * matrix.length];

        int index = 0;

        for (int r = 0; r < matrix.length; r++) {

            for (int c = 0; c < matrix[r].length; c++) {
                result[index] = matrix[r][c];
                index++;
            }
        }

        return result;
    }
}
