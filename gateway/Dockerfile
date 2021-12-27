FROM  adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
ENV APP_FILE gateway.jar
ENV APP_HOME /app
EXPOSE 8995
COPY target/*.jar $APP_HOME/$APP_FILE
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar -Djdk.tls.client.protocols=TLSv1.2 $APP_FILE"]