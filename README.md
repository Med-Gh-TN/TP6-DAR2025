
# Système de Gestion Bancaire Distribué (RMI & JNDI) 🏦

![Java](https://img.shields.io/badge/Java-JDK_1.8%2B-orange) ![Middleware](https://img.shields.io/badge/Middleware-RMI-red) ![Directory](https://img.shields.io/badge/API-JNDI-blue) ![Course](https://img.shields.io/badge/Module-DAR-green)

## 📝 Description

Ce projet a été réalisé dans le cadre du module **Développement d'Applications Réparties (TP6 - Activité 6.2)**.

Il implémente une application client-serveur simulant la gestion de comptes bancaires à distance. L'architecture repose sur **Java RMI (Remote Method Invocation)** pour la communication réseau et intègre **JNDI (Java Naming and Directory Interface)** pour l'enregistrement et la recherche des objets distants, remplaçant l'utilisation directe du registre RMI standard.

### 🚀 Fonctionnalités
*   **Création de compte :** Le client peut demander la création d'un compte avec un solde initial.
*   **Consultation :** Récupération des détails d'un compte (Solde, Date de création) via son identifiant.
*   **Transparence :** Utilisation de JNDI pour abstraire la localisation du service distant.

---

## 📂 Structure du Projet

Le projet est divisé en deux modules principaux :

### 1. `RMIBanque_Server` (Côté Serveur)
*   **Rôle :** Héberge l'objet distant et la logique métier.
*   **Composants clés :**
    *   `BanqueImpl` : Implémentation des méthodes distantes (Hérite de `UnicastRemoteObject`).
    *   `BanqueServer` : Initialise le registre et publie le service via JNDI (`Context.rebind`).
    *   `jndi.properties` : Configuration du fournisseur de service de nommage.

### 2. `RMIBanque_Client` (Côté Client)
*   **Rôle :** Interface utilisateur console qui consomme le service.
*   **Composants clés :**
    *   `BanqueClient` : Se connecte à l'annuaire JNDI (`Context.lookup`), récupère le Stub et invoque les méthodes.
    *   `IBanque` & `Compte` : Copies (ou JAR partagé) des interfaces et classes métiers nécessaires à la sérialisation.

---

## ⚙️ Prérequis et Installation

*   **Java JDK :** Version 1.8 ou supérieure.
*   **IDE :** Eclipse, IntelliJ IDEA ou VS Code.

### Installation

1.  **Cloner le dépôt :**
    ```bash
    git clone https://github.com/Med-Gh-TN/TP6-DAR2025.git
    ```
2.  **Ouvrir le projet :** Importez les dossiers `RMIBanque_Server` et `RMIBanque_Client` dans votre IDE.

---

## ▶️ Guide d'exécution

Pour tester l'application, suivez cet ordre précis :

### 1. Démarrer le Serveur
Exécutez la classe `rmiServer.BanqueServer`.
*   *Console attendue :*
    > Registre RMI prêt sur le port 1099.
    > Service Banque (BK) enregistré avec succès via JNDI.

### 2. Démarrer le Client
Exécutez la classe `rmiClient.BanqueClient`.
*   *Console attendue :*
    > Connecté au service Banque.
    > Tentative de création du compte 101...
    > Serveur: Succès : Compte 101 créé avec succès.
    > Infos Compte 101: Compte [code=101, solde=5000.0, ...]

---

## 🛠️ Aspects Techniques

### Pourquoi JNDI ?
Dans cette activité, nous avons découplé le code de l'implémentation spécifique du registre RMI. En utilisant `javax.naming.InitialContext`, l'application devient plus flexible et peut changer de fournisseur d'annuaire (LDAP, DNS, etc.) simplement en modifiant le fichier `jndi.properties` sans changer le code source.

**Configuration JNDI (`jndi.properties`) :**
```properties
java.naming.factory.initial=com.sun.jndi.rmi.registry.RegistryContextFactory
java.naming.provider.url=rmi://localhost:1099
```

---

## 👤 Auteur

**Mouhamed Gharsallah**
*   **Classe :** LSI 3
*   **Groupe :** 2-1
*   **Département :** Informatique

---
```
