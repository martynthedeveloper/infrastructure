#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service starter-rest-api-client --url)/actuator/info -i'
echo ''

set -x

kubectl delete -f blue.yml ; kubectl create -f blue.yml
