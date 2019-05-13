#!/usr/bin/env bash


# docker run -p 8087:8080 gcr.io/kubernetes-e2e-test-images/echoserver:2.2

kubectl apply -f e2e-deploy.yaml
kubectl apply -f e2e-service.yaml
kubectl apply -f e2e-service-node-port.yaml
kubectl apply -f e2e-ingress.yaml

./show-all.sh

sleep 5

./test-all.sh