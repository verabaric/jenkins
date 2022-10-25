pipeline {
    agent any

    environment {
        jobs = getJobs()
    }

    parameters {
        string(name: 'COMMENT', defaultValue: 'test-params', description: 'desc')
        string(name: 'BRANCH', defaultValue: 'master', description: 'desc')
    }

    stages {
        stage('triger build') {
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
                            build job: it, parameters: [[$class: 'StringParameterValue', name: 'BRANCH', value: "${params.BRANCH}"],
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