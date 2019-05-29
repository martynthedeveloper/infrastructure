#!/usr/bin/env bash

kubectl config use-context k8s.nytram.io
kubectl config get-contexts
kubectl cluster-info
