def call(ip,cred,warfile){
sshagent([creds]) {
              // copy war file deploy tomcat server
              sh "scp -o StrictHostKeyChecking=no target/${warfile} ec2-user@${ip}:/opt/tomcat-9/webapps"
              // restart tomcat server
              sh "ssh ec2-user@${ip} /opt/tomcat-9/bin/shutdown.sh"
              sh "ssh ec2-user@${ip} /opt/tomcat-9/bin/startup.sh"
             }
}
