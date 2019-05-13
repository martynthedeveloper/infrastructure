#!/usr/bin/env bash

kubectl delete -f e2e-deploy.yaml
kubectl delete -f e2e-service.yaml
kubectl delete -f e2e-ingress.yaml

./show-all.sh