pipeline{
    agent any

    stages{
        stage('Test environment'){
            steps{
                echo 'Logcat Maven version'
                sh 'mvn --version'
            }
        }

        stage ('Compile stage'){
            steps {
                sh 'mvn clean clean'
            }
        }

        stage ('Deployment stage') {
            steps {
                sh 'mvn install'
            }
        }

        stage('Docker build image'){
            steps{
                sh 'docker build -f Dockerfile -t dockertest .'
            }
        }

        stage('Docker run'){
            steps{
                sh 'docker run -d -p 8096:8096 dockertest start'
            }
        }
    }
}