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

        stage ('Start jar') {
            steps {
                def result = bat 'java -jar target/dockertest.jar'
                echo $result
            }
        }
    }
}