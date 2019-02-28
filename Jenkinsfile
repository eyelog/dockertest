pipeline{
    agent any

    stages{
        stage('Test environment'){
            steps{
                echo 'Logcat Maven version'
                bat 'mvn --version'
            }
        }

        stage ('Compile stage'){
            steps {
                bat 'mvn clean clean'
            }
        }

        stage ('Deployment stage') {
            steps {
                bat 'mvn install'
            }
        }

        stage('Docker clean old image'){
            steps{
                bat 'docker rm dockertest dockertest'
                bat 'docker rmi dockertest dockertest'
            }
        }

        stage('Docker build image'){
            steps{
                bat 'docker build -f Dockerfile -t dockertest .'
            }
        }

        stage('Docker run'){
            steps{
                bat 'docker run -d -p 8096:8096 dockertest start'
            }
        }
    }
}