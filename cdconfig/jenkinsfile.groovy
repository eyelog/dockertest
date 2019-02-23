pipeline{
    agent any
    stages{
        stage('Test build'){
            steps{
                echo 'Logcat Maven version'
                bat 'mvn --version'
            }
        }
    }
}