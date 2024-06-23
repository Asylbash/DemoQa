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
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                checkout([$class: 'GitSCM',
                          branches: [[name: '*/main']], // Убедись, что имя ветки соответствует твоей
                          userRemoteConfigs: [[url: 'https://github.com/Asylbash/DemoQa.git']]
                ])
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh "mvn clean package"
            }
        }

        stage('Test') {
            steps {
                script {
                    def project = params.PROJECT ?: 'DemoQaWinter24'
                    def testSuite = params.TEST_SUITE ?: 'Smoke'

                    echo "Running tests for project: ${project}, test suite: ${testSuite}"
                    sh "mvn clean test -P${testSuite} -DtestCaseId=${project} -DfailIfNoTests=false"
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