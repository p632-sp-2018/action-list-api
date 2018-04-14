# fetch basic image
FROM maven:3.3.9-jdk-8

# application placed into /opt/app
RUN mkdir -p /opt/app
WORKDIR /opt/app

# selectively add the POM file and
# install dependencies
COPY pom.xml /opt/app/
COPY src/ /opt/app/src/
COPY src/main/asciidoc/ /opt/app/src/main/asciidoc/
COPY src/main/resources/ /opt/app/src/main/resources/
RUN mvn install

# rest of the project
#RUN mvn package

# local application port
EXPOSE 8081

# execute it
CMD ["mvn", "spring-boot:run"]

