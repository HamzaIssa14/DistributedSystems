import java.util.HashMap;

public class Resolver {
    private HashMap<String, String> cache;
    private Server rootServer;

    public Resolver(Server server){
        this.rootServer = server;
        this.cache = new HashMap<>();
    }

    public String resolve(String domainName){
        if(cache.containsKey(domainName)){
            return cache.get(domainName);
        }
        else{
            String[] parts = domainName.split("\\."); // Splitting domain by the '.' char
            String processId = resolveRecursive(parts, parts.length - 1, rootServer);
            if(processId != null){
                cache.put(domainName, processId);
            }
            return processId;

        }
    }

    private String resolveRecursive(String[] parts, int index, Server server){
        if(index == 0){
            Host host = server.findHost(parts[index]);
            return host != null ? host.getProcessId() : null;
        }
        server = server.getSubServer(parts[index]);
        return server != null ? resolveRecursive(parts, index - 1, server) : null;

    }
}
