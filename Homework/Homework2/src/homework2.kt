fun main() {

    // 01
    val test = "123"
    val num = test.toInt()

    val expression = "100 % 20"

    val list = expression.split(' ')

    val result =
        when (list[1]) {
            "/" -> if (list[2].toInt()==0) "cannot divide by zero" else list[0].toInt()/  list[2].toInt()
            "+" ->  list[0].toInt() +  list[2].toInt()
            "-" ->  list[0].toInt() -  list[2].toInt()
            "*" ->  list[0].toInt() *  list[2].toInt()
            "%" ->  list[0].toInt() %  list[2].toInt()
            else -> -1
        }

    println("$result")


    // 02
    val capacity = 10

    var myUniqueArray = mutableSetOf<Int>()
    while (myUniqueArray.size < capacity) {
        val item = (1..100).random()
        myUniqueArray.add(item)
    }
    println("result: $myUniqueArray, capacity: $capacity")

    // 03
    val strLine = arrayOf<String>(
        "Seoul National University of Science and Technology",
        "Seoul Station",
        "IT Management",
        "Android and Kotlin is not that difficult",
        "Exit"
    )

    for (str in strLine)
        println("The number of words is ${str.split(' ').size}")


    // 04
    var strs = "I Love Kotlin"
    println(strs)

    var count = 0
    while (count < strs.length) {
        val first: String = strs.substring(0, 1)
        val last: String = strs.substring(1)
        strs = last + first
        println(strs)
        count++
    }


    // 05
    val str = "DDADD"

    val isPalindrome = str.lowercase().let { s ->
        s == s.reversed()
    }

    println("$str is${if (isPalindrome) " " else " not "}a palindrome!")

    // 06

    val testNum = 99
    if (testNum.toString()[0] == testNum.toString()[1]) {
        println("Yes! two numbers are same! (Number: $testNum)")
    } else {
        println("No! two numbers are NOT same! (Number: $testNum)")
    }

    // 07

    val sequence = "abcabcdefabc"
    val charCount = mutableMapOf<Char, Int>()

    for (ch in sequence) {
        charCount[ch] = charCount.getOrDefault(ch, 0) + 1
    }

    for (key in charCount.keys) {
        println("$key: ${charCount[key]}")
    }

}