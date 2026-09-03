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
        String[] newHostnames = new String[hostnames.length + 1];
        String[] newIps       = new String[ips.length + 1];

        for (int i = 0; i < hostnames.length; i++) {
            newHostnames[i] = hostnames[i];
            newIps[i] = ips[i];
        }
        newHostnames[hostnames.length] = newHostname;
        newIps[ips.length] = newIp;

        hostnames = newHostnames;
        ips = newIps;
    }//as it is parallel array, i need to update its size(unlike arraylist)
    public static String[] getHostnames() {
        return hostnames;
    }

    public static String[] getIps() {
        return ips;
    }//these getters are for filter.java
    public static void main(String[] args) {
        dns test1 = new dns("google.com");
        System.out.println(test1.lookup());
      
        dns test2 = new dns("jisedu.or.id");
        System.out.println(test2.lookup());
      
        dns.register("jisedu.or.id","203.0.113.5");
        dns test3 = new dns("jisedu.or.id");
        System.out.println(test3.lookup());
    }
}
