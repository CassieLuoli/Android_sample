pipeline {
    agent any
    stages {
        stage('Build') {
          steps {
            echo 'Building..'
          }
        }
        stage('Test') {
          steps {
            echo 'Testing..'
          }
        }
        stage('Sanity check') {
          steps {
            input "Do you want to deploy to next stage?"
          }
        }
        stage('Deploy') {
          steps {
            echo 'Deploying....'
          }
        }
    }
}
