# TensorZoo

## Monkeying around with TensorFlow 2.3 Java from Scala

There is a new version of [TensorFlow Java](https://www.tensorflow.org/install/lang_java) that installs easily.

## Status Starter Project for TensorFlow on Scala

Currently this project is the TensorFlow Java hello world project but setup in Scala. 
One purpose is to check how well TensorFlow works with Scala on different platforms. 

So far the results has been good: This installs cleanly on Linux, macOS and Windows.

Might also test out prebuild models for TensorFlow on different platforms.


## Usage

``` sh
cd tensorzoo
sbt test
sbt run
```

## Versions

```
TensorFlow 2.3.1
Scala 3.0.0-M3
Scala 2.13.4
```

# Java Versions

* Oracle JDK 8
* OpenJDK 11

## Platforms

It has been tested on

* macOS 11.1
* Ubuntu 20.04 running under WSL2
* Windows 10

## Calling Java from Scala

The TensorFlow Java bindings are using Java generics that are pretty different from Scala generics.

## Legacy TensorFlow Java and New TensorFlow Java Bindings

### Legacy TensorFlow Java Binding

[Legacy Java https://github.com/tensorflow/tensorflow/tree/master/tensorflow/java](https://github.com/tensorflow/tensorflow/tree/master/tensorflow/java).

There is better documentation for legacy including [LabelImage.java](https://github.com/tensorflow/tensorflow/blob/master/tensorflow/java/src/main/java/org/tensorflow/examples/LabelImage.java) example project.

### Porting Legacy Example

Tried to port Legacy Java example to Scala and new Java bindings: [LabelImage.scala](https://github.com/sami-badawi/tensorzoo/blob/main/src/main/scala/LabelImage.scala). That was not easy, so it is currently incomplete.


### New TensorFlow Java Binding

[New Java https://github.com/tensorflow/java](https://github.com/tensorflow/java).

Interface is quite different from legacy Java bindings.

## Related Project TensorFlow Scala

There is a good project [TensorFlow Scala](https://github.com/eaplatanios/tensorflow_scala) with idiomatic  Scala bindings.
Here is a [starter project](https://github.com/sami-badawi/tf_scala_ex).


