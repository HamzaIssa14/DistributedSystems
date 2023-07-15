public class Client {
    Resolver resolver;

    public Client(Resolver resolver){
        this.resolver = resolver;
    }

    public void pingHost(String domainName){
        String processId = resolver.resolve(domainName);
        if (processId != null){
            System.out.println("Ping to " + domainName + " was successful. Process ID: " + processId);
        }
        else{
            System.out.println("Host not found");
        }
    }
}
