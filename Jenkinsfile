pipeline {
    agent any
    
    stages {
        stage('param_1') {
            when {
                expression{
                    "$x_github_event" =='push'
                }
            }
            steps {
                echo "$ref"
                build job:"pushJob"
            }
        }
        stage('param_2') {
            when {
                expression{
                    "$x_github_event" =='pull_request'
                }
            }    
            steps {
                echo "$action"
                build job:"pullJob"
            }
        }
        stage('param_3') {
            when {
                expression{
                    "$x_github_event" =='issue_comment'
                }
            }    
            steps {
                echo "${comment}"
                build job:"commentJob"
            }
        }
    }
}