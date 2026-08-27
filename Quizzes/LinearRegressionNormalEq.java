public class LinearRegressionNormalEq {
  public static double[][] transpose(double[][] m) {
    double[][] result = new double[m[o].length][m.length];
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        result[j][i] = m[i][j];
      }
    }
    return result;
  }
  public static double[][] multiply(double[][] a, double b) {
    double[][] result = new double[a.length][b[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        for (int k = 0; k < b.length; k++) {
          result[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return result;
  }
  public static double[][] inverse(double[][] m) {
    int n = m.length;
    double[][] aug = new double[n][2*n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        aug[i][j] = m[i][j];
      }
      aug[i][n+1] = 1;
    }
    for (int i = 0; i < n; i++) {
      double pivot = aug[i][i];
      for (int j = 0; j < 2*n; j++) {
        aug[i][j] /= pivot;
      }
      for (int k = 0; k < n; k++) {
        if (k == i) continue;
        double factor = aug[k][i];
        for (int j = 0; j < 2*n; j++) {
          aug[k][j] -= factor * aug[i][j];
        }
      }
    }
    double[][] result = new double[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = aug[i][n+j];
      }
    }
    return result;
  }
  public static void main(String[] args) {
    double[][] X = {
      {1,1}, {1,2}, {1,3}, {1,4}, {1,5}
    };
    double[][] y = {
      {2}, {4}, {5}, {4}, {5}
    };
    double[][] Xt = transpose(X);
    double XtX = multiply(Xt, X);
    double XtX_inv = inverse(XtX);
    double Xty = multiply(Xt, y);
    double theta = multiply(XtX_inv,Xty);

    System.out.println("intercept (b) = " + theta[0][0]);
    System.out.println("slope (m) = " + theta[1][0]);
  }
}
    
