# Utiliser une image de base avec Java
FROM openjdk:17-jdk-alpine

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR construit dans le répertoire de travail
COPY target/Membre-3.1.3.jar /app/

# Définir le point d'entrée pour exécuter l'application lorsque le conteneur démarre
ENTRYPOINT ["java", "-jar", "Membre-3.1.3.jar"]
