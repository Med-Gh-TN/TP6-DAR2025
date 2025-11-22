package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.ConversionImpl;
import rmiService.IConversion;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            // Create the registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Instantiate the implementation
            IConversion od = new ConversionImpl();
            
            // Bind the object to the registry
            registry.rebind("ObjetDistant", od);
            
            System.out.println("Server is ready.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
