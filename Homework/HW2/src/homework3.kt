import kotlin.random.Random
// 01
class Grade(math: Int, science: Int, english: Int) {
    var average: Int = 0

    init {
        average = (math + science + english) / 3
    }

    fun average(): Int {
        return average
    }
}

// 02

open class Point(open var x: Int, open var y: Int) {
    fun move(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    open fun show(){
        println("Current Point: ($x, $y)")
    }
}

class ColorPoint(x: Int, y: Int, color: String) : Point(x, y) {

    override var y:Int = 0
        set(value) {
            field = value
            println("Y has been changed to $field")
        }

    var color:String = ""

    fun setPoint(x: Int, y: Int) {
        move(x, y)
    }

    override fun show() {
        println("Color:$color Current Point: ($x, $y)")
    }

}


// 03

data class Item(val name:String=""){
    var price:Int = 0
        set(value) {
            field = value
            println("price set to $value. Are you serious?")
        }
    var share:Int = 0
    init{println("$name item was created")}
}



fun main() {

    // 01
    val math = 0			// modify these scores for test
    val science = 50			// modify these scores for test
    val english = 50                  // modify these scores for test

    val me = Grade(math, science, english)
    println("my math: $math, my science: $science, my english: $english")
    println("Average is ${me.average()}")


    // 02

    val p = Point(5,5)
    p.x=10
    p.y=20
    p.show()

    val cp = ColorPoint(5, 5, "YELLOW")
    cp.setPoint(10, 20)
    cp.color = "GREEN"
    cp.y=100
    cp.show()


    // 03
    val item1 = Item(name="jinwoo1").apply{
        share = 100
        price = 500
    }
    // 04

    val myList = mutableListOf<Item>()
    for (i in 0..10){
        myList.add(Item("jinwoo$i").apply{
            share = 100
            price = Random.nextInt(1001)
        })
    }

    myList.forEach{
        println("name: ${it.name}\tprice: ${it.price}")
    }

    // 05
    println("${myList.filter{it.price>500}}")

    // 06
    val str = myList.run {
        sortBy{it.price}
        toString()
    }.also {
        println(it.uppercase())
    }




    // 07
    val address1 = "Nooooooo!!"
    val address2 = null
    val address3 = "jinw.jeong@seoultech.ac.kr"

    sendEmail(address1)
    sendEmail(address2)
    sendEmail(address3)

    sendEmail2(address1)
    sendEmail2(address2)
    sendEmail2(address3)


    // 08
    draw_pyramid(5)

    // 09

    val input1 = listOf("hello", "world", "Kotlin", "is", "awesome") // change this line to test other string lists
    println(transformStrings(input1).toString())


    // 10

    val strstr = "seoul_tech_itm" // change this line for test
    println("${snakeToCamelCase(strstr)} (original: ${strstr})")

}


// explicit check 07-1)
fun sendEmail(email: String?){
    val emailPattern = Regex("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b")
    if (email == null || !emailPattern.matches(email)){
        println("Failed to send email. Please enter a email address")
    }
    else {println("Email sent to $email")}
}

//\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b
//\\b:
//
//**단어 경계(boundary)**를 의미합니다. 이메일 주소 앞과 뒤에 공백 또는 다른 비문자와의 경계를 설정하여 완전한 단어로 이메일을 검출합니다.
//[A-Za-z0-9._%+-]+:
//
//이메일의 로컬 파트(이메일 주소의 '@' 앞 부분)를 의미합니다.
//[A-Za-z0-9._%+-]: 영문 대소문자(A-Z, a-z), 숫자(0-9), 마침표(.), 밑줄(_), 퍼센트(%), 더하기(+), 하이픈(-) 등을 포함한 문자들을 허용합니다.
//+: 앞의 문자 클래스에 해당하는 문자가 하나 이상 등장해야 함을 의미합니다.
//@:
//
//"@" 기호는 이메일 주소의 필수적인 구분자입니다.
//[A-Za-z0-9.-]+:
//
//이메일의 도메인 이름 부분을 의미합니다.
//[A-Za-z0-9.-]: 영문 대소문자(A-Z, a-z), 숫자(0-9), 마침표(.), 하이픈(-)이 포함된 문자들을 허용합니다.
//+: 이 패턴이 한 번 이상 등장해야 함을 의미합니다.
//\\.:
//
//도메인 이름과 도메인 확장자 사이의 마침표(.)를 의미합니다. 정규식에서 마침표는 일반 문자로 해석되지 않으므로 이스케이프 문자인 \\.로 사용됩니다.
//[A-Za-z]{2,4}:
//
//도메인 확장자를 나타냅니다. 예를 들어, .com, .net, .org와 같이 끝나는 이메일 주소의 마지막 부분입니다.
//[A-Za-z]: 영문 대소문자만 허용합니다.
//{2,4}: 도메인 확장자의 길이가 2자에서 4자 사이여야 함을 의미합니다. 즉, .com (3자), .net (3자), .info (4자) 등의 도메인 확장자가 허용됩니다.
//\\b (끝):
//
//앞서 설명한 것처럼 단어 경계를 의미합니다. 이메일 주소의 끝을 나타냅니다.

// elvis 07-2)
fun sendEmail2(email: String?){
    val emailPattern = Regex("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b")
    val validEmail = emailPattern.matches(email ?: "")
    println(if (validEmail) "Email sent to $email" else "Failed to send email. Please enter a email address")
}

// 08

fun draw_pyramid(floor: Int){
    val pyramid = StringBuilder().run {
        repeat(floor){level ->
            val spaces = " ".repeat(floor - level - 1)
            val stars = "*".repeat(2 * level + 1)
            append(spaces)
            append(stars)
            append(spaces)
            appendLine()
        }
        toString()
    }
    println(pyramid)
}

// 09
fun transformStrings(strings: List<String>): Map<String, Int> {
    return strings
        .map { it.uppercase() }
        .filter { it.length >= 4 }
        .associateWith { it.length }
}

// 10
fun snakeToCamelCase(s: String): String {
    var ss= s.split("_")
    return ss.map{ it.capitalize()}
        .joinToString("").replaceFirstChar { it -> it.lowercase() }
}