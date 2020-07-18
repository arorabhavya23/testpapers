pipeline {
    agent any
    stages {
        stage('Gradle build') {
            withGradle {
                buildInfo = rtGradle.run rootDir: "src/main/java/com/itelliexams/tests/", buildFile: 'build.gradle', bat label: '', script: 'gradlew clean build'
            }
        }

        stage ('Testing Stage') {
            steps {
                withGradle {
                    bat label: '', script: 'gradlew build'
                }
            }
        }

        stage ('Deployment Stage') {
            bat label: '', script: 'gradlew clean'
        }
    }
}