import play.api.libs.json._
val json = Json.obj(
  "a" -> 10,
  "b" -> true,
  "d" -> "urn:world",
  "d1" -> "world",
  "c" -> JsNull,
  "e" -> Json.obj(
    "f" -> 20,
    "g" -> false,
    "h" -> "hello",
    "i" -> Json.arr("urn:pune","this","is","")
  ),
  "j" -> Json.arr(
    Json.obj("k"->"urn:tw",
      "l" -> "munich"),
    Json.obj("k"->"autoscout",
      "l" -> "urn:germany")
  ),
  "m" -> 90,
  "n" -> "urn:ignore"
)

object JsonDemo{
  def transform(json : JsValue): JsValue = json match{
    case JsNumber(num) => JsNumber(num*num)
    case JsBoolean(flag) => JsBoolean(!flag)
    case JsString("") => JsString("Empty")
    case JsString(string) if string.startsWith("urn:") => JsString(string.replace("urn:","hello "))
    case JsString(string) => JsString(string)
    case JsArray(jsValueSeq) => JsArray(jsValueSeq.map(transform))
    case JsObject(pairs) => JsObject(pairs.map(transformPairs))
    case JsNull => JsString("NULL")
  }
  def transformPairs(pair : (String, JsValue)): (String, JsValue) = pair match{
    case ("m" | "n", json) => pair
    case (key, json) => key -> transform(json)
  }
}
val result: JsValue = JsonDemo.transform(json)
Json.prettyPrint(result)
