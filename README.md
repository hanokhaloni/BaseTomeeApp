# BaseTomeeApp
Base TOMEE application for our usage. Based on TOMEE app

# Build script
The build script is defined per project / jar.
An outline for the whole application is defined in a "solution" (TBD - how do you say solution in java?).

BaseTommeeApp
Buil process

1.  Provisioning - or - what do we need in order to start to work
  1.   DB
    1.  drop database schema
    2.  create database schema (TBD - using flyway?)
    3.  load test data
    4.  (tell the app not to start database?)
  2.  Application server
    1.  make sure it's available / path exist /etc?
  3.   Version
    1.  Make sure a version is defined
2.  Build
   1.   Build all parts
   2.   package them to a war file
3.  deply
   1.  copy war to path defined in 1.2.1
4.  summary
   1.  show test result link
   2.  publish PMD results


# Directory strucuture
## TBD tick at all at one place option
+ BaseTomeeApp 
  + src
    + main
      + java
      + resources
      + webapp
      + filters
  + test

## TBD Multiproject Build (gradle best practice)
splitting the build up into several project-specific build files

## TBD current state

+ BaseTomeeApp 

TBD - is this correct? Should we prompt for DAO/Logic/Service seperation?
TBD - Services classes are always empty, maybe we should use a controller/dao model?
TBD - name of app
TBD - what happpens if we have more than one web app per server?
TBD - so we 
