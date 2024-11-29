FROM mcr.microsoft.com/devcontainers/base:alpine

# Téléchargement et installation de Java 23 (preview)
RUN curl -L  https://github.com/adoptium/temurin23-binaries/releases/download/jdk-23.0.1%2B11/OpenJDK23U-jdk_x64_alpine-linux_hotspot_23.0.1_11.tar.gz > java.tar.gz
RUN mkdir -p java && tar -xzf java.tar.gz --directory java
RUN mv java/$(ls java)/* java/ && mv java /usr/local/java

# Configuration des variables d'environnement
ENV JAVA_HOME /usr/local/java
ENV PATH $JAVA_HOME/bin:$PATH

# Verification de l'installation
RUN java --version