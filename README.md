# Apache Servicemix to Apache Karaf Migration

Apache Servicemix was last released in 2017 at version 7.0.1, containing
a plethora of integration tooling including:

- Apache Camel 2.16.5

- Apache CXF 3.1.9

- Apache ActiveMQ 5.15.5

- Apache Karaf 4.0.9

As time moved on Apache Karaf has taken on the mantle of providing an
integration runtime environment. As of Apache Karaf 4.4.6, the following
tooling is provided out-of-the-box:

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

Note: ActiveMQ will need to be setup in stand-alone mode. For the
purposes of the demo, a wild card serialization exception is made in env
script.

``` bash
ACTIVEMQ_OPTS="-Dorg.apache.activemq.SERIALIZABLE_PACKAGES=*"
```

### Installing the Demo on ServiceMix 7.0.1

Now that we’ve discussed our demo application, lets take a look at it
operating on Servicemix and Karaf.

Enter the `smx` folder, and execute `mvn clean install`. This will build
the application for Servicemix.

We can install demo application 1.0.0-SNAPSHOT using the following
Servicemix console commands:

``` bash
feature:repo-add mvn:com.savoirtech.smx.app/feature/1.0.0-SNAPSHOT/xml/features

feature:install smx-original-application
```

### Installing the Demo on Karaf 4.4.6

Enter the `karaf` folder, and execute `mvn clean install`. This will
build the application for Karaf.

We can install demo application 2.0.0-SNAPSHOT using the following Karaf
console commands:

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

Your payload should look something like this (we’ve supplied
sampleOrder.json in the repo):

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

You should get a response such as:

``` bash
{"OrderResponse":{"status":"Thank you for your order!"}}
```

Checking your runtime container home folder, you’ll find a new directory
called "target". Within this directory you’ll find folders for "abc" and
"xyz", containing json order files.

## Iterative approach

While our demo application is small, we’ll forgo transforming it in a
single step.

### Pom Plugin Updates

Update various maven plugins.

| Plugin                 | SMX   | Karaf  |
|------------------------|-------|--------|
| maven-compiler-plugin  | 3.3   | 3.13.0 |
| maven-bundle-plugin    | 2.4.0 | 5.1.9  |
| maven-resources-plugin | 2.6   | 3.3.1  |

### Library updates

Update our project dependencies to make the container.

``` xml
<properties>
    <karaf.version>4.4.6</karaf.version>
    <cxf.version>3.5.5</cxf.version>
    <camel.version>3.6.0</camel.version>
    <activemq.version>5.17.1</activemq.version>
    <jettison.version>1.4.1</jettison.version>
    <slf4j.version>2.0.12</slf4j.version>
</properties>
```

Note: New versions of supporting libraries & frameworks exist, these are
just the base versions available.

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
