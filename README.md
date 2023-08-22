# cnj-rest-downstream-spring

Cloud native Java application based on Spring Boot acting as downstream service consumed by the other backends.

## Synopsis

This downstream application returns the task permissions for the currently authenticated user. Right now, the following
task permissions are supported:

* `TASK_CREATE`: the user is allowed to create tasks for the current project
* `TASK_READ`: the user is allowed to read tasks
* `TASK_UPDATE`: the user is allowed to update tasks
* `TASK_DELETE`: the user is allowed to delete tasks

For the sake of simplicity, every user gets all permissions for all tasks for all projects.

It's mainly used to demonstrate the various approaches to REST clients in the upstream services. 

## Status

![Build status](https://codebuild.eu-west-1.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoic21SK3JkcFFYMjBLVk5sUnB2eHUwY0d3Q291dnZYYkliNHlSN1M3bFdUWnlUcmt0c2FzZVB2N3JoWHVOdFJtRGRBSEN4Z3lINlpSRkM3d28zMTRkVFIwPSIsIml2UGFyYW1ldGVyU3BlYyI6IlRXRDNmR1dmMk1NR0VBRkEiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=main)

## Release Information

A changelog can be found in [changelog.md](changelog.md).

## Docker Pull Command

`docker pull docker.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-rest-downstream-spring`

## HOW-TO build this application locally

If all prerequisites are met, just run the following Maven command in the project folder:

```shell 
mvn clean verify -P pre-commit-stage
```

Build results: a Docker image containing the showcase application.

## HOW-TO start and stop this showcase locally

In order to run the whole showcase locally, just run the following docker commands in the project folder:

```shell 
docker compose up -d
docker compose logs -f 
```

Press `Ctlr+c` to stop tailing the container logs and run the following docker command to stop the showcase:

```shell 
docker compose down
```

## HOW-TO demo this showcase

The showcase application will be accessible:
* locally via `http://localhost:38080`
* remotely via `https://train2023-dev.k8s.cloudtrain.aws.msgoat.eu/cloudtrain/cnj-rest-downstream-spring` (if the training cluster is up and running)

Granted permissions are returned when sending a HTTP request to URI `api/v1/grantedPermissions` with a JWT token representing an authenticated user.