FROM  adoptopenjdk/openjdk11:jre-11.0.11_9-alpine
ENV APP_FILE division.jar
ENV APP_HOME /app
EXPOSE 8990
COPY target/*.jar $APP_HOME/$APP_FILE
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar -Djdk.tls.client.protocols=TLSv1.2 $APP_FILE"]