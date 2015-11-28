package com.forged.server

import spray.httpx.PlayTwirlSupport._
import spray.routing.HttpServiceActor

/**
 * Created by visitor15 on 11/28/15.
 */
class ServerActor extends HttpServiceActor {

  override def receive: Receive = runRoute {
    path("") {
      get {
        complete {
          html.profile.render()
        }
      }
    } ~
    pathPrefix("theme") {
      get {
        getFromResourceDirectory("theme")
      }
    }
  }
}
