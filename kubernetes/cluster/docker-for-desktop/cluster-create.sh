#!/usr/bin/env bash

set -x

Start it using Docker Desktop UI

kubectl create -f https://raw.githubusercontent.com/kubernetes/kops/master/addons/kubernetes-dashboard/v1.10.1.yaml

kubectl proxy &

kubectl -n kube-system describe secret default

open "http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/#!/login"

# $TOKEN=`kubectl -n kube-system describe secret default | Select-String "token:"` -split " +")[1]
# kubectl config set-credentials docker-for-desktop --token="${TOKEN}"
