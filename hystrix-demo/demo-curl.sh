#!/usr/bin/env bash
while [ 1 ]
do
  #curl -I http://localhost:9090/msds/car
  #curl  http://localhost:9090/msds/car
  #curl  http://localhost:8080/junkerscom/yurcar
  curl  http://localhost:8080/junkerscom/hello/cmd
  curl  http://localhost:8080/junkerscom/yurcar/cmd
  echo ''
done
