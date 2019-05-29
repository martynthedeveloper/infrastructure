#!/usr/bin/env bash

kubectl config use-context docker-for-desktop
kubectl config get-contexts
kubectl cluster-info
