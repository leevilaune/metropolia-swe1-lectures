pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        PATH = "/opt/homebrew/bin:/Applications/Docker.app/Contents/Resources/bin:${env.PATH}"
        DOCKERHUB_CREDENTIALS_ID = 'docker-pat'
        DOCKERHUB_REPO = 'leevivl/metropolia-tempconvert'
        DOCKER_IMAGE_TAG = 'latest'

        SSH_KEY_PATH = '~/.ssh/leevivl-875.pem'
        REMOTE_USER = 'leevivl'
        REMOTE_HOST = 'shell.metropolia.fi'
        REMOTE_PATH = '/home1-2/l/leevivl/public_html/tempconverter_jacoco'
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
                sh """
                    chmod 600 ${SSH_KEY_PATH}
                    scp -i ${SSH_KEY_PATH} -o StrictHostKeyChecking=no -r target/site ${REMOTE_USER}@${REMOTE_HOST}:${REMOTE_PATH}
                """
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "/opt/homebrew/bin/docker build -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} ."
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}",
                                                 usernameVariable: 'DOCKER_USER',
                                                 passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                        echo $DOCKER_PASS | /opt/homebrew/bin/docker login -u $DOCKER_USER --password-stdin
                        /opt/homebrew/bin/docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}
                    """
                }
            }
        }
    }
}