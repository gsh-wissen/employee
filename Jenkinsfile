pipeline {
    agent any
    tools{
        maven '3.8.4'
    }
      stages {
        stage('Hello') {
            steps {
                echo 'Employee-management-system'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean install -DskipTests=true'
            }
        }
        stage('Docker') {
                    steps {
                        script {
                                 docker.build("employee-management-system.jar")
                                }
                    }
                }
        stage('Test') {
            steps {
                echo 'Test..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
            }
        }
        stage('Release') {
            steps {
                echo 'Release..'
            }
        }
    }
}