# Jenkins CI/CD Implementation for Maven Multi Java Project

## Overview

This repository contains the Jenkins CI/CD pipeline configuration for automating the build, test, and deployment process of a Maven multi-module Java project.

## Prerequisites

- Jenkins installed and configured.
- Maven installed on the Jenkins server.
- JDK installed on the Jenkins server.
- Git installed on the Jenkins server.
- Access to the Git repository containing the Maven multi-module Java project.

## Setup Instructions

1. Clone this repository to your local machine: git clone https://github.com/rohansonawane/581-ci-cd.git


2. Open Jenkins and create a new pipeline project:

- Navigate to Jenkins dashboard.
- Click on "New Item".
- Enter a name for your pipeline project.
- Select "Pipeline" and click "OK".

3. Configure your pipeline:

- In the pipeline configuration page, under "Pipeline" section, choose "Pipeline script from SCM".
- Choose your SCM (Git) and provide the repository URL.
- Specify the branch to build.
- Save your pipeline configuration.

4. Configure Jenkins credentials:

- If your Git repository requires authentication, set up credentials in Jenkins.
- Navigate to Jenkins dashboard -> Credentials -> System -> Global credentials (unrestricted) -> Add Credentials.
- Enter your Git credentials and save.

5. Trigger your pipeline:

- Manually trigger the pipeline for the first time by clicking "Build Now" on the pipeline page.
- The pipeline will automatically clone the repository, build the Maven project, run tests, and deploy artifacts.

## Pipeline Stages

1. **Checkout**: Clones the Git repository containing the Maven multi-module Java project.
2. **Build**: Executes Maven build commands to compile the Java code and package the project artifacts.
3. **Test**: Runs automated tests to ensure code quality and functionality.
4. **Deploy**: Deploys the built artifacts to the target environment.
5. **Cleanup**: Performs cleanup tasks after the pipeline execution.

## Notes

- Update the `Jenkinsfile` in this repository according to your project's specific requirements and structure.
- Ensure proper configuration of Jenkins agents and environment variables for seamless pipeline execution.
- Monitor pipeline execution logs and handle any failures or errors accordingly.
