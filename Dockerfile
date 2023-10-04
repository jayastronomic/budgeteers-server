
#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/budgeteer-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=4000
EXPOSE 4000
ENTRYPOINT ["java","-jar","demo.jar"]