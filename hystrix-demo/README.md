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
- General circuit concept
- microservices and SOA challenges via component diagram
- Component diagram of Hystrix Commands
- Dashboard overview.
- Demo:
    00) OPEN:  Local Hystrix Dashboard, Splunk , Prod Hystrix Dashboard
    0) local hystrix dashboard:
        http://localhost:7979/hystrix-dashboard/monitor/monitor.html?streams=%5B%7B%22name%22%3A%22%22%2C%22stream%22%3A%22http%3A%2F%2Flocalhost%3A8080%2Fjunkerscom%2Fhystrix.stream%22%2C%22auth%22%3A%22%22%2C%22delay%22%3A%22%22%7D%5D
        https://splunk.cars.com/en-US/app/search/search?q=search%20host%3D%22cs1*%22%20hystrix%20source%3D%22%2Fapps%2FIBM%2FWebSphere%2F85%2FAppServer%2Fprofiles%2FSvcProfile%2Flogs%2FComposite_ListingAPI*%2FSystemOut.log%22&display.page.search.mode=verbose&dispatch.sample_ratio=1&earliest=-24h%40h&latest=now&sid=1511935021.513695_AFB14F10-1B38-4E2F-83E5-25E32CC17D43&display.events.fields=%5B%22host%22%2C%22source%22%2C%22sourcetype%22%2C%22hystrix_command%22%2C%22hystrix_fallback_reason%22%2C%22hystrix_fallback_source%22%5D
    1) No cmd.
        1) Postman.  100 MS sleep.  Fast ~110 MS
        2) Run load.  Watch resp time go up.
        artillery quick -d 360  -r 10 http://localhost:8080/junkerscom/yurcar      10, 20, 40
            - Run addition window load with r=10.  Then stop.  Show how svc performance doesn't return
        3) Stop the service.  Show 500 return status
    2) With cmd.
        1) Postman.  100 MS sleep.  Fast ~110 MS
        2) Run load.  Watch resp time go up.
        ab -n 50000 -c 7 http://localhost:8080/junkerscom/yurcar/cmd
            - Run addition window load with r=2, 3.  Then stop.  Show how svc performance doesn't return
        3) Stop the service.  Show fallback
- Code and Config
- Cost (overhead) of hystrix
- Splunk dashboard


PREVIOUS:
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

