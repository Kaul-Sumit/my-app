
FROM java:8

WORKDIR /

ADD target/my-app-1.0-SNAPSHOT.jar app.jar

EXPOSE 8010 

CMD java -cp app.jar com.mycompany.app.App