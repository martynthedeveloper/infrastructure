#!/usr/bin/env bash

set -x

kubectl get deployments -o wide
kubectl get services -o wide
kubectl get ingress -o wide