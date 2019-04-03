#!/usr/bin/env bash

kubectl delete -f api-blue.yml
kubectl delete -f api-green.yml
kubectl delete -f load-ballancer.yml
kubectl delete -f load-ballancer-blue.yml
kubectl delete -f load-ballancer-green.yml
