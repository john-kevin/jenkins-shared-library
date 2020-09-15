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
    def colors = [red: "#FF0000", green:"#00FF00", blue: "#0000FF"]
    // def doctor = [name: "Oliver","block-no":33,speciality:"Cardiology"]
    return colors
}
