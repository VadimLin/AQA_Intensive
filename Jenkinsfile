pipeline {
    agent any

    tools {
        allure 'allure'
    }

    parameters {
        string(name: 'branchName', defaultValue: 'master', description: 'Branch for build')
        string(name: 'config', defaultValue: 'AllTest', description: 'TestNG suite file(without .xml extension)')
        string(name: 'browser', defaultValue: 'chrome', description: 'Browser to use for tests')
        string(name: 'threadCount', defaultValue: '2', description: 'Number of parallel threads')
        booleanParam(name: 'selenoidEnable', defaultValue: true, description: 'Enable running on Selenoid')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: "${params.branchName}", url: 'https://github.com/VadimLin/AQA_Intensive.git', credentialsId: 'gh'
            }
        }

        stage('build & Test') {
            steps {
                script {
                    def testngFile = "src/test/resources/config/${params.config}.xml"
                    bat """
                    mvn clean test
                        -Dbrowser=${params.browser} ^
                        -DtestngXml=${testngFile} ^
                        -DthreadCount=${params.threadCount} ^
                        -DselenoidEnable=${params.selenoidEnable}
                """
                }
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