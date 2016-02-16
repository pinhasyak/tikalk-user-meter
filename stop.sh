#!/bin/bash

# defaults
PROFILE=none

usage () {
  echo ""
  echo "$0 - stop user-meter instance"
  echo ""

  exit 1
}

# stop notification-service instance
PIDS=`ps -aef | grep user-meter-0.0.1-SNAPSHOT.jar |  grep -v grep | awk '{print $2}'`

if [ "x$PIDS" != "x" ]
then
    kill $PIDS
else
    echo "No user-meter instances found to stop"
fi