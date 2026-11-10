pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out Student Management System'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application'
                bat 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: Student Management System built successfully!'
        }

        failure {
            echo 'FAILURE: Please check the Jenkins Console Output.'
        }
    }
}