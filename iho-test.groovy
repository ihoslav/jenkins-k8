def podname = 'terra-worker'

def podtemplate = """
metadata:
 name: $podname
 labels:
  app: $podname
spec:
 serviceAccountName: jenkins
  affinity:
    podAntiAffinity:
    requiredDuringSchedulingIgnoredDuringExecution:
    - labelSelector:
      matchExpressions:
      - key: component
        operator: In
        values:
        - jenkins-jenkins-master
      topologyKey: "kubernetes.io/hostname"

 containers:
 - name: $podname
   image: ikambarov/terraform:0.14
   args:
   - sleep
   - "999999999"

"""

podTemplate(
            cloud: 'kubernetes', 
            label: podname , 
            name: podname , 
            showRawYaml: false, 
            yaml: podtemplate ) {

node(podname){
 container(podname){
    sh'''
        terraform -v 
    '''

 }

}

    
}
