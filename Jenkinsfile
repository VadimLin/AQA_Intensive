pipeline {
    agent any

    tools {
        allure 'allure'
    }

    parameters {
        string(name: 'branchName', defaultValue: 'master', description: 'Branch for build')
        string(name: 'browser', defaultValue: 'chrome', description: 'Browser to use for tests')
        string(name: 'threadCount', defaultValue: '2', description: 'Number of parallel threads')
        booleanParam(name: 'selenoidEnable', defaultValue: true, description: 'Enable running on Selenoid')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${params.branchName}", url: 'https://github.com/VadimLin/AQA_Intensive.git', credentialsId: 'github-token'
            }
        }

        stage('build & Test') {
            steps {
                bat '''
                    ./mvn clean test \
                        -Dbrowser=${params.browser} \
                        -DthreadCount=${params.threadCount} \
                        -DselenoidEnable=${params.selenoidEnable}
                '''
            }
            post {
                always {
                    allure includeProperties:
                            false,
                            jdk:'',
                            results: [[path: 'target/allure-results']]
                }
            }
        }
    }
}