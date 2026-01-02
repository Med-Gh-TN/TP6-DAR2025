package rmiClient;

import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            // Utiliser JNDI pour rechercher l'objet distant
            Context ctx = new InitialContext();
            IBanque stub = (IBanque) ctx.lookup("BK");

            System.out.println("Connecté au service Banque.");

            // Test 1 : Créer un compte
            Compte c1 = new Compte(101, 5000.0, new Date());
            System.out.println("Tentative de création du compte 101...");
            String res1 = stub.creerCompte(c1);
            System.out.println("Serveur: " + res1);

            // Test 2 : Créer un compte existant
            System.out.println("Tentative de création du compte 101 à nouveau...");
            String res2 = stub.creerCompte(c1);
            System.out.println("Serveur: " + res2);

            // Test 3 : Consulter un compte
            System.out.println("Lookup du compte 101...");
            String res3 = stub.getInfoCompte(101);
            System.out.println("Infos Compte 101: " + res3);

            // Test 4 : Consulter un compte inexistant
            System.out.println("Lookup du compte 999...");
            String res4 = stub.getInfoCompte(999);
            System.out.println("Infos Compte 999: " + res4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
