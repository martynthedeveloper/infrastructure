#!/usr/bin/env bash

set -x

kops validate cluster

kubectl get nodes
kubectl get pods
kops get clusters

kubectl get deployments -o wide --all-namespaces
kubectl get services -o wide --all-namespaces
kubectl get ingress -o wide --all-namespaces
kubectl describe ingress