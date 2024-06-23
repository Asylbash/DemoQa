pipeline {
    agent any

    tools {
        maven "MAVEN"
    }

    parameters {
        choice(
            name: 'PROJECT',
            choices: ['DemoQaWinter24'],
            description: 'Choose project'
        )
        choice(
            name: 'TEST_SUITE',
            choices: ['Smoke', 'Regression', 'E2E'],
            description: 'Test Suite'
        )
        string(
            name: "TEST_CASE_ID",
            defaultValue: "",
            description: 'Enter the ID of the test case, or TYPE: API, UI'
        )
    }

    stages {
        stage('Test') {
            steps {
                script {
                    def project = params.PROJECT ?: 'DemoQaWinter24'
                    def testSuite = params.TEST_SUITE ?: 'UI'
                    def testCaseId = params.TEST_CASE_ID ?: ''

                    echo "Running tests for project: ${project}, test suite: ${testSuite}, test case ID: ${testCaseId}"
                    sh "mvn clean test -P${testSuite} -DtestCaseId=${testCaseId} -DfailIfNoTests=false"
                }
            }

            post {
                always {
                    echo 'Publishing Allure results...'
                    allure([
                        includeProperties: false,
                        jdk: '17.0.3',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
        always {
            cleanWs()
        }
    }
}
