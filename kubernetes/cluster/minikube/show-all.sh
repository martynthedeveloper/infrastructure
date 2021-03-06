#!/usr/bin/env bash

set -x

kubectl config get-contexts
kubectl cluster-info

kubectl get nodes
kubectl get pods

kubectl get deployments -o wide --all-namespaces
kubectl get services -o wide --all-namespaces
kubectl get ingress -o wide --all-namespaces
kubectl describe ingress
