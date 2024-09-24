# Apache Servicemix to Apache Karaf Migration

Apache Servicemix was last released in 2017 at version 7.0.1, containing
a plethora of integration tooling including:

- Apache Camel 2.16.5

- Apache CXF 3.1.9

- Apache ActiveMQ 5.15.5

- Apache Karaf 4.0.9

As time moved on Apache Karaf has taken on the mantle of providing an
integration focussed runtime environment. As of Apache Karaf 4.4.6, the
following tooling will be provided:

- Apache Camel 3.6.0

- Apache CXF 3.5.5

- Apache ActiveMQ 5.17.1

- Apache Karaf 4.4.6

Underlying these updates is the general progress of Java ecosystems from
Java 8 to Java 11 as a baseline build.

## Lets take a sample application and journey to the future!

To help illustrate our migration procedure we’ve written a small demo
application targeting Servicemix running on Java 8.

Describe application here.

Note: ActiveMQ will need to be setup in stand alone mode. For the
purposes of the demo, a wild card serialization exception is made in env
script.

``` bash
ACTIVEMQ_OPTS="-Dorg.apache.activemq.SERIALIZABLE_PACKAGES=*"
```

### Installing the Demo on ServiceMix 7.0.1

``` bash
feature:repo-add mvn:com.savoirtech.smx.app/feature/1.0.0-SNAPSHOT/xml/features

feature:install smx-original-application
```

### Installing the Demo on Karaf 4.4.6

``` bash
feature:repo-add mvn:com.savoirtech.smx.app/feature/2.0.0-SNAPSHOT/xml/features

feature:install smx-original-application
```

### Testing the Demo Application

To execute the call to the restful service, be sure that you set your
client to use the POST verb and point it to:

<http://localhost:9090/rest/order/add/>

From your terminal you can try the below command:

``` bash
 curl -d "@sampleOrder.json" -X POST http://localhost:9090/rest/order/add  -H "Content-Type: application/json"
```

You should get a response such as:

``` bash
{"OrderResponse":{"status":"Thank you for your order!"}}
```

Your payload should look something like this:

``` json
{
  "order": {
    "customer": {
      "lastName": "Hessla",
      "firstName": "Heaf",
      "address": "1234 Main St",
      "city": "Jackson Hole",
      "state": "WY",
      "zip": "83001"
    },
    "items": [
      {
        "product": "abc widget",
        "quantity": 2
      },
      {
        "product": "xyz widget",
        "quantity": 1
      }
    ]
  }
}
```

## Iterative approach

While our demo application is small, we’ll forgo transforming it in a
single step.

### Pom Plugin Updates

Update various maven plugins.

### Library updates

Update our project dependencies.

### Adjust Code to newer libraries

Switch from Javax to Jakarta packages.

Adapt Camel route to changed APIs.

## Conclusion

Our demo application is now running in Apache Karaf 4.4.6.

# About the Authors

[Jamie
Goodyear](https://github.com/savoirtech/blogs/blob/main/authors/JamieGoodyear.md)

# Reaching Out

Please do not hesitate to reach out with questions and comments, here on
the Blog, or through the Savoir Technologies website at
<https://www.savoirtech.com>.

# With Thanks

Thank you to the Apache Servicemix and Karaf communities.

\(c\) 2024 Savoir Technologies
