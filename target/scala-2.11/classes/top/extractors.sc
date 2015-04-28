val city = "urn:pune"

object ::{
  def unapply(str: String): Option[(String, String)] = str.split(":") match{
    case Array(urn, city) => Some((urn, city))
    case _ => None
  }
}

def welcomeToCity(city : String): String = city match{
  case urn :: city => s"Welcome to $city"
  case _ => "Not a valid city"
}

welcomeToCity(city)
welcomeToCity("aasdasd")