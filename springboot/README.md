Directory of micro services implemented using Spring Boot.

See: http://projects.spring.io/spring-boot/

The micro services has a run.sh to start them using Docker. You need to have Docker installed, obviously.

See: https://www.docker.com/

The Docker images are pushed to the "atghackaton" registry at the Docker hub. 
It is public so you should be able to read it. 
To push a new version of a service, you need to have an account and be member of "atghackathon".
Also, you must issue the "docker login" command before you push.

See: https://hub.docker.com

Building the Docker images is done using Maven "sudo mvn package docker:build".

To read about using Docker with Spring Boot, see: https://spring.io/guides/gs/spring-boot-docker/
