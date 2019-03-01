pipeline{
    agent any

    stages{
        stage('Test environment'){
            steps{
                echo 'Logcat Maven version'
                mvn --version
            }
        }

        stage ('Compile stage'){
            steps {
                mvn clean clean
            }
        }

        stage ('Deployment stage') {
            steps {
                mvn install
            }
        }

        stage('Docker build image'){
            steps{
                docker build -f Dockerfile -t dockertest .
            }
        }

        stage('Docker run'){
            steps{
                docker run -d -p 8096:8096 dockertest start
            }
        }
    }
}