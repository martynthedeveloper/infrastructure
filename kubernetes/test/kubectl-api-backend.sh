#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-backend --url)/actuator/info -i'
echo ''

set -x

kubectl delete -f api-backend.yaml ; kubectl create -f api-backend.yaml
