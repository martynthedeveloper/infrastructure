#!/usr/bin/env bash


kubectl delete -f api-backend.yaml
kubectl delete -f api-frontend.yaml
kubectl delete -f api-tests.yaml
