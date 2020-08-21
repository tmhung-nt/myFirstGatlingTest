# myFirstGatlingTest   
=========================

Simple showcase of a maven project using the gatling-maven-plugin.

## To test it out in command line, simply execute the following command:

    mvn gatling:test -Dgatling.simulationClass=video_game_db.test_scenarios
    
    mvn gatling:test -Dgatling.simulationClass=computerdatabase.advanced.AdvancedSimulationStep02
    
or simply:

    mvn gatling:test

## From Intellij IDEA, run one of following classes
- Engine
- Gatling Runner (need to add a particular class name first then we can run in debug mode as well)

## API Service  
http://video-game-db.eu-west-2.elasticbeanstalk.com/swagger-ui/index.html

## References
https://www.james-willett.com/debug-gatling/  
https://www.james-willett.com/gatling-load-testing-complete-guide  
https://maxchadwick.xyz/blog/gatling-multiplier
