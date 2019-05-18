#!/usr/bin/env bash

set -x

kops export kubecfg --state s3://${bucket_name}  --name=${KOPS_CLUSTER_NAME}