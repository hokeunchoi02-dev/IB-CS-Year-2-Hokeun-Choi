public class checker {
  private String add;
  public boolean test;
  public checker(String add) {
    this.add = add;
    this.test = isValidIPv4(add);
  }
  private boolean isValidIPv4(String s) {
    String[] parts = s.split("\\.");
    if (parts.length != 4) {
      return false;
    }
    for (int i = 0; i < parts.length; i++) {
      String part = parts[i];
      if (part.length() == 0) {
        return false;
      }
      for (int j = 0; j < part.length(); j++) {
        char c = part.charAt(j)
        if (!Character.isDigit(c)) {
          return false;
        }
      }
      int num = Integer.parseInt(part);
      if (num < 0 || num > 255) {
        return false;
      }
      if (part.length() < 1 && part.charAt(0) == '0') {
        return false;
      }
    }
    public static void main(String[] args) {
      checker test1 = new checker("hello");
      System.out.println(test1.test);

      checker test2 = new checker("192.45.7.201");
      System.out.println(test2.test);
    }
  }
