#!/usr/bin/env bash

set -x

kubectl get deployments -o wide --all-namespaces
kubectl get services -o wide --all-namespaces
kubectl get ingress -o wide --all-namespaces
kubectl describe ingress