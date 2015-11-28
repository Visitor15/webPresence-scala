package com.forged.server

import spray.http.MediaTypes._
import spray.routing.HttpServiceActor

/**
 * Created by visitor15 on 11/28/15.
 */
class ServerActor extends HttpServiceActor {

  override def receive: Receive = runRoute {
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Hello, world!</h1>
              </body>
            </html>
          }
        }
      }
    }
  }
}
