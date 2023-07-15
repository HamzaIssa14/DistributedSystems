public class Host {
    String processId;
    String name;

    public Host(String name, String processId){
        this.processId = processId;
        this.name = name;
    }

    public String getProcessId(){
        return processId;
    }
    public String getName(){
        return name;
    }
    String acknowledge(){
        return "Ping from  " + name;
    }
}
