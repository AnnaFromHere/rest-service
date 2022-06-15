pipeline {
    agent none
    stages {
        stage('Build') {
            agent { docker 'maven:3.6.3-jdk-17' }
            steps {
                echo 'Hello, Maven'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Run') {
            agent { docker 'openjdk:17.0.1-jdk-slim' }
            steps {
                echo 'Hello, JDK'
                sh 'java -jar target/rest-service-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}