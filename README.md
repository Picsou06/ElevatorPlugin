# ElevatorPlugin

Plugin Minecraft (Spigot/Bukkit 1.20.2) qui transforme une colonne de blocs d'obsidienne en ascenseur.

En s'accroupissant ou en marchant sur le bloc configuré, le joueur est automatiquement téléporté au bloc du même type le plus proche au-dessus (en montant) ou en dessous (en s'accroupissant), dans la limite d'une hauteur maximale définie dans la configuration.

## Stack technique

- Java
- API Spigot/Bukkit 1.20
- Gradle (wrapper inclus)

## Fonctionnement

- `PlayerMoveListener` : détecte quand un joueur monte au-dessus d'un bloc du type configuré et le téléporte vers le prochain bloc du même type plus haut.
- `PlayerSneakListener` : détecte quand un joueur s'accroupit sur un bloc du type configuré et le téléporte vers le prochain bloc du même type plus bas.
- Le type de bloc (`bloc`) et la hauteur maximale de recherche (`HauteurMax`) sont définis dans la configuration du plugin.

## Installation

1. Compiler le plugin avec Gradle (`./gradlew build`).
2. Déposer le `.jar` généré dans le dossier `plugins/` d'un serveur Spigot/Paper 1.20.
3. Configurer le bloc utilisé comme ascenseur et la hauteur maximale dans le fichier de config généré.

## Statut

Projet de découverte du développement de plugins Minecraft, fonctionnel mais expérimental.
