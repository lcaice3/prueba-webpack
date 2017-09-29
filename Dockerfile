FROM 628007708529.dkr.ecr.us-east-1.amazonaws.com/bdb-java8-oracle-alpine:1.0
MAINTAINER BdB <jparr17@bancodebogota.com.co>
ARG BDB_ENV
ARG BDB_AWS_ACCESS_KEY_ID
ARG BDB_AWS_SECRET_ACCESS_KEY
ARG BDB_AWS_ACCOUNT_ID
ARG BDB_SECRETS_FILE_ENV
ARG BDB_SECRETS_FILES_COUNT_ENV
VOLUME /tmp
ADD target/app.jar app.jar
RUN bash -c 'touch /app.jar'

ENV JAVA_APP_DIR /app
ENV SECRETS_BUCKET_NAME bdb-${BDB_ENV}-private
ENV BDB_SECRETS_FILE_NAME ${BDB_SECRETS_FILE_ENV}
ENV BDB_SECRETS_FILES_COUNT ${BDB_SECRETS_FILES_COUNT_ENV}
COPY entrypoint.sh /entrypoint.sh
RUN chmod 755 /entrypoint.sh

ENTRYPOINT [ "/entrypoint.sh" ]