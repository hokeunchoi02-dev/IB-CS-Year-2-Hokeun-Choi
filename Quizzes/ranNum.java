public class ranNum {
  public String ranNum() {
     int num = (int) (Math.random() * (256 + 1));
     return num + "";
  }

  public static void main(String[] args) {
    ranNum generator = new ranNum();
    System.out.println(generator.ranNum());
  }
}
