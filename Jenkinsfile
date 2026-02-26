pipeline {
    agent any
    stages {
        stage("Hello World") {
            steps {
                sh '''
                echo "USER: $(whoami)"
                echo "PWD: $(pwd)"
                echo "PATH: $PATH"
                echo "Hello Jenkins is alive!"
                '''
            }
        }
    }
}