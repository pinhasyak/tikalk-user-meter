#!/bin/bash

Xmx=900m

usage () {
  echo ""
  echo "$0 - launch single instance of user-meter"
  echo ""

  exit 1
}

nohup java -Xmx$Xmx -jar user-meter-0.0.1-SNAPSHOT.jar > user-meter.log