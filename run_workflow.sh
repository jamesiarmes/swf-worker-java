# Examples without the -cp option
export CLASSPATH='target/helloswf-1.0.jar:/home/jarmes/workspace/acquia/aws-java-sdk/libs/*:/home/jarmes/workspace/acquia/aws-java-sdk/third-party/lib/*'
java aws.example.helloswf.HelloTypes
java aws.example.helloswf.ActivityWorker &
java aws.example.helloswf.WorkflowWorker &
java aws.example.helloswf.WorkflowStarter

# An example of running with input data.
java aws.example.helloswf.WorkflowStarter "Thelonious"

# Examples with the -cp option
java -cp target/helloswf-1.0.jar:/path/to/sdk/libs/* aws.example.helloswf.HelloTypes

