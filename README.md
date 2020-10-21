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

## Step 2: Explore the APIs
Once the bundle is initialized you can start the portal (running `bundles/tomcat-9.0.37/bin/startup.sh`) and log in.

Once you are logged go to the url `http://localhost/o/api` to find the API Explorer and start exploring and trying the REST and GraphQL APIs.

Try creating some users and adding them to the site. Then recover them using the REST and GraphQL APIs

## Step 3: Extend the APIs
In Liferay 7.3 we add new features to extend our existing APIs very easy.

In this step we are adding and extension to the UserAccount existing resource in GraphQL implementing the GraphQLContributor interface.

The steps to follow are:
- Create a new module with blade `blade create -t service -s com.liferay.portal.vulcan.graphql.contributor.GraphQLContributor -p com.liferay.useraccount.extension user-account-extension`
- Implement the GraphQLContributor interface implementing a query contributor with the help of the @GraphQLTypeExtension annotation and GraphQLField
- Improve your GraphQLContributor connecting getting the information form a real external API.