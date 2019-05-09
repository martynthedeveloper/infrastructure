#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-frontend --url)/actuator/info -i'
echo ''
echo 'wait for DNS replication'
echo 'curl <EXTERNAL-IP>:8080/actuator/info'
echo ''

set -x

kubectl delete -f api-frontend.yml
kubectl create -f api-frontend.yml
kubectl get services -owide
