#!/usr/bin/env bash

kubectl apply -f api-backend.yml
kubectl apply -f api-frontend.yml
kubectl apply -f api-tests.yml
kubectl apply -f api-ingress.yml
