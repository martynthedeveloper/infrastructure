#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-tests-blue --url)/actuator/info -i'
echo 'curl $(minikube service api-frontend-blue --url)/actuator/info -i'
echo 'curl $(minikube service api-backend-blue --url)/actuator/info -i'
echo ''

set -x

kubectl delete -f blue.yml ; kubectl create -f blue.yml
