
object QuickStart extends App {

// #fiddle_code
// $FiddleDependency eu.unicredit %%% akkajsactorstream % 0.2.0

// #imports_example1
import akka.stream._
import akka.stream.scaladsl._
// #imports_example1

// #imports_example2
import akka.{ NotUsed, Done }
import akka.actor.ActorSystem
import akka.util.ByteString
import scala.concurrent._
import scala.concurrent.duration._
// #imports_example2

// #complement_example
implicit val system = ActorSystem("QuickStart")
implicit val materializer = ActorMaterializer()
// #complement_example

// #source_example
val source: Source[Int, NotUsed] = Source(1 to 100)
// #source_example

import system.dispatcher
// #run_example
source.runForeach(i => println(s"num $i"))(materializer)
// #run_example
.onComplete(_ => system.terminate)

// #fiddle_code

}
