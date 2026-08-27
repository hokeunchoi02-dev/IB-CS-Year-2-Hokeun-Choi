### Quizzes for CS Year 2

## Quiz #1: Create a class that generates a random number between 0 and 256, returns a string.
```.java
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
```
## Proof of work:
<img width="1300" height="721" alt="Screenshot 2026-08-24 at 09 43 24" src="https://github.com/user-attachments/assets/da380ddb-60c1-4304-9535-1ce2c8faec0e" />

## Quiz #2: Create a class that generates a valid IPv4 address. You may use the class RanNum()
```.java
public class IPv4Gen {
  public String generate() {
    int a = (int) (Math.random() * 256);
    int b = (int) (Math.random() * 256);
    int c = (int) (Math.random() * 256);
    int d = (int) (Math.random() * 256);
    return a + "." + b + "." + c + "." + d;
  }
  public static void main(String[] args) {
    IPv4Gen add = new IPv4Gen();
    System.out.println(add.generate());
  }
}
```
## Proof of work:
<img width="1010" height="518" alt="Screenshot 2026-08-24 at 09 44 10" src="https://github.com/user-attachments/assets/0a086b7f-a6c7-4ee3-8682-a3748ff9a82a" />

## Task #3:Create a class that receives a input String add and it checks for valid IPv4 address.
```.java
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
        char c = part.charAt(j);
        if (!Character.isDigit(c)) {
          return false;
        }
      }
      int num = Integer.parseInt(part);
      if (num < 0 || num > 255) {
        return false;
      }
      if (part.length() > 1 && part.charAt(0) == '0') {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    checker test1 = new checker("hello");
    System.out.println(test1.test);

    checker test2 = new checker("192.45.7.201");
    System.out.println(test2.test);
  }
}
```
## Proof of work:
<img width="1010" height="533" alt="Screenshot 2026-08-24 at 09 44 28" src="https://github.com/user-attachments/assets/24201da6-ded6-4e91-84e8-5f71ce84ec28" />

## Quiz #4: Create a class receives a service name, ip address and build a ip:port address.
```.java
public class porter {
  private static String[] services = {"http", "https", "playstation", "ssh", "ftp", "mysql"};
  private static int[] ports = {80, 443, 3479, 22, 20, 3306};
  private String service;
  private String ip;
  public porter(String service, String ip) {
    this.service = service;
    this.ip = ip;
  }
  public String build() {
    for (int i = 0; i < services.length; i++) {
      if (services[i].equals(service)) {
        return ip + ":" + ports[i];
      }
    }
    return "service not on record table. Use register() to add a new service:port pair";
  }
  public static void register(String newService, int newPort) {
    String[] newServices = new String[services.length + 1];
    int[] newPorts = new int[ports.length + 1];
    for (int i = 0; i < services.length; i++) {
      newServices[i] = services[i];
      newPorts[i] = ports[i];
    }
    newServices[services.length] = newService;
    newPorts[ports.length] = newPort;
    services = newServices;
    ports = newPorts;
  }
  public static void main(String[] args) {
    porter test1 = new porter("http", "192.45.7.201");
    System.out.println(test1.build());
    porter test2 = new porter("xbox", "192.45.7.201");
    System.out.println(test2.build());
  }
}
```
## Proof of work:
<img width="1440" height="900" alt="Screenshot 2026-08-27 at 19 26 21" src="https://github.com/user-attachments/assets/8c58515c-ed17-4a2d-b8c9-8343723c909a" />
