node {
    stage 'Clone the project'
    git 'https://github.com/arorabhavya23/testpapers.git'

    stage("Compilation and Analysis") {
        parallel 'Compilation': {
            bat "./gradlew  bootrun --info"
        }
    }

    stage("Tests and Deployment") {
        parallel 'Unit tests': {
            stage("Runing unit tests") {
                try {
                    bat "./gradlew test -Punit"
                } catch(err) {
                    step([$class: 'JUnitResultArchiver', testResults:
                      '**/target/surefire-reports/TEST-*UnitTest.xml'])
                    throw err
                }
               step([$class: 'JUnitResultArchiver', testResults:
                 '**/target/surefire-reports/TEST-*UnitTest.xml'])
            }
        }, 'Integration tests': {
            stage("Runing integration tests") {
                try {
                    bat "./gradlew test -Pintegration"
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