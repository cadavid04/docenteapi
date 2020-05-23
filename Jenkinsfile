pipeline {
    agent any
    tools {
        maven 'apache-maven-3.6.3'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean verify'
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

        stage('Quality Gate') {
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

        stage('Artifactory Deploy'){
            when {
                branch "master"
            }
            steps{

                script {
                    def server = Artifactory.server('artifactory')
                    def rtMaven = Artifactory.newMavenBuild()
                    rtMaven.resolver server: server, releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot'
                    rtMaven.deployer server: server, releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local'
                    rtMaven.tool = 'apache-maven-3.6.3'
                    def buildInfo = rtMaven.run pom: 'pom.xml', goals: 'install'
                    server.publishBuildInfo buildInfo

                }
            }
        }

    }
}
