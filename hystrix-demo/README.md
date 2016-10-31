# Welcome to the Hystrix Demo Git Repository


## Repository Description

The hystrix-demo repository maintains the source code XXXXXXXXX.


- - - - -

## Prerequisites
See <https://confluence.cars.com/display/CD/npm>

## Installation

To install www-cars-com-static on your local workstation, you must clone the repository
from our [Bitbucket](git.cars.com) site.

Go to the folder where you want to install, and enter this command line:

`git clone http://<username>@git.cars.com/scm/carscp/www-cars-com-static.git`

## Useful Links
Good Dashboard vid:  https://www.fogcreek.com/blog/hystrix-dashboard-tech-talk-with-demo/
Here too:  http://techblog.netflix.com/2012/12/hystrix-dashboard-and-turbine.html
Good blog for dashboard explanation, scrn caps, images, etc.
Circuit Breaker diagram by Fowler:   http://martinfowler.com/bliki/CircuitBreaker.html
Code/implementation example github:   https://github.com/Netflix/Hystrix/wiki/How-To-Use#Hello-World
Configuration info:   https://github.com/Netflix/Hystrix/wiki/Configuration#circuitBreaker.errorThresholdPercentage


## Urls
http://localhost:9090/msds/car
http://localhost:8080/junkerscom/hellocmd
http://localhost:8080/junkerscom/yurcar-cmd
http://localhost:7979/hystrix-dashboard  -  http://localhost:8080/junkerscom


## Scenarios
1) 
Run Svc @ 300ms sleep.  
Run curl script.  
 ab -n 10000 -c 3 http://localhost:8080/junkerscom/yurcar-cm
 Then, start  ab -n 10000 -c 6 http://localhost:8080/junkerscom/yurcar-cm   (adjust c to 7 or more for failures)


## Presentation
- General circuit concept
- Meaning in microservices
- Sequence Diagram
- Example of real netflix UI (i.e. how to interpret)
- Want to show 1) hystrix and 2) hystrix dashboard
