# Facturation Application

## Description

La Facturation Application est une application Spring Boot qui gère la facturation pour les clients, en prenant en compte différents types de clients (professionnels et particuliers) et types d'énergie.

## Fonctionnalités

- Gestion des clients (professionnels et particuliers)
- Facturation basée sur le type d'énergie et la quantité consommée

## Technologies utilisées

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (pour le développement)

## Configuration

### Base de données

L'application utilise une base de données H2 pour le développement. Vous pouvez configurer les paramètres de base de données dans le fichier `src/main/resources/application.properties` ou `src/main/resources/application.yml`.

### Exécution de l'application

Pour exécuter l'application, utilisez la commande Maven suivante :

```bash
mvn spring-boot:run
