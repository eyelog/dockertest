def pipelineContext = [:]

pipeline{
    agent any

    environment {
        DOCKER_IMAGE_TAG = "Dockerfile.build:build-${env.BUILD_ID}"
    }
    stages{
        stage('Test environment'){
            steps{
                echo 'Logcat Maven version'
                bat 'mvn --version'
            }
        }

        stage ('Compile stage'){
            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing stage') {
            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn test'
                }
            }
        }

        stage ('Deployment stage') {
            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn deploy'
                }
            }
        }

        stage('Docker system prune'){
            steps{
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'docker system prune -a -f'
                }
            }
        }

        stage('Docker build image'){
            steps{
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'docker build -f Dockerfile.build -t dockertest .'
                }
            }
        }

        stage('Docker run'){
            steps{
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'docker run -p 8097:8097 dockertest'
                }
            }
        }
    }
}