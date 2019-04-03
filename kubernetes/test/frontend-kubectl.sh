#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-frontend --url)/actuator/info -i'
echo ''

set -x

kubectl delete -f api-frontend.yaml ; kubectl create -f api-frontend.yaml
