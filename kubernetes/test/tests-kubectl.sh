#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-tests --url)/actuator/info -i'
echo ''

set -x

kubectl delete -f api-tests.yaml ; kubectl create -f api-tests.yaml
