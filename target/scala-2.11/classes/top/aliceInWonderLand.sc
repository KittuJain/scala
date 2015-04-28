import scala.io.Source

//Source.fromURL("https://ia601405.us.archive.org/18/items/alicesadventures19033gut/19033.txt").mkString
//Source.fromURL("http://xpo6.com/wp-content/uploads/2015/01/stop-word-list.txt").mkString

val bookText = Source.fromFile("/Users/kratij/Documents/Practice/scala_basics/resources/alice").mkString
val wordsFile = Source.fromFile("/Users/kratij/Documents/Practice/scala_basics/resources/words").mkString
val wordsOfBook = bookText.split("\\s+")
val words = wordsOfBook.take(100).map(_.toLowerCase()).toList
val stopWords = wordsFile.split("\\s+").map(_.toLowerCase()).toSet
print("----------->>>>>>>>>>>>")

words.filterNot(stopWords)
stopWords : String => Boolean
words : Int => String
