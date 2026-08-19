public class ranNum {
  public String ranNum() {
     int num = (int) Math.random() * (256 + 1);
     return String.valueOf(num);
  }

  public static void main(String[] args) {
    RanNum generator = new ranNum();
    System.out.println(generator);
  }
}
