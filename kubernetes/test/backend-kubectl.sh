#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-backend --url)/actuator/info -i'
echo ''
echo 'kubectl get services api-backend -owide'
echo 'curl <EXTERNAL-IP>:8080/actuator/info'
echo ''

set -x

kubectl delete -f api-backend.yml ; kubectl create -f api-backend.yml
