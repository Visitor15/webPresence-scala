package com.forged

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.event.Logging
import akka.io.IO
import akka.util.Timeout
import com.forged.server.ServerActor
import spray.can.Http
import scala.concurrent.duration._

/**
 * Created by visitor15 on 11/28/15.
 */
object Boot extends App {
  implicit val system = ActorSystem("site")
  val log = Logging(system, getClass)

  implicit val timeout = Timeout(5.seconds)

  val service = system.actorOf(Props(new ServerActor()), "root-actor")

  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ? Http.Bind(service, interface = "192.168.1.2", port = 8080)
}