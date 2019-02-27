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
    }
}