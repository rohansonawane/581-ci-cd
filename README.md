# Jenkins CI/CD Pipeline for Maven Multi-Module Java Project

## Technology Stack

### Core Technologies
- **Build Tool:** Apache Maven 3.8.1+
- **CI/CD:** Jenkins LTS 2.387.3+
- **Version Control:** Git 2.30.0+
- **Testing Framework:** JUnit 5.10.1

### Java Versions
- Java 8 (LTS)
- Java 11 (LTS)
- Java 14
- Java 17 (LTS)

### Key Plugins & Tools
- Jenkins Pipeline
- Maven Integration
- Git Integration
- JUnit Integration
- Workspace Cleanup
- Credentials Binding

### Build & Test Tools
- Maven Surefire Plugin
- Maven Compiler Plugin
- Maven Source Plugin
- Maven Javadoc Plugin

## Technical Overview

This repository implements a robust CI/CD pipeline using Jenkins for a Maven-based Java project. The pipeline supports multiple JDK versions (8, 11, 14, 17) and implements comprehensive build, test, and deployment stages.

### Architecture

```
├── src/
│   ├── main/         # Main application source code
│   └── test/         # Test source code
├── target/           # Build output directory
├── pom.xml          # Maven project configuration
├── pipeline-script  # Jenkins pipeline definition
└── README.md        # Project documentation
```

## Technical Prerequisites

### System Requirements
- **Jenkins Server:**
  - Jenkins LTS version 2.387.3 or higher
  - Minimum 4GB RAM
  - 20GB free disk space
  - Java Runtime Environment (JRE) 11 or higher

### Required Software
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

### Jenkins Plugins
- Pipeline
- Git Integration
- Maven Integration
- JUnit
- Workspace Cleanup
- Credentials Binding

## Pipeline Architecture

### Build Matrix
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

### Pipeline Stages

1. **Checkout Stage**
   - Clones repository from specified branch
   - Configures Git credentials
   - Cleans workspace before checkout

2. **Build Stage**
   - Compiles source code using Maven
   - Supports multiple JDK versions
   - Generates build artifacts

3. **Test Stage**
   - Executes JUnit tests
   - Generates test reports
   - Supports parallel test execution
   - Test results stored in `target/surefire-reports`

4. **Package Stage**
   - Creates JAR/WAR artifacts
   - Generates source JARs
   - Creates Javadoc
   - Archives build artifacts

5. **Deploy Stage**
   - Deploys artifacts to configured repository
   - Supports multiple deployment targets
   - Implements deployment verification

## Maven Configuration

### Key Dependencies
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

### Build Profiles
- `java8`: Default profile for Java 8 compatibility
- `java11`: Java 11 specific configuration
- `java14`: Java 14 specific configuration
- `java17`: Java 17 specific configuration

## Setup Instructions

### 1. Jenkins Configuration

```bash
# Install required Jenkins plugins
jenkins-plugin-cli --plugins \
    pipeline:latest \
    git:latest \
    maven-plugin:latest \
    junit:latest \
    workspace-cleanup:latest
```

### 2. Pipeline Setup

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

### 3. Environment Variables

Configure the following environment variables in Jenkins:
- `MAVEN_OPTS`: `-Xmx2048m -XX:MaxPermSize=512m`
- `JAVA_HOME`: Path to JDK installation
- `M2_HOME`: Path to Maven installation

## Monitoring and Maintenance

### Pipeline Monitoring
- View build history in Jenkins dashboard
- Monitor test results and coverage
- Track deployment status

### Logs and Artifacts
- Build logs: `target/build.log`
- Test reports: `target/surefire-reports`
- Coverage reports: `target/site/jacoco`

## Troubleshooting

### Common Issues

1. **Build Failures**
   - Check Maven version compatibility
   - Verify JDK installation
   - Review dependency conflicts

2. **Test Failures**
   - Review test reports
   - Check test environment
   - Verify test dependencies

3. **Deployment Issues**
   - Verify repository credentials
   - Check network connectivity
   - Review deployment permissions

## Contributing

1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For technical support:
- Create an issue in the repository
- Contact the maintainers
- Check the troubleshooting guide
