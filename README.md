# Jenkins CI/CD Pipeline for Maven Multi-Module Java Project

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=Jenkins&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=for-the-badge)](https://github.com/rohansonawane/581-ci-cd)
[![Java Version](https://img.shields.io/badge/Java-8%2C11%2C14%2C17-blue?style=for-the-badge)](https://www.oracle.com/java/technologies/)

</div>

## 📚 Technology Stack

### 🛠️ Core Technologies
- **Build Tool:** [Apache Maven](https://maven.apache.org/) 3.8.1+
- **CI/CD:** [Jenkins](https://www.jenkins.io/) LTS 2.387.3+
- **Version Control:** [Git](https://git-scm.com/) 2.30.0+
- **Testing Framework:** [JUnit](https://junit.org/junit5/) 5.10.1

### ☕ Java Versions
- Java 8 (LTS) - [Download](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
- Java 11 (LTS) - [Download](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- Java 14 - [Download](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)
- Java 17 (LTS) - [Download](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

### 🔌 Key Plugins & Tools
- [Jenkins Pipeline](https://www.jenkins.io/doc/book/pipeline/)
- [Maven Integration](https://plugins.jenkins.io/maven-plugin/)
- [Git Integration](https://plugins.jenkins.io/git/)
- [JUnit Integration](https://plugins.jenkins.io/junit/)
- [Workspace Cleanup](https://plugins.jenkins.io/ws-cleanup/)
- [Credentials Binding](https://plugins.jenkins.io/credentials-binding/)

### 🏗️ Build & Test Tools
- [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)
- [Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/)
- [Maven Source Plugin](https://maven.apache.org/plugins/maven-source-plugin/)
- [Maven Javadoc Plugin](https://maven.apache.org/plugins/maven-javadoc-plugin/)

## 🏗️ Technical Overview

This repository implements a robust CI/CD pipeline using Jenkins for a Maven-based Java project. The pipeline supports multiple JDK versions (8, 11, 14, 17) and implements comprehensive build, test, and deployment stages.

### 📁 Architecture

```
├── src/
│   ├── main/         # Main application source code
│   └── test/         # Test source code
├── target/           # Build output directory
├── pom.xml          # Maven project configuration
├── pipeline-script  # Jenkins pipeline definition
└── README.md        # Project documentation
```

## ⚙️ Technical Prerequisites

### 💻 System Requirements
- **Jenkins Server:**
  - Jenkins LTS version 2.387.3 or higher
  - Minimum 4GB RAM
  - 20GB free disk space
  - Java Runtime Environment (JRE) 11 or higher

### 🛠️ Required Software
- **Java Development Kit (JDK):**
  - JDK 8
  - JDK 11
  - JDK 14
  - JDK 17
- **Maven:**
  - Version 3.8.1 or higher
  - Configured with proper settings.xml
- **Git:**
  - Version 2.30.0 or higher
  - SSH key configured for repository access

### 🔌 Jenkins Plugins
- Pipeline
- Git Integration
- Maven Integration
- JUnit
- Workspace Cleanup
- Credentials Binding

## 🔄 Pipeline Architecture

### 📊 Build Matrix
The pipeline implements a matrix strategy to build and test against multiple JDK versions:

```groovy
matrix {
    axes {
        axis {
            name 'JDK_VERSION'
            values 'Java 14', 'Java 17'
        }
    }
}
```

### 🚀 Pipeline Stages

1. **📥 Checkout Stage**
   - Clones repository from specified branch
   - Configures Git credentials
   - Cleans workspace before checkout

2. **🏗️ Build Stage**
   - Compiles source code using Maven
   - Supports multiple JDK versions
   - Generates build artifacts

3. **🧪 Test Stage**
   - Executes JUnit tests
   - Generates test reports
   - Supports parallel test execution
   - Test results stored in `target/surefire-reports`

4. **📦 Package Stage**
   - Creates JAR/WAR artifacts
   - Generates source JARs
   - Creates Javadoc
   - Archives build artifacts

5. **🚀 Deploy Stage**
   - Deploys artifacts to configured repository
   - Supports multiple deployment targets
   - Implements deployment verification

## ⚙️ Maven Configuration

### 📦 Key Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.10.1</version>
    </dependency>
    <!-- Additional dependencies -->
</dependencies>
```

### 🔧 Build Profiles
- `java8`: Default profile for Java 8 compatibility
- `java11`: Java 11 specific configuration
- `java14`: Java 14 specific configuration
- `java17`: Java 17 specific configuration

## 🚀 Setup Instructions

### 1. 🔧 Jenkins Configuration

```bash
# Install required Jenkins plugins
jenkins-plugin-cli --plugins \
    pipeline:latest \
    git:latest \
    maven-plugin:latest \
    junit:latest \
    workspace-cleanup:latest
```

### 2. 🔄 Pipeline Setup

1. Create new pipeline in Jenkins:
   ```groovy
   pipeline {
       agent any
       tools {
           maven 'M3'
           jdk 'Java 14'
           jdk 'Java 17'
       }
       // Pipeline stages
   }
   ```

2. Configure Git repository:
   - URL: `https://github.com/rohansonawane/581-ci-cd.git`
   - Branch: `main`
   - Credentials: Configure Git credentials in Jenkins

### 3. 🔑 Environment Variables

Configure the following environment variables in Jenkins:
- `MAVEN_OPTS`: `-Xmx2048m -XX:MaxPermSize=512m`
- `JAVA_HOME`: Path to JDK installation
- `M2_HOME`: Path to Maven installation

## 📊 Monitoring and Maintenance

### 📈 Pipeline Monitoring
- View build history in Jenkins dashboard
- Monitor test results and coverage
- Track deployment status

### 📝 Logs and Artifacts
- Build logs: `target/build.log`
- Test reports: `target/surefire-reports`
- Coverage reports: `target/site/jacoco`

## 🔍 Troubleshooting

### 🚨 Common Issues

1. **🏗️ Build Failures**
   - Check Maven version compatibility
   - Verify JDK installation
   - Review dependency conflicts

2. **🧪 Test Failures**
   - Review test reports
   - Check test environment
   - Verify test dependencies

3. **🚀 Deployment Issues**
   - Verify repository credentials
   - Check network connectivity
   - Review deployment permissions

## 👥 Contributing

1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 💬 Support

For technical support:
- Create an issue in the repository
- Contact the maintainers
- Check the troubleshooting guide

---

<div align="center">
Made with ❤️ by [Rohan Sonawane](https://github.com/rohansonawane)
</div>
