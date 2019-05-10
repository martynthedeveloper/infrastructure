#!/usr/bin/env bash

# https://www.edureka.co/blog/kubernetes-ingress-controller-nginx

set -x

kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/mandatory.yaml
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/provider/aws/service-l4.yaml
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/provider/aws/patch-configmap-l4.yaml

kubectl get pods --all-namespaces
kubectl get svc --all-namspaces

kubectl apply -f ingress.yaml
