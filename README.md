# Liferay Travels

Liferay Workspace with the backend for the Liferay Symposium Spain 2020 Workshop: Building a SPA to squeeze Headless APIs.

To build the front-end we will build a SPA in React following the steps in the [Liferay Travels Front](https://github.com/LuismiBarcos/Liferay-Travels-Front) repository.

## Purpose
Explore the existing and new features added in Liferay 7.3 in the Headless APIs focusing in:
- Extend existing APIs
- Create a custom API

## Step 0: Pre-requisites

Some pre-requisites must be achieved to be able to follow the workshop

### Required software: 
* Java 8 or Java 11 JDK
* [Git](https://git-scm.com/)
* [Blade](https://help.liferay.com/hc/en-us/articles/360018164591-Blade-CLI) (optional but strongly recommended)

### Required knowledge:
* Experience with Java and Liferay is required.
* Knowledge of APIs (REST or GraphQL) and OpenAPI specification is recommended.

## Step 1: Prepare environment
To avoid wasting time during the workshop it is strongly recommended to initialize the Liferay Workspace with one of the following commands:
`blade server init` or `gw initBundle`. This commands will download the Liferay bundle, which size is about 1GB.

We will use the Liferay Portal 7.3 GA6 version. A Liferay service module is provided to be used during the workshop.