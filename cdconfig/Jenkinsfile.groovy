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

        stage('Build image'){
            steps{
                echo "Build docker image"
                script {
                    def customImage = docker.build("testset:${env.BUILD_ID}")
                    customImage.push()
                }
//                script {
//                    dockerImage = docker.build("${env.DOCKER_IMAGE_TAG}",  '-f .cdconfig/Dockerfile.build .')
//                    pipelineContext.dockerImage = dockerImage
//                }
            }
        }
    }
}