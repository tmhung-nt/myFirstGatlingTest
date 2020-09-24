# myFirstGatlingTest   
=========================

Simple showcase of a maven project using the gatling-maven-plugin.

## To test it out in command line, simply execute the following command:

    mvn gatling:test -Dgatling.simulationClass=video_game_db.test_scenarios
    
    mvn gatling:test -Dgatling.simulationClass=computerdatabase.advanced.AdvancedSimulationStep02
    
or simply:

    mvn gatling:test

 ## Run on AWS Fargate
 https://medium.com/@richard.hendricksen/distributed-load-testing-with-gatling-using-docker-and-aws-d497605692db

## From Intellij IDEA, run one of following classes
- Engine
- Gatling Runner (need to add a particular class name first then we can run in debug mode as well)

## API Service  
http://video-game-db.eu-west-2.elasticbeanstalk.com/swagger-ui/index.html

## References
https://www.james-willett.com/debug-gatling/  
https://www.james-willett.com/gatling-load-testing-complete-guide  
https://maxchadwick.xyz/blog/gatling-multiplier
https://www.baeldung.com/jenkins-run-gatling-tests

### Notes
1. rampUsersPecSec Explaination

    rampUsersPerSec(1) to (5) during (10 seconds) --> 5 ramp up steps, 2 seconds each  
      00s-02s: 1x2 = 2 users  
      02s-04s: 2x2 = 4 users  
      04s-06s: 3x2 = 6 users  
      06s-08s: 4x2 = 8 users  
      08s-10s: 5x2 = 10 users  
 --> total users: 30 users  

    rampUsersPerSec(1) to (5) during (10 seconds) --> 5 ramp up steps, 2 seconds each  
      00s-04s: 1x4 = 4 users  
      04s-08s: 2x4 = 8 users  
      08s-12s: 3x4 = 12 users  
      12s-16s: 4x4 = 16 users  
      16s-20s: 5x4 = 20 users  
 --> total users: 60 users  
