FROM openjdk:8
ADD target/employee-management-system.jar employee-management-system.jar
EXPOSE 8383
ENTRYPOINT ["java","-jar","employee-management-system.jar"]