pipeline {
    agent any
    parameters {
            choice(name: 'ENV', choices:['DEV', 'QA', 'PROD'], description:'')
        }
    
    stages {
        stage('param_1') {
            steps {
                echo "$ref"
                build job:"test-parametar-trigger", parameters: [string(name: 'ENV', value: "${params.ENV}")]
            }
        }
    }
}