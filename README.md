Easy setup for using Wildfly, MongoDB (morphia), Jaxrs and maven.
You can test you application by Arquillian.

Requirement
===========
* Wildfly 10+
* MongoDB
* Add [wildfly-mongodb-module] on your Wildfly.
* Maven

Deploy it
=========

    maven clean install
    
You ear file is `ear/target/boilerplate-ear.ear`. You can open [admin panel](localhost:9990) on wildfly and deploy the ear file.

[wildfly-mongodb-module]: https://github.com/abdollahpour/wildfly-mongodb-module
