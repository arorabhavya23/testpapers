pipeline {
    agent any
    stages {
        stage('Gradle build') {
            buildInfo = rtGradle.run rootDir: "src/main/java/com/itelliexams/tests/", buildFile: 'build.gradle', bat label: '', script: 'gradlew clean build'
        }
    }

    stage ('Testing Stage') {
        steps {
            withMaven(maven : 'maven_3_5_0') {
                sh 'mvn test'
            }
        }
    }

    stage ('Deployment Stage') {
        steps {
        withMaven(maven : 'maven_3_5_0') {
                sh 'mvn deploy'
            }
        }
    }
}