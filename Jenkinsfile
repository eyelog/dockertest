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
    }
}