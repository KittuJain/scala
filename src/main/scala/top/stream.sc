val xs = Stream(1)
def func(n : Int) = (n%3==0)&&(n%5==0)
xs.filter(func)
xs.filter(func).drop(162)
xs.take(1)
xs
