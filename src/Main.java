public class Main {
    public static void main(String[] args) {
        // Create root Server
        Server rootServer = new Server("root");

        // Create Resolver with root Server
        Resolver resolver = new Resolver(rootServer);

        // Create Client with Resolver
        Client client = new Client(resolver);

        // Create com Server and add to root
        Server comServer = new Server("com");
        rootServer.addSubServer(comServer);

        // Create google Server and add to com
        Server googleServer = new Server("google");
        comServer.addSubServer(googleServer);

        // Create www Host and add to google
        Host wwwHost = new Host("www", "1234");
        googleServer.addHost(wwwHost);

        // Create docs Host and add to google
        Host docsHost = new Host("docs", "1235");
        googleServer.addHost(docsHost);

        // Create net Server and add to root
        Server netServer = new Server("net");
        rootServer.addSubServer(netServer);

        // Create example Server and add to net
        Server exampleServer = new Server("example");
        netServer.addSubServer(exampleServer);

        // Create www Host and add to example
        Host exampleWwwHost = new Host("www", "1236");
        exampleServer.addHost(exampleWwwHost);

        // Client pings www.google.com
        client.pingHost("www.google.com");

        // Client pings docs.google.com
        client.pingHost("docs.google.com");

        // Client pings www.example.net
        client.pingHost("www.example.net");

        // Client attempts to ping nonexistent host www.nonexistent.com
        client.pingHost("www.nonexistent.com");

        // Client attempts to ping a nonexistent host on an existing server example.net
        client.pingHost("nonexistent.example.net");
    }
}
