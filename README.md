# Running and Testing
```bash

export JAVA_HOME=`/usr/libexec/java_home -v 1.8`

./gradlew clean build test
````

# minikube on Mac
```bash

brew cask upgrade
minikube stop; minikube delete; minikube start;
kubectl cluster-info
eval $(minikube docker-env)
minikube dashboard &
minikube logs
```

# docker
```bash

change all group = 'martynpi' in build.gradle

docker login
./gradlew clean build docker dockerPush

cd infrastructure/kubernetes/production
./kubectl-blue.sh

open ../endpoints.html

```

# aws on Mac
```bash

brew update
brew cask upgrade
brew doctor
brew install python

pushd ~/tmp
curl "https://s3.amazonaws.com/aws-cli/awscli-bundle.zip" -o "awscli-bundle.zip"
unzip awscli-bundle.zip
sudo ./awscli-bundle/install -i /usr/local/aws -b /usr/local/bin/aws
popd

sudo install -d -o $(whoami) -g admin /usr/local/Frameworks
/usr/local/aws/bin/pip list

aws configure

AWS Access Key ID [None]: *******************
AWS Secret Access Key [None]: *******************
Default region name [None]: 
Default output format [None]:

aws iam create-user --user-name mglewis

aws iam list-users

```
```json
{
    "Users": [
        {
            "UserName": "mglewis", 
            "PasswordLastUsed": "2015-05-18T17:34:45Z", 
            "CreateDate": "2012-07-17T13:07:09Z", 
            "UserId": "*******************", 
            "Path": "/", 
            "Arn": "arn:aws:iam::*******************:user/mglewis"
        }
    ]
}
```

# kops
```bash

https://medium.com/containermind/how-to-create-a-kubernetes-cluster-on-aws-in-few-minutes-89dda10354f4

brew install kops

aws iam list-roles

export AmazonEC2FullAccess=$(aws iam list-policies --query 'Policies[?PolicyName==`AmazonEC2FullAccess`].{ARN:Arn}' --output text) 
export AmazonRoute53FullAccess=$(aws iam list-policies --query 'Policies[?PolicyName==`AmazonRoute53FullAccess`].{ARN:Arn}' --output text) 
export AmazonS3FullAccess=$(aws iam list-policies --query 'Policies[?PolicyName==`AmazonS3FullAccess`].{ARN:Arn}' --output text) 
export AmazonVPCFullAccess=$(aws iam list-policies --query 'Policies[?PolicyName==`AmazonVPCFullAccess`].{ARN:Arn}' --output text) 

aws iam attach-user-policy --user-name mglewis --policy-arn $AmazonEC2FullAccess
aws iam attach-user-policy --user-name mglewis --policy-arn $AmazonRoute53FullAccess
aws iam attach-user-policy --user-name mglewis --policy-arn $AmazonS3FullAccess
aws iam attach-user-policy --user-name mglewis --policy-arn $AmazonVPCFullAccess

https://console.aws.amazon.com/iam/home?region=ap-southeast-2#/users/mglewis

```