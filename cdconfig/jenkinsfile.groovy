def pipelineContext = [:]

pipeline{
    agent any

    environment {
        DOCKER_IMAGE_TAG = "dockertest:build-${env.BUILD_ID}"
    }
    stages{
        stage('Test environment'){
            steps{
                echo 'Logcat Maven version'
                bat 'mvn --version'
            }
        }
        stage('Build image'){
            steps{
                echo "Build docker image"
                script {
                    dockerImage = docker.build("${env.DOCKER_IMAGE_TAG}",  '-f .cdconfig/dockerfile .')
                    pipelineContext.dockerImage = dockerImage
                }
            }
        }
    }
}