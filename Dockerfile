FROM openjdk:11-jre-slim
LABEL authors="Admin"

WORKDIR /app

COPY /jaden-demo-eureka/target/jaden-demo-eureka-1.0.jar /app/jaden-demo-eureka-1.0.jar
CMD ["java","-jar","/app/jaden-demo-eureka-1.0.jar"]


#ENTRYPOINT ["top", "-b"]