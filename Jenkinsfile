pipeline {
    agent any
    tools {
        maven 'apache-maven-3.6.3'
        }

    stages {
        stage('Build') {
            steps {
                bat 'mvn -DskipTests clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('My SonarQube Server'){
                    bat 'mvn sonar:sonar'
                }     
            }
	}
	    
	 stage('Sonar scan result check') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                    retry(3) {
                        script {
                            def qg = waitForQualityGate()
                            if (qg.status != 'OK') {
                                error "Pipeline aborted due to quality gate failure: ${qg.status}"
                            }
                        }
                    }
                }
            }
        }
    
        stage('Package Artifact') {
            steps {
                bat 'mvn package'
            }
        }
	stage('Deploy stage') {
            steps {
                echo 'Deployment...'
               bat 'mvn deploy'
            }
        }
    }
}
