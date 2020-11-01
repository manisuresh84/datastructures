package samples.helloworld.client;
 
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
 
public class helloWorldClient {
    public helloWorldClient() {
        super();
    }
 
    public static void main(String[] args) {
        Client c = Client.create();
        WebResource resource = c.resource("http://localhost:7101/RESTfulService-Project1-context-root/jersey/helloWorld");
        String response = resource.get(String.class);
    }
}