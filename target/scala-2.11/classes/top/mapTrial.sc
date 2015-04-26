val numbers = Seq[Int](1, 2, 3, 4)
def incrementElement:(Int) => Int = {element: Int => element + 1}

def map(numbers : Seq[Int], intMap:Int=>Int) = {
  var result = Seq[Int]()
  val iterator = numbers.iterator
  while (iterator.hasNext) {
    val x:Int = intMap(iterator.next())
    result = result :+x
  }
  result
}

map(numbers, incrementElement)

// -------------------------------------------------------------------

def map1(numbers : Seq[Int], incrementElement:Int=>Int) = {
  val result = scala.collection.mutable.ArrayBuffer.empty[Int]
  val iterator = numbers.iterator
  while (iterator.hasNext) {
    val element :Int = incrementElement(iterator.next())
    result += element
  }
  result
}
map1(numbers, incrementElement)

// -------------------------------------------------------------------

val list = List[Int](1, 2, 3, 4)
def map2(numbers : List[Int], intMap:Int=>Int):List[Int] = {
  if(list.isEmpty) list else intMap(list.head) :: map(numbers.tail, intMap)
}

map2(list, x => x*x)