#!/usr/bin/env bash

kubectl apply -f api-backend.yml
kubectl apply -f api-frontend.yml
kubectl apply -f api-tests.yml
kubectl apply -f api-ingress.yml
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/mandatory.yaml
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/provider/aws/service-l4.yaml
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/master/deploy/provider/aws/patch-configmap-l4.yaml

echo ' Now manualy update CNAME ingress.k8s.nytram.io'
echo ' https://console.aws.amazon.com/route53/home?region=us-east-1#resource-record-sets:Z2HBR6C2ZT4NXS '

./show-all.sh