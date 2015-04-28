import play.api.libs.json._

val input = Json.obj(
  "item" -> Json.obj(
    "title"-> "title1 [BM]",
    "name"-> "name1 [BM]",
    "parts"-> Json.arr(
        Json.obj(
          "description"-> "good[BM] part [BM]",
          "bookmarks"-> Json.arr("one", "two", "abc", "xyz"),
          "part"-> Json.obj(
          "innerA"-> "Inner1[BM] bookmark",
          "innerB"-> "Inner2[BM] bookmark"
            ),
        "instruction"-> "good part [BM]"
        )
    ),
    "bookmarks"-> Json.arr("titleBM", "nameBM")
  )
)

object JsonBookmarks{
  def transform(json : JsValue): JsValue = {
    val bookmarks = captureBookmarks(json).get
    val iterator: Iterator[String] = bookmarks.iterator
    val next: String = iterator.next()
    json match {
      case JsString(str) => JsString("\\[BM]".r.replaceAllIn(str, _ => s"$str|$next"))
      case JsObject(pairs) => JsObject(pairs.map(transformPair))
    }
  }

  def transformPair(pair : (String, JsValue)): (String, JsValue) = pair match{
    case ("bookmarks", json) => "bookmarks" -> captureBookmarks(json)
  }

  def captureBookmarks(pair: JsValue) : Option[List[String]] =  {
    println(pair)
    (pair\"bookmarks").asOpt[List[String]]
  }
}

Json.prettyPrint(JsonBookmarks.transform(input))