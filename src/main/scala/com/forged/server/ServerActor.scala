package com.forged.server

import spray.httpx.PlayTwirlSupport._
import spray.routing.HttpServiceActor

/**
 * Created by visitor15 on 11/28/15.
 */
class ServerActor extends HttpServiceActor {

  override def receive: Receive = runRoute {
    path("home") {
      get {
        complete {
          html.home.render()
        }
      }
    } ~
    path("old-profile") {
      get {
        complete {
          html.basePage.render("Nick Champagne", html.header.render(), html.footer.render(), html.profile.render())
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
