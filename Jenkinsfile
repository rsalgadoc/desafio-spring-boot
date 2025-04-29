pipeline {
    agent { label 'Worker'}

        environment{
            DOCKER_IMAGE = 'taskmanagement'
            IMAGE_TAG = 'latest'
            DOCKER_CREDENTIALS = 'DOCKER_CREDENTIALS'  // Jenkins credentials ID for Docker Hub or your registry
            USERNAME= 'rsalgadoc'
        }

        stages{
            
            stage('Checkout Code'){
                steps{
                    echo "Clonning the Code"
                    
                    script{
                        git url: 'https://github.com/rsalgadoc/desafio-spring-boot.git', branch: 'main'
                    }
                }
            }

            stage('Build'){
                steps{
                    echo "Bulding latest docker image"
                    
                    script{
                        sh 'docker build -t ${DOCKER_IMAGE}:${IMAGE_TAG} .'
                    }
                }
            }

            stage('Login to Docker Hub') {
            steps {
                    echo "Login to Docker Hub with Jenkins Credentials"
                    
                    script {
                    withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDENTIALS}", passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"}
                    }
                }
            }

            stage("Tag and Push"){
                steps{
                    echo "Push the Docker Image to Docker Hub"

                    script {
                    sh 'docker tag ${DOCKER_IMAGE}:${IMAGE_TAG} ${USERNAME}/${DOCKER_IMAGE}:${IMAGE_TAG}'
                    sh 'docker push ${USERNAME}/${DOCKER_IMAGE}:${IMAGE_TAG}'
                    }
                } 
            }     

            stage("Deploy"){
                steps{
                    echo "Deploy the Application"

                    script {
                    sh 'docker compose down && docker compose up -d'
                    }
                } 
            }
        }
    }