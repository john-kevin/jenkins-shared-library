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
    return message
}
