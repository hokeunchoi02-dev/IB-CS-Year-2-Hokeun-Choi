public class IPv4Gen {
  public String generate() {
    int a = (int) (Math.random() * 256);
    int b = (int) (Math.random() * 256);
    int c = (int) (Math.random() * 256);
    int d = (int) (Math.random() * 256);
    return a + "." + b + "." + c + "." + d;
  }
  public static void main(String[] args) {
    IPv4Gen addr = new IPv4Gen();
    System.out.println(add.generate);
  }
}
