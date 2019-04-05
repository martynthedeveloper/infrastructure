#!/usr/bin/env bash

kubectl delete -f blue.yml
kubectl delete -f green.yml
kubectl delete -f load-ballancer.yml
kubectl delete -f load-ballancer-blue.yml
kubectl delete -f load-ballancer-green.yml
