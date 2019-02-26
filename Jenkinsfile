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
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn clean clean'
                }
            }
        }

        stage ('Deployment stage') {
            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn install'
                }
            }
        }

        stage('Docker build image'){
            steps{
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'docker build -f Dockerfile -t dockertest .'
                }
            }
        }

        stage('Docker run'){
            steps{
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'docker run -p 8096:8096 dockertest'
                }
            }
        }
    }
}