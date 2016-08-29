
# Dropwizard Dagger 2 Example App

## Requirements
- java 8
- maven 3

## Start with test configuration
This uses com.vlitvak.example.DummyModule.java
```bash
mvn clean && \
      mvn install && \
      mvn package && \
      java -jar target/example-1.0-SNAPSHOT.jar server test.yml
```


## Start with production configuration
uses com.vlitvak.example.RealModule.java
```bash
mvn clean && \
      mvn install && \
      mvn package && \
      java -jar target/example-1.0-SNAPSHOT.jar server production.yml
```

## Making requests:
```bash
curl -X GET http://localhost:8080/todos?id=123
```


## Demo Deployed on Heroku:
```bash
curl -X GET http://murmuring-coast-31996.herokuapp.com/todos?id=12345
```

