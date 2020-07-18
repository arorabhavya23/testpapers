node {
    stage 'Clone the project'
    git 'https://github.com/arorabhavya23/testpapers.git'

    stage("Compilation and Analysis") {
        parallel 'Compilation': {
            bat "./gradlew  build --info"
        }
    }

    stage("Junit Tests and Deployment") {
        parallel 'Unit tests': {
            stage("Runing unit tests") {
                try {
                    bat "./gradlew test --info"
                } catch(err) {
                    step([$class: 'JUnitResultArchiver', testResults:
                      '**/target/surefire-reports/TEST-*UnitTest.xml'])
                    throw err
                }
               step([$class: 'JUnitResultArchiver', testResults:
                 '**/target/surefire-reports/TEST-*UnitTest.xml'])
            }
        }, 'Integration tests': {
            stage("Runing clean build") {
                try {
                    bat "./gradlew clean build --info"
                } catch(err) {
                    step([$class: 'JUnitResultArchiver', testResults:
                      '**/target/surefire-reports/TEST-'
                        + '*IntegrationTest.xml'])
                    throw err
                }
                step([$class: 'JUnitResultArchiver', testResults:
                  '**/target/surefire-reports/TEST-'
                    + '*IntegrationTest.xml'])
            }
        }
    }
}