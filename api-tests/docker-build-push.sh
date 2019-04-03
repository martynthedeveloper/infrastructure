#!/usr/bin/env bash

set -x
TAG="martynpi/api-tests"

../gradlew clean build
docker build --file=Dockerfile --tag=${TAG} .
docker push ${TAG}

#docker run --publish 8080:8080 ${TAG}
#curl localhost:8080/actuator/info
