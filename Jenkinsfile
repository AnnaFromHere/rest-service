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
                 dockerImage = docker.build("springboot-deploy:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker'){
                  echo "Docker Image Tag Name: ${dockerImageTag}"
                  sh "docker stop springboot-deploy || true && docker rm springboot-deploy || true"
                  sh "docker run --name springboot-deploy -d -p 8080:8080 springboot-deploy:${env.BUILD_NUMBER}"
          }
    }catch(e){
//         currentBuild.result = "FAILED"
        throw e
    }finally{
//         notifyBuild(currentBuild.result)
    }
}

