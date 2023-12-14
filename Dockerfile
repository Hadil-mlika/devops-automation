FROM openjdk:11
EXPOSE 8080
ADD target/employeesmicroservice-0.0.1-SNAPSHOT.jar employeesmicroservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/employeesmicroservice-0.0.1-SNAPSHOT.jar"]
