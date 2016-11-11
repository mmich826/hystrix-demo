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
http://localhost:8080/junkerscom/hello/cmd
http://localhost:8080/junkerscom/yurcar/cmd
http://localhost:7979/hystrix-dashboard  -  http://localhost:8080/junkerscom/hystrix.stream


## Hystrix Dashboard
In hystrix-demo/Hystrix/hystrix-dashboard, ../gradlew jettyRun


## Presentation
- Want to show 1) hystrix and 2) hystrix dashboard
- General circuit concept
- Meaning in microservices
- Component diagram of Hystrix Commands
- Sequence Diagram


- Diagram of basic service call (ctrl, srv client,  svc)
-SETUP iterm with 3 windows on top and one/two on bottom
1) Intro:  Hello cmd with @HystCommand annotation (Diagram:  ctrl, srv client, Hyst Cmd,  svc)
2) Intro:  yurcar/cmd .  SHOW:  hit endpt.  SHOW:  run demo-curl hitting hellocmd and yurcar/cmd.
3) Intro: how slow svc can drag down a web page.  Show how 5 sec delay in svc compounds to 10+   http://localhost:8080/junkerscom/yurcar/slow  with load of -n 10000 -c 10.  Hit same url from a browser and time.
4) Intro Hystrix Dashboard and interpreting.   SHOW:  slide example of real netflix UI
5) NOW run same prev load and hit with yurcar/cmd endpt.  FAST
6) Intro failure.  Load ab -n 10000 -c 2 http://localhost:8080/junkerscom/yurcar/cmd.  Kill svc and show dashboard.  Restart to show recovery
NOW:  introduce load:  ab -n 10000 -c 2 http://localhost:8080/junkerscom/yurcar/cmd.  In another window, intro another load.  Start with -c 2.  Go to 4,5, etc.  WATCH DASHBOARD and how app responds
7)  Show other config params to tweak monitoring.  Add:  .withCircuitBreakerRequestVolumeThreshold(1000)  watch fallbacks go away and thread timeouts go up

