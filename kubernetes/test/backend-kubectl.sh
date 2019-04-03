#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-backend --url)/actuator/info -i'
echo ''

set -x

kubectl delete -f api-backend.yml ; kubectl create -f api-backend.yml
