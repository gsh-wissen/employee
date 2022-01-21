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
/*        stage('Docker') {
                    steps {
                        script {
                                 docker.build("employee-management-system.jar")
                                }
                    }
                }
*/
          stage('Docker') {
                    steps {
                        script {
                             docker.withRegistry{
                                ("https://387115656091.dkr.ecr.ap-south-1.amazonaws.com","ecr:ap-south-1:AWS-credentials")
                                 {
                                    def imageName= docker.build("employee-management-system.jar")
                                    imageName.push()
                                 }
                             }
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
