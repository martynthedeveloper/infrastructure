#!/usr/bin/env bash

set -x

minikube start
minikube addons enable ingress
eval $(minikube docker-env)

#minikube dashboard &

#minikube logs
