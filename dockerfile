FROM java:8
EXPOSE 8080
ADD target/CryptoSpring-0.0.1-SNAPSHOT.jar CryptoSpring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","CryptoSpring-0.0.1-SNAPSHOT.jar"]