podTemplate(
            cloud: 'kubernetes', 
            label: 'terraform-podTemplate', 
            name: 'terraform-podTemplate',
            containers: [containerTemplate(
                                            alwaysPullImage: true, 
                                            args: '9999999', 
                                            command: 'sleep', 
                                            image: 'hashicorp/terraform:light', 
                                            livenessProbe: containerLivenessProbe(execArgs: '', 
                                            failureThreshold: 0, 
                                            initialDelaySeconds: 0, 
                                            periodSeconds: 0, 
                                            successThreshold: 0, 
                                            timeoutSeconds: 0), 
                                            name: 'terraform-con', 
                                            resourceLimitCpu: '', 
                                            resourceLimitEphemeralStorage: '', 
                                            resourceLimitMemory: '', 
                                            resourceRequestCpu: '', 
                                            resourceRequestEphemeralStorage: '', 
                                            resourceRequestMemory: '', 
                                            workingDir: '/home/jenkins/agent')])
            
            
             {
    
    node('terraform-podTemplate'){
        container('jnlp'){
            sh'''
            terraform -v
            '''
        }
        
        
    }
    
    
    
}