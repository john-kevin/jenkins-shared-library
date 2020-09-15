package org.foo

def info(message) {
    println "The message below was invoked in this function"
    echo "${message}"
}


def checkout(String branch) {
    echo "Checking out branch ${branch}"
    checkout([
        $class: 'GitSCM',
        branches: [
            [
                name: "${branch}"
            ]
        ],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [
            [
                credentialsId: 'private-repo',
                url: env.GIT_URL
            ]
        ]
    ])
}

def printer(String message) {

    MENSAHE = "${message}"

    if ( MENSAHE == 'kevin') {
        echo "kuha mo!"
    }
    // String[][] arrStr = [message, 'awsapi', 'awsstg', 'version']
    def colors = [red: "#FF0000", green:"#00FF00", blue: "#0000FF", kev: MENSAHE]
    // def doctor = [name: "Oliver","block-no":33,speciality:"Cardiology"]
    return colors
}

def initialize(String branch) {
    BRANCH_NAME = "${branch}"

    ENVIRONMENT = 'dev'
    PM_CREDENTIALS_ID  = 'aws-prospect-dev'
    API_CREDENTIALS_ID = 'aws-api-uat'

    if (BRANCH_NAME == 'origin/master') {
      PM_CREDENTIALS_ID  = 'aws-prospect-prd'
      API_CREDENTIALS_ID = 'aws-api-prd'
      ENVIRONMENT        = 'prd'
      //Always create new version of stack for master build
      // VERSION = readFile 'microservices/build/version'
    } else if (BRANCH_NAME == 'staging') {
      PM_CREDENTIALS_ID = 'aws-prospect-stg'
      ENVIRONMENT    = 'stg'
    } else if (BRANCH_NAME == 'dit') {
      ENVIRONMENT    = 'dit'
    }


    // def response = [red: "#FF0000", green:"#00FF00", blue: "#0000FF"]
    def response = [ PM_CREDENTIALS_ID: PM_CREDENTIALS_ID,
                   API_CREDENTIALS_ID: API_CREDENTIALS_ID,
                   ENVIRONMENT: ENVIRONMENT]

    return response
}
