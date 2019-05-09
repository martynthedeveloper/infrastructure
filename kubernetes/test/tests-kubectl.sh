#!/usr/bin/env bash

echo ''
echo 'curl $(minikube service api-tests --url)/actuator/info -i'
echo ''
echo 'wait for DNS replication'
echo 'curl <EXTERNAL-IP>:8080/actuator/info'
echo ''

set -x

kubectl delete -f api-tests.yml
kubectl create -f api-tests.yml
kubectl get services -owide
