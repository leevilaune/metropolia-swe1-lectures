pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        PATH = "/opt/homebrew/bin:/Applications/Docker.app/Contents/Resources/bin:${env.PATH}"
        DOCKERHUB_CREDENTIALS_ID = 'docker-pat'
        DOCKERHUB_REPO = 'leevivl/metropolia-swe1-tempconverter'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/leevilaune/metropolia-swe1-lectures.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Copy Artifact to Server') {
            steps {
                sh "scp -i ${shell-metropolia-fi-ssh} -r target/site ${shell-path}/tempconverter-jacoco"
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}