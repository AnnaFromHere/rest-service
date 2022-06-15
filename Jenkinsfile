node {
    def WORKSPACE = "/var/lib/jenkins/workspace/restservice-deploy"
    def dockerImageTag = "restservice-deploy${env.BUILD_NUMBER}"

    try{
//          notifyBuild('STARTED')
         stage('Clone Repo') {
            // for display purposes
            // Get some code from a GitHub repository
            git url: 'https://github.com/AnnaFromHere/rest-service.git',
                credentialsId: 'AnnaFromHere',
                branch: 'master'
         }
          stage('Build docker') {
                 dockerImage = docker.build("restservice-deploy:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker'){
                  echo "Docker Image Tag Name: ${dockerImageTag}"
                  sh "docker stop restservice-deploy || true && docker rm restservice-deploy || true"
                  sh "docker run --name restservice-deploy -d -p 8081:8081 restservice-deploy:${env.BUILD_NUMBER}"
          }
    }
}
