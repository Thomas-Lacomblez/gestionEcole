FROM maven:3.8.4-openjdk-11-slim as build
RUN mkdir dgestionEcole
WORKDIR /gestionEcole
COPY ./ ./
RUN mvn clean package spring-boot:repackage
RUN ls
RUN ls ./target

FROM gcr.io/distroless/java:11
COPY --from=build /gestionEcole/target/d*.jar /jar-files/gestionEcole.jar
WORKDIR /jar-files

EXPOSE 8080
CMD [ "gestionEcole.jar" ]
