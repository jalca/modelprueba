pipeline{
	agent any

	parameters {

        choice(name: 'SOURCE_KIND', choices: ['branch', 'commit', 'tag'], description: 'Origen del código del repositorio git.') 

        string(name: 'SOURCE', defaultValue: 'master', description: 'Branch, Commit Id o Tag del código del repositorio git.')
	
	}

	tools {
		jdk 'java11'
	}

	stages {

		stage('Checkout'){
            steps {
                script {
                   if(SOURCE_KIND == 'branch') {
                        checkout scmGit(branches: [[name: '*/${SOURCE}']])
                    } else {
                        checkout scmGit(branches: [[name: '${SOURCE}']])
                    }
                }
            }
        }

		stage('Build') {

            steps {
                sh '''
					mvn install  
				'''
            }
        }
		
	}

}
