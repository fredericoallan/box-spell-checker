#!/bin/bash

vDateTime=$(date +"%d.%m.%Y_%H.%M")

java -jar box-spell-checker.jar | tee result_$vDateTime.txt
