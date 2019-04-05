#!/usr/bin/env bash

set -x

../gradlew clean build docker dockerPush

#curl localhost:8080/actuator/info
