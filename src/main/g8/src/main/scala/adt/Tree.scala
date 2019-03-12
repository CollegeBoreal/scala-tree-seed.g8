package adt

sealed trait ???

object Tree {

  def size[A](t: Tree[A]): Int = ???

  /*
  We're using the method `max` that exists on all `Int` values rather than an explicit `if` expression.
  
  Note how similar the implementation is to `size`. We'll abstract out the common pattern in a later exercise. 
  */
  def maximum(t: Tree[Int]): Int = ???

  /*
  Again, note how similar the implementation is to `size` and `maximum`.
  */
  def depth[A](t: Tree[A]): Int = ???

  def map[A,B](t: Tree[A])(f: A => B): Tree[B] = ???

  /* 
  Like `foldRight` for lists, `fold` receives a "handler" for each of the data constructors of the type, and recursively
  accumulates some value using these handlers. As with `foldRight`, `fold(t)(Leaf(_))(Branch(_,_)) == t`, and we can use
  this function to implement just about any recursive function that would otherwise be defined by pattern matching.
  */
  def fold[A,B](t: Tree[A])(f: A => B)(g: (B,B) => B): B = ???
  
  def sizeViaFold[A](t: Tree[A]): Int = ???
  
  def maximumViaFold(t: Tree[Int]): Int = ???
  
  def depthViaFold[A](t: Tree[A]): Int = ???
  
  /*
  Note the type annotation required on the expression `Leaf(f(a))`. Without this annotation, we get an error like this: 
  
  type mismatch;
    found   : fpinscala.datastructures.Branch[B]
    required: fpinscala.datastructures.Leaf[B]
       fold(t)(a => Leaf(f(a)))(Branch(_,_))
                                      ^  
  
  This error is an unfortunate consequence of Scala using subtyping to encode algebraic data types. Without the
  annotation, the result type of the fold gets inferred as `Leaf[B]` and it is then expected that the second argument
  to `fold` will return `Leaf[B]`, which it doesn't (it returns `Branch[B]`). Really, we'd prefer Scala to
  infer `Tree[B]` as the result type in both cases. When working with algebraic data types in Scala, it's somewhat
  common to define helper functions that simply call the corresponding data constructors but give the less specific
  result type:
    
    def leaf[A](a: A): Tree[A] = Leaf(a)
    def branch[A](l: Tree[A], r: Tree[A]): Tree[A] = Branch(l, r)
  */
  def mapViaFold[A,B](t: Tree[A])(f: A => B): Tree[B] = ???
  
}
