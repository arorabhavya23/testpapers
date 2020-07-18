node {
    stage 'Clone the project'
    git 'https://github.com/arorabhavya23/testpapers.git'

    stage("Compilation and Analysis") {
        parallel 'Compilation': {
            bat "./gradlew  build --info"
        }
    }

    stage("Junit Tests") {
        parallel 'Unit tests': {
            stage("Runing unit tests") {
                bat "./gradlew test --info"
            }
        }
    }
    stage("clean build stage") {
            parallel 'Integration tests': {
            stage("Runing clean build") {
                try {
                    bat "./gradlew clean build --info"
                } catch(err) {
                    step([$class: 'JUnitResultArchiver', testResults:
                        '**/build/test-results/test/TEST-com.itellieams.tests.'
                        + 'TestpapersApplicationTests.xml'])
                    throw err
                }
                step([$class: 'JUnitResultArchiver', testResults:
                  '**/build/test-results/test/TEST-com.itellieams.tests.'
                    + 'TestpapersApplicationTests.xml'])
            }
        }
    }
}