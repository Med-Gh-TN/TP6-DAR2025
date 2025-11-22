# TP6 - Architecture Distribuée avec Java RMI

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![RMI](https://img.shields.io/badge/RMI-Middleware-blue?style=for-the-badge)
![Architecture](https://img.shields.io/badge/Architecture-Client%2FServeur-green?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=for-the-badge)

> **TP6-DAR2025** : Une implémentation de référence d'un système distribué pour la conversion de devises utilisant le protocole Java Remote Method Invocation (RMI).

---

## 📑 Table des Matières

- [Aperçu du Projet](#-aperçu-du-projet)
- [Architecture Technique](#-architecture-technique)
- [Structure du Projet](#-structure-du-projet)
- [Prérequis](#-prérequis)
- [Installation et Démarrage](#-installation-et-démarrage)
- [Auteurs](#-auteurs)

---

## 🔭 Aperçu du Projet

Ce projet a été développé dans le cadre du module **Développement d'Applications Réparties (DAR)**. Il illustre les concepts fondamentaux de la programmation distribuée en Java.

L'application permet à un client distant d'invoquer une méthode de conversion (montant × taux) hébergée sur un serveur. Contrairement à une application monolithique, la logique métier est ici totalement découplée de l'interface client.

**Fonctionnalités clés :**
*   Invocation de méthodes à distance (Remote Procedure Call).
*   Utilisation d'un registre RMI pour la découverte de services.
*   Séparation stricte des responsabilités (Interface / Implémentation / Client).

---

## 🏗 Architecture Technique

Le projet repose sur le modèle **Proxy** via RMI :

1.  **Le Serveur** instancie un objet `ConversionImpl` et le publie dans le **RMI Registry** sous un nom unique (`ObjetDistant`).
2.  **Le Client** interroge le registre pour obtenir une référence (le **Stub**).
3.  Le Client appelle la méthode `convertirMontant()` sur le Stub.
4.  Java RMI gère la sérialisation, le transport réseau, l'exécution sur le serveur, et le retour du résultat.

---

## 📂 Structure du Projet

La structure des fichiers respecte la séparation logique des composants :

```bash
TP6-DAR2025/
├── RMIConversion_Server/       # 🟢 Côté Serveur
│   ├── src/
│   │   ├── rmiServer/          # Point d'entrée (Main) du serveur
│   │   └── rmiService/         # Implémentation de l'objet distant
├── RMIConversion_Client/       # 🔵 Côté Client
│   ├── src/
│   │   ├── rmiClient/          # Point d'entrée (Main) du client
│   │   └── rmiService/         # Interface commune (Contrat)
└── README.md                   # Documentation du projet
```

---

## ⚙ Prérequis

Avant de commencer, assurez-vous d'avoir installé :

*   **Java Development Kit (JDK)** : Version 8 ou supérieure.
*   **Git** : Pour cloner le dépôt.
*   **IDE (Optionnel)** : IntelliJ IDEA ou Eclipse recommandé.

---

## 🚀 Installation et Démarrage

Suivez ces étapes pour lancer le projet en ligne de commande.

### 1. Cloner le dépôt

```bash
git clone https://github.com/Med-Gh-TN/TP6-DAR2025.git
cd TP6-DAR2025
```

### 2. Compilation

Vous devez compiler les fichiers du serveur et du client. Placez-vous à la racine du projet.

*Compilation du Serveur :*
```bash
javac -d bin RMIConversion_Server/src/rmiService/*.java RMIConversion_Server/src/rmiServer/*.java
```

*Compilation du Client :*
```bash
javac -d bin -cp bin RMIConversion_Client/src/rmiService/*.java RMIConversion_Client/src/rmiClient/*.java
```

> *Note : L'interface `IConversion` est nécessaire aux deux parties. Ici, nous compilons tout dans un dossier unique `bin` pour simplifier l'exécution locale.*

### 3. Démarrage du Serveur

Le serveur va démarrer son propre registre RMI (sur le port 1099) et attendre les connexions.

```bash
java -cp bin rmiServer.ConversionServer
```
*Vous devriez voir le message : `Server is ready.`*

### 4. Lancement du Client

Ouvrez un **nouveau terminal** et lancez le client :

```bash
java -cp bin rmiClient.ConversionClient
```

**Résultat attendu :**
```text
Montant initial : 500.0
Resultat de la conversion : 1650.0
```


## 👨‍💻 Auteurs

*   **Med-Gh-TN** - *Développement et Architecture* - [Profil GitHub](https://github.com/Med-Gh-TN)



<div align="center">
  <sub>Réalisé pour le TP6 - Développement d'Applications Réparties.</sub>
</div>
```
