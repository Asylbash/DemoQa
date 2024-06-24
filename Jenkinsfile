pipeline {
    agent any
    tools {
        maven "MAVEN"
    }
    parameters {
        choice(
            name: "PROJECT",
            choices: ['Smoke', 'Regression', 'E2E'],
            description: 'Choose project'
        )
        choice(
            name: "TEST_TYPE",
            choices: ['UI', 'API'],
            description: 'Choose the type of tests to run'
        )
    }
    stages {
        stage('Test') {
            steps {
                script {
                    def project = params.PROJECT ?: 'Smoke'
                    def testType = params.TEST_TYPE ?: 'UI'
                    sh "mvn clean test -P $project -Dgroups=$testType -DfailIfNoTests=false"
                }
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '17.0.1',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
