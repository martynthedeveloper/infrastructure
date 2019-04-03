#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-tests --url)/actuator/info -i'
echo 'curl $(minikube service api-frontend --url)/actuator/info -i'
echo 'curl $(minikube service api-backend --url)/actuator/info -i'
echo ''

# curl -H "Content-Type: application/json" -X POST -d '{"name":"martyn","country":"uk"}' $(minikube service api-backend --url)/departments -i

set -x

kubectl delete -f blue.yml ; kubectl create -f blue.yml
