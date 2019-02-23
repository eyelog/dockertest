pipeline{
    agent none
    stages{
        stage('Test build'){
            steps{
                echo 'Logcat Maven version'
                bash 'mvn --version'
            }
        }
    }
}