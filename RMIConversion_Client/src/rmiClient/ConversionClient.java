package rmiClient;

import java.rmi.Naming;
import rmiService.IConversion;

public class ConversionClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            // URL format: rmi://host:port/name
            IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1099/ObjetDistant");
            
            // Invoke the remote method
            double montant = 500.0;
            double result = stub.convertirMontant(montant);
            
            // Print the result
            System.out.println("Montant initial : " + montant);
            System.out.println("Resultat de la conversion : " + result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
