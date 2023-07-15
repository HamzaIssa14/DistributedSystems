import java.util.HashMap;

public class Server {
    String name;
    HashMap<String, Server> servers;
    HashMap<String, Host> hosts;

    public Server(String name){
        this.name = name;
        this.servers = new HashMap<>();
        this.hosts = new HashMap<>();
    }
    public void addSubServer(Server server){
        servers.put(server.name, server);
    }
    public void addHost(Host host){
        hosts.put(host.getName(), host);
    }
    public Server getSubServer(String name){
        return servers.get(name);
    }
    public Host findHost(String name){
        return hosts.get(name);
    }
}
