FROM java:8-jdk-alpine

WORKDIR /applications

COPY /target/11HelloWorld-0.0.1-SNAPSHOT.jar /applications/StudentsDemo.jar

CMD ["java","-jar","StudentsDemo.jar"]