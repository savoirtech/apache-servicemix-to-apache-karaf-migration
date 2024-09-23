# Apache Servicemix to Apache Karaf Migration

Apache Servicemix was last released in 2017 at version 7.0.1, containing
a plethora of integration tooling including:

- Apache Camel 2.16.5

- Apache CXF 3.1.9

- Apache ActiveMQ 5.15.5

- Apache Karaf 4.0.9

As time moved on Apache Karaf has taken on the mantle of providing an
integration focussed runtime environment. As of Apache Karaf
4.5.0-SNAPSHOT, the following tooling will be provided:

- Apache Camel 3.6.0

- Apache CXF 3.5.5

- Apache ActiveMQ 5.17.1

- Apache Karaf 4.5.0

Underlying these updates is the general progress of Java ecosystems from
Java 8 to Java 17 as a baseline build.

## Lets take a sample application and journey to the future!

To help illustrate our migration procedure we’ve written a small demo
application targeting Servicemix running on Java 8.

Describe application here.

## Iterative approach

While our demo application is small, we’ll forgo transforming it in a
single step.

### Dependency Update

Update our project dependencies one at a time.

### Methodology Update

Utilize BOM.

### Modernize

Switch from blueprint to SCR.

## Conclusion

Our demo application is now running in Apache Karaf 4.5.0-SNAPSHOT.

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
