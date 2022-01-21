pipeline {
    agent any
    tools{
        maven '3.8.4'
    }
    
    environment {
        AWS_ACCOUNT_ID="387115656091"
        AWS_DEFAULT_REGION="ap-south-1" 
        IMAGE_REPO_NAME="capitalone_poc"     
        REPOSITORY_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
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

          stage('Docker') {
                    steps {
                        script {
                             /*docker.withRegistry("https://387115656091.dkr.ecr.ap-south-1.amazonaws.com/capitalone_poc","ecr:ap-south-1:AWS-credentials")
                                 {
                                    def imageName= docker.build("employee-management-system.jar")
                                    imageName.push()
                                 }*/
                            docker.build("employee-management-system.jar")
                            sh "docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
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
