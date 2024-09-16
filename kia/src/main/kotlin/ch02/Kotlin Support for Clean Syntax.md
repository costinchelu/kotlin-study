# Kotlin Support for Clean Syntax



| Regular syntax                                               | Clean Syntax                                                | Feature in use                 |
| ------------------------------------------------------------ | ----------------------------------------------------------- | ------------------------------ |
| `StringUtil.capitalize(s)`                                   | `s.capitalize`                                              | extension function             |
| `1.to("one")`                                                | `1 to "one"`                                                | infix call                     |
| `set.add(2)`                                                 | `set += 2`                                                  | operator overloading           |
| `map.get("key")`                                             | `map["key"]`                                                | convention for the get method  |
| `file.use( { f -> f.read() } )`                              | `file.use { it.read() }`                                    | lambda outside of paratheses   |
| `sb.append("yes")  sb.append("no")`                          | `with (sb) { `<br>`append("yes")`<br>  `append("no")`<br>}` | lambda with a receiver         |
| `val m = mutableListOf<Int>()`<br>`m.add(1)`<br>`m.add(2)`<br>`return m.toList()` | `return buildList {`<br>`add(1)`<br>`add(2)`<br>`}`         | builder functions with lambdas |



