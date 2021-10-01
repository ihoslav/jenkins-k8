podTemplate(
            cloud: 'kubernetes', 
            label: 'debian-podTemplate', 
            name: 'debian-podTemplate',
            containers: [containerTemplate(
                                            alwaysPullImage: true, 
                                            args: '9999999', 
                                            command: 'sleep', 
                                            image: 'debian:10', 
                                            livenessProbe: containerLivenessProbe(execArgs: '', 
                                            failureThreshold: 0, 
                                            initialDelaySeconds: 0, 
                                            periodSeconds: 0, 
                                            successThreshold: 0, 
                                            timeoutSeconds: 0), 
                                            name: 'debian-con', 
                                            resourceLimitCpu: '', 
                                            resourceLimitEphemeralStorage: '', 
                                            resourceLimitMemory: '', 
                                            resourceRequestCpu: '', 
                                            resourceRequestEphemeralStorage: '', 
                                            resourceRequestMemory: '', 
                                            workingDir: '/home/jenkins/agent')])
            
            
             {
    
    node('debian-podTemplate'){
        container('debian-con'){
            sh'''
            whoami
            '''
        }
        
        
    }
    
    
    
}