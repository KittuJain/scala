import scala.io.Source

//Source.fromURL("https://ia601405.us.archive.org/18/items/alicesadventures19033gut/19033.txt").mkString
//Source.fromURL("http://xpo6.com/wp-content/uploads/2015/01/stop-word-list.txt").mkString

val bookText = Source.fromFile("/Users/kratij/Documents/Projects/scala-basics-5/resources/alice").mkString
val wordsFile = Source.fromFile("/Users/kratij/Documents/Projects/scala-basics-5/resources/words").mkString
val words = bookText.split("\\s+")
words.take(10)
