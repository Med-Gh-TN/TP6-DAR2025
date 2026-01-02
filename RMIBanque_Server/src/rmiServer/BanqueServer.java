package rmiServer;

import java.rmi.registry.LocateRegistry;
import javax.naming.Context;
import javax.naming.InitialContext;
import rmiService.BanqueImpl;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            // Créer le registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);
            System.out.println("Registre RMI prêt sur le port 1099.");

            // Instancier le service
            BanqueImpl banqueService = new BanqueImpl();

            // Utiliser JNDI pour l'enregistrement
            Context ctx = new InitialContext();
            ctx.rebind("BK", banqueService);

            System.out.println("Service Banque (BK) enregistré avec succès via JNDI.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
