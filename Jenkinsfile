pipeline {
    agent any

    environment {
        jobs = getJobs()
    }

    parameters {
        choice(name: 'ENV', choices:['DEV', 'QA', 'PROD'], description:'')
    }

    stages {
        stage('param_1') {
            steps {
                script {
                    def comm = readJSON text: "$commits"
                    echo comm.toString()
                    //def msg = readJSON text: "$commits[0].message"
                    def msg = "$comm_message"
                    echo msg
                    jobs.each {
                        echo it
                        if (msg.contains(it)) {
                            echo 'contains'
                            build job: it, parameters: [[string(name: 'ENV', value: "${params.ENV}")],
                            [$class: 'StringParameterValue', name: 'REF', value: "$ref"]]
                        }
                    }

                }

            }
        }
    }
}

def getJobs() {
    return ['test-params']
}