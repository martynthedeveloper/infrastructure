#!/usr/bin/env bash


kubectl delete -f api-backend.yml
kubectl delete -f api-frontend.yml
kubectl delete -f api-tests.yml
