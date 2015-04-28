object sequenceTrial{
  implicit class MySequence[T](val seq : Seq[T]){
    def getSize = {
      seq.size
    }
    def indexBy[K](function: T => K) = {
      seq.map( e => function(e) -> e).toMap
    }
  }
}
import sequenceTrial.MySequence
val list: Seq[String] = Seq("ONE", "TWO", "THREE", "FOUR", "FIVE")
list.getSize
def lengthOf[T, K](number : String) = {
  number.length()
}
list.indexBy(lengthOf)

