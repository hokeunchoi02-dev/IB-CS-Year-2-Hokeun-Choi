## Quiz #1: Create a class that generates a random number between 0 and 256, returns a string.

```java
public class ranNum {
  public String ranNum() {
     int num = (int) (Math.random() * (255 + 1));
     return num + "";
  }
}//ask about this before class(Is it really 256? because if I would like to use this code for IPv4Gen.java, using this is not efficient.)
```

## Proof of work:
<img width="389" height="50" alt="Screenshot 2026-09-03 at 20 22 42" src="https://github.com/user-attachments/assets/8121c1cf-c46a-45a2-a5d3-244720667403" />

## Quiz #2: Create a class that generates a valid IPv4 address. You may use the class RanNum()

```java
public class IPv4Gen {
  public String generate() {
    ranNum generator = new ranNum();
    return generator.ranNum() + "." + generator.ranNum() + "." + generator.ranNum() + "." + generator.ranNum();
  }
}
```

## Proof of work:
<img width="389" height="50" alt="Screenshot 2026-09-03 at 20 23 00" src="https://github.com/user-attachments/assets/fcd85048-91f2-4064-ac53-8a82bb8220a1" />

## Task #3: Create a class that receives an input String add and it checks for valid IPv4 address.

```java
public class checker {
  private String add;//do I need to keep this?
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
}
```

## Proof of work:
<img width="389" height="58" alt="Screenshot 2026-09-03 at 20 23 33" src="https://github.com/user-attachments/assets/8875f6d3-e1e1-47c8-950b-99da02eff006" />

## Quiz #4: Create a class receives a service name, ip address and build a ip:port address.

```java
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
    if (!new checker(ip).test) {
      return "invalid ip";//only go to next code when IP is valid
    }
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
}
```

## Proof of work:
<img width="533" height="58" alt="Screenshot 2026-09-03 at 20 23 59" src="https://github.com/user-attachments/assets/50c24a27-e19e-4ca9-bb18-dc67e21266bf" />

## Task #5: Create a class that uses parallel arrays to store a table of hostnames and their IP addresses.

```java
public class dns {
    private static String[] hostnames = {"localhost", "google.com", "example.com"};
    private static String[] ips       = {"127.0.0.1", "142.250.72.14", "7.7.7.7"};

    private String hostname;

    public dns(String hostname) {
        this.hostname = hostname;
    }

    public String lookup() {
        for (int i = 0; i < hostnames.length; i++) {
            if (hostnames[i].equals(hostname)) {
                return ips[i];
            }
        }
        return "hostname not on record table. Use register() to add a new hostname:IP pair";
    }

    public static void register(String newHostname, String newIp) {
        if (new checker(newIp).test) {
            String[] newHostnames = new String[hostnames.length + 1];
            String[] newIps = new String[ips.length + 1];

            for (int i = 0; i < hostnames.length; i++) {
                newHostnames[i] = hostnames[i];
                newIps[i] = ips[i];
            }
            newHostnames[hostnames.length] = newHostname;
            newIps[ips.length] = newIp;

            hostnames = newHostnames;
            ips = newIps;
        }
    }
    
    public static String[] getHostnames() {
        return hostnames;
    }

    public static String[] getIps() {
        return ips;//for filter.java
    }
}
```

## Proof of work:
<img width="533" height="58" alt="Screenshot 2026-09-03 at 20 24 32" src="https://github.com/user-attachments/assets/673d4c02-624f-4b1a-93ed-a3fae71a0bdf" />

## Task #6: Create a class that uses parallel arrays to filter traffic in network using ip/hostnames, assume the DNS:

```java
public class filter {//shoul i extend filter from dns?
    private static String[] whitelist = {"127.0.0.1", "142.250.72.14", "example.com"};
    private String input;

    public filter(String input) {
        this.input = input;
    }

    public String check() {
        if (new checker(input).test) {
            String[] hostnames = dns.getHostnames();
            String[] ips = dns.getIps();
            for (int i = 0; i < ips.length; i++) {
                if (ips[i].equals(input)) {
                    for (int j = 0; j < whitelist.length; j++) {
                        if (whitelist[j].equals(input) || whitelist[j].equals(hostnames[i])) {
                            return "accepted ip:" + input + " hostname:" + hostnames[i];
                        }
                    }
                }
            }
            return "rejected";
        } else {
            dns lookupHelper = new dns(input);
            String ip = lookupHelper.lookup();
            for (int i = 0; i < whitelist.length; i++) {
                if (whitelist[i].equals(input) || whitelist[i].equals(ip)) {
                    return "accepted with ip:" + ip + " hostname:" + input;
                }
            }
            return "rejected";
        }
    }
}
```

## Proof of work:
<img width="533" height="58" alt="Screenshot 2026-09-03 at 20 25 04" src="https://github.com/user-attachments/assets/476de575-96e0-4abd-91ba-1f3a05bd73a3" />
