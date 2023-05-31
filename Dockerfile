FROM openjdk:17
EXPOSE 8080
ADD /target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ADD /src/main/resources/util/Free_Test_Data_10.5MB_PDF.pdf pdf.pdf
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]