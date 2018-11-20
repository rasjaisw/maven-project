pipeline {
    agent any

    parameters {
         string(name: 'tomcat_dev', defaultValue: 'localhost', description: 'Staging Server')
         string(name: 'tomcat_prod', defaultValue: 'localhost', description: 'Production Server')
    }

    triggers {
         pollSCM('* * * * *')
     }

stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        sh "sudo cp **/target/*.war /home/ubuntu/apache-tomcat-8.5.35-staging/webapps"
                    }
                }

                stage ("Deploy to Production"){
                    steps {
                        sh "sudo cp **/target/*.war /home/ubuntu/apache-tomcat-8.5.35-prod/webapps"
                    }
                }
            }
        }
    }
}
