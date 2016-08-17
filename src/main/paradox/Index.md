#Quick Start Guide

**Example initial implementation of: [doc.akka.io](http://doc.akka.io/docs/akka/2.4/scala/stream/stream-quickstart.html)**

A stream usually begins at a source, so this is also how we start an Akka Stream. Before we create one, we import the full complement of streaming tools:

@@snip [QuickStart.scala](../scala/QuickStart.scala) { #imports_example1 }

If you want to execute the code samples while you read through the quick start guide, you will also need the following imports:

@@snip [QuickStart.scala](../scala/QuickStart.scala) { #imports_example2 }

Now we will start with a rather simple source, emitting the integers 1 to 100:

@@snip [QuickStart.scala](../scala/QuickStart.scala) { #source_example }

The Source type is parameterized with two types: the first one is the type of element that this source emits and the second one may signal that running the source produces some auxiliary value (e.g. a network source may provide information about the bound port or the peer’s address). Where no auxiliary information is produced, the type ```akka.NotUsed``` is used—and a simple range of integers surely falls into this category.

Having created this source means that we have a description of how to emit the first 100 natural numbers, but this source is not yet active. In order to get those numbers out we have to run it:

@@snip [QuickStart.scala](../scala/QuickStart.scala) { #run_example }

This line will complement the source with a consumer function—in this example we simply print out the numbers to the console—and pass this little stream setup to an Actor that runs it. This activation is signaled by having “run” be part of the method name; there are other methods that run Akka Streams, and they all follow this pattern.

You may wonder where the Actor gets created that runs the stream, and you are probably also asking yourself what this **materializer** means. In order to get this value we first need to create an Actor system:

@@snip [QuickStart.scala](../scala/QuickStart.scala) { #complement_example }

There are other ways to create a materializer, e.g. from an ```ActorContext``` when using streams from within Actors. The ```Materializer``` is a factory for stream execution engines, it is the thing that makes streams run—you don’t need to worry about any of the details just now apart from that you need one for calling any of the run methods on a Source. The materializer is picked up implicitly if it is omitted from the run method call arguments, which we will do in the following.

Summing up this concepts:

@@fiddle [QuickStart.scala](../scala/QuickStart.scala) { #fiddle_code }
