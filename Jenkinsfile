pipeline{
    agent any
     
    triggers {
        cron('H/4 * * * 1-5')
        pollSCM('0 0 * * 0')
    }
    stages {      
        stage ('Build and Test') {
            steps {
                 
                withMaven(maven: 'maven') {
                    sh "mvn clean install"
                }
            }
        }
     }
 
    post {
        always {
            script {
                GIT_COMMIT_EMAIL = sh (
                    script: 'git --no-pager show -s --format=\'%ae\'',
                    returnStdout: true
                ).trim()
                 
                if(env.BRANCH_NAME == "development" || env.BRANCH_NAME == "master"){
                    EMAIL = 'Mohamed-Abderrahmen.Amara@adesso.de'
                } else {
                    EMAIL = GIT_COMMIT_EMAIL
                }
            }
        }
         
        fixed {
            script {
                echo 'sende Email zu ' + EMAIL
 
                mail to: EMAIL,
                    subject: "Pipeline Fixed: ${currentBuild.fullDisplayName}",
                    body: "Gut gemacht! Pipeline funktionert wieder ${env.BUILD_URL}"                
            }
        }
         
        unstable {
            script {
                echo 'sende Email zu ' + EMAIL
 
                mail to: EMAIL,
                    subject: "Unstable Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Build Unstable ${env.BUILD_URL}"                
            }
        }
         
        failure {
            script {
                echo 'sende Email zu ' + EMAIL
 
                mail to: EMAIL,
                    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Build Failure ${env.BUILD_URL} in dem ${env.BRANCH_NAME} Branch"                
            }
        }
    }
 
}
