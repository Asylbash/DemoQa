pipeline {
    agent any
    tools {
        maven "MAVEN"
    }
    parameters {
        choice(
            name: "PROJECT",
            choices: ['DemoQaWinter24', 'Orange'],
            description: 'Choose project'
        )
        choice(
            name: "TEST_SUITE",
            choices: ['Smoke', 'Regression', 'E2E', 'All'],
            description: 'Choose the suite of tests to run. Select "All" to run all suites.'
        )
        choice(
            name: "TEST_TYPE",
            choices: ['UI', 'API', 'NUMBER'],
            description: 'Choose the type of tests to run'
        )
    }
    stages {
        stage('Test') {
            steps {
                script {
                    def project = params.PROJECT ?: 'Smoke'
                    def testSuite = params.TEST_SUITE
                    def testType = params.TEST_TYPE ?: 'UI'
                    
                    def profiles = (testSuite == 'All') ? project : "${project},${testSuite}"

                    sh "mvn clean test -P ${profiles} -Dgroups=${testType} -DfailIfNoTests=false"
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
