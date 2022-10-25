pipeline {
    agent any
    parameters {
            choice(name: 'ENV', choices:['DEV', 'QA', 'PROD'], description:'')
        }
    
    stages {
        stage('param_1') {
            when {
                expression{
                    "$x_github_event" =='push'
                }
            }
            steps {
                echo "${ref}"
                build job:"pushJob"
            }
        }
        stage('param_2') {
            when {
                expression{
                    "$x_github_event" =='pull-request'
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
                    "$x_github_event" =='issue-comment'
                }
            }    
            steps {
                echo "${comment}"
                build job:"commentJob"
            }
        }
    }
}