# Liste de Jeux Vidéo - Application Kotlin

Ce projet est une application mobile Android développée en Kotlin qui permet d'explorer une liste de jeux vidéo gratuits grâce à l'API FreeToGame. L'application comporte deux écrans principaux : une liste scrollable des jeux avec un filtre par genre et un écran de détails pour chaque jeu.

## Fonctionnalités

- **Affichage d'une liste de jeux vidéo :**
  - Liste scrollable des jeux obtenus depuis l'API FreeToGame.
  - Filtrage des jeux par catégorie/genre.
  - Tri des jeux vidéos en fonction de leur titre, de leur éditeur et de leur date de sortie
  
- **Détails d'un jeu vidéo :**
  - Affichage des informations détaillées d'un jeu (titre, description, genre, image, etc.).
  - Navigation vers les détails depuis un élément cliquable de la liste.

## Exigences techniques

- **Langage et plateforme :**
  - Kotlin pour le développement Android natif.
  
- **API utilisée :**
  - [FreeToGame API](https://www.freetogame.com/api-doc)
  
- **Architecture :**
  - Utilisation d'une architecture propre et lisible (MVVM).
  - Séparation des responsabilités (UI, logique métier, communication avec l'API).
  
- **Navigation :**
  - Navigation fluide entre les écrans (liste → détails).

## Installation et utilisation

1. Clonez ce dépôt sur votre machine locale.
2. Ouvrez le projet dans Android Studio.
3. Ajoutez une clé d'API si nécessaire dans les paramètres de votre projet (consultez la documentation de l'API pour plus de détails).
4. Compilez et exécutez l'application sur un émulateur ou un appareil Android réel.

## Dépendances principales

- **Retrofit** : pour la communication avec l'API REST.
- **Glide** ou **Coil** : pour le chargement des images.
- **Jetpack Components** : LiveData, ViewModel, Navigation.
