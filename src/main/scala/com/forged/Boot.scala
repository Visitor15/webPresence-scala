package com.forged

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.event.Logging
import com.forged.server.ServerActor
import spray.servlet.WebBoot

/**
 * Created by visitor15 on 11/28/15.
 */
class Boot extends WebBoot {
  implicit val system = ActorSystem("site")
  val log = Logging(system, getClass)

//  implicit val timeout = Timeout(5.seconds)

  val service = system.actorOf(Props(new ServerActor()), "root-actor")

  // start a new HTTP server on port 8080 with our service actor as the handler
//  IO(Http) ? Http.Bind(service, interface = "192.168.1.2", port = 8080)
  override def serviceActor: ActorRef = service
}