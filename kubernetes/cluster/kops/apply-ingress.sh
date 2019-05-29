#!/usr/bin/env bash

kubectl apply -f l4/mandatory.yaml
kubectl apply -f l4/service-l4.yaml
kubectl apply -f l4/patch-configmap-l4.yaml

echo ' Now manualy update CNAME ingress.k8s.nytram.io'
echo ' https://console.aws.amazon.com/route53/home?region=us-east-1#resource-record-sets:Z2HBR6C2ZT4NXS '
