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
