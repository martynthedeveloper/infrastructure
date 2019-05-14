#!/usr/bin/env bash

kubectl delete -f api-backend.yml
kubectl delete -f api-frontend.yml
kubectl delete -f api-tests.yml
kubectl delete -f api-ingress.yml
kubectl delete -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/mandatory.yaml
kubectl delete -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/provider/aws/service-l4.yaml
kubectl delete -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/provider/aws/patch-configmap-l4.yaml

./show-all.sh