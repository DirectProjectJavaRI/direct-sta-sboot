FROM azul/zulu-openjdk-alpine:8u282-jre

# Run system update
RUN apk update
RUN apk upgrade --ignore zulu8-*
RUN apk add --no-cache --upgrade bash
RUN apk add --no-cache curl && \
    rm -rf /var/cache/apk/*

# When build images, name with this tag
LABEL tag=sta

# Build arguments
ARG BUILD_VERSION=8.1.0-SNAPSHOT

# Create and use local user and group
RUN addgroup -S direct && adduser -S -D direct -G direct

# Set application location
RUN mkdir -p /opt/app
RUN chown direct:direct /opt/app
ENV PROJECT_HOME /opt/app

# Set microservice
ENV CLOUD_CONFIG=true
ENV SERVICE_PORT=8083

# Set config-service access
ENV CONFIG_SERVICE_USERNAME=admin
ENV CONFIG_SERVICE_PASSWORD=direct
ENV CONFIG_SERVICE_HOST=config-service
ENV CONFIG_SERVICE_PORT=8082

# Set msg-monitor access
ENV MSG_MONITOR_HOST=msg-monitor
ENV MSG_MONITOR_PORT=8081

# Set XD access
ENV XD_HOST=xd
ENV XD_PORT=8087

# Set RabbitMQ env variables
ENV RABBIT_MQ_HOST=rabbitmq
ENV RABBIT_MQ_PORT=5672
ENV RABBIT_MQ_USERNAME=guest
ENV RABBIT_MQ_PASSWORD=guest

# Use local user and group
USER direct:direct

# Copy application artifact
COPY bootstrap.properties $PROJECT_HOME/bootstrap.properties
COPY application.properties $PROJECT_HOME/application.properties
COPY target/direct-sta-sboot-$BUILD_VERSION.jar $PROJECT_HOME/sta.jar

# Switching to the application location
WORKDIR $PROJECT_HOME

# Run application
CMD ["java","-jar","./sta.jar"]
