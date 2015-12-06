package com.forged.server

import com.forged.data.PortfolioProject
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
          html.basePage.render("Nick Champagne",
            html.header.render(),
            html.footer.render(),
            html.profile.render())
        }
      }
    } ~
    path("portfolio") {
      get {
        complete {
          html.basePage.render("Nick Champagne",
            html.header.render(),
            html.footer.render(),
            html.portfolio.render(Server.generateProjectList()))
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

object Server {
  def generateProjectList(): List[PortfolioProject] = {
    val curiousProject = PortfolioProject("Curious - Khan Academy",
      "A native Android application that integrates Khan Academy's public api.",
      List("android-curious-khanacademy-green.png", "android-curious-khanacademy-blue.png", "android-curious-topics-menu.png"))

    val nuesoftMedical = PortfolioProject("Nuesoft Medical",
      "A medical application designed for increasing a patient's control over their data while providing a secure way of transferring data electronically.",
      List("nuesoft-medical-login.png", "nuesoft-medical-profile-docs.png", "nuesoft-medical-profile-encryption.png"))

    val moneyInformer = PortfolioProject("Money Informer",
      "A tool to convert and look up world currency and country information. View financial history charts for different exchange rates and quickly find more information through Wikipedia and Google search.",
      List("money-informer-phone-port-main.png", "money-informer-phone-port-history.png", "money-informer-tablet-links.png"))

    val astroFileManager = PortfolioProject("ASTRO File manager",
      "ASTRO File Manager finds and manages all of your files, no matter where they are located.",
      List("astro-phone-listview.png", "astro-phone-nav-drawer.png"))

    List(curiousProject, nuesoftMedical, moneyInformer, astroFileManager)
  }
}