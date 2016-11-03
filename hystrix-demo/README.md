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
- Want to show 1) hystrix and 2) hystrix dashboard
- Meaning in microservices
- Component diagram of Hystrix Commands
- Sequence Diagram


- Diagram of basic service call (ctrl, srv client,  svc)
-SETUP iterm with 3 windows on top and one/two on bottom
1) Intro:  Simple yurcar cmd with @Command annotation (Diagram:  ctrl, srv client, Hyst Cmd,  svc).  SHOW:  hit endpt
2) Intro Hystrix Dashboard and interpreting.   Example of real netflix UI (i.e. how to interpret)
3) Intro: how slow svc can drag down a web page.  Show how 5 sec delay compounds to 10+   http://localhost:8080/junkerscom/yurcar-slow  with load of -n 10000 -c 10.
4) Intro Hello Cmd using a command pattern.   SHOW:  run demo-curl hitting hellocmd and yurcar-cm.  
5) Same as #4 but now kill svc and show dashboard.  Restart to show recovery
6) Same as #4 but now add Load with:  ab -n 10000 -c 5 http://localhost:8080/junkerscom/yurcar-cmd.  Show dashboard and running successfully.  
NOW:  introduce another load:  ab -n 1000 -c 7 http://localhost:8080/junkerscom/yurcar-cmd
Page should now get errors.  
7)  Show other config params to tweak monitoring

