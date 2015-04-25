val list = List(1,2,3,4)

def reverse(numbers : List[Int]) :List[Int] = {
  numbers.foldLeft(List.empty[Int])((acc, elm) => elm :: acc)
}
reverse(list)
