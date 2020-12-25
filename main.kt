/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */
// class Person(val name: String, val age: Int)

// import kotlin.math.*

// typealias ArrStr = Array<String>

// fun main(args: ArrStr) {
//     println(args[0])
//     println(args[1])
    
// //     val x = 3
// //     val y: Int = 5
// //     println(x)
// //     println(y)
// //     
// //     val person = Person("홍길동", 33)
// //     println(person.name)
// //     println(person.age)
//     // println("Hello, world!!!")
//     // 
// //     val intro: String = "안녕하세요!"
// //     val num: Int = 20
    
// //     println(PI)
// //     println(abs(-12.6))
// //     println("Intro: $intro / Num = $num") // $문자열 템플릿, $를 붙이면 이건 변수가 된다(오오)
// //     
// 	val intro: String = "안녕하세요!"
//     val num: Int = 20
    
//     println("Intro: $intro / Num = $num") 
    
//     println("이 안에서 \$나 \" 아니면 역슬래시로 시작하는 이스케이프 문자")
//     println("{ 나 } 은 그냥 쓸 수 있음~~~~")
   
//    // 문자열 안에서 단순한 변수가 아니라 복잡한 식을 읽어서 그 식을 값으로 대치하는(문자열 템플릿)
//     println("Intro: $intro / Num = ${100 + num}") 
    
//     val longstr: String = """
// 여러 줄게 걸친 긴 문자열은
// 이런 식으로 표시한다.
// 이 안에서는 "쌍따옴표"를 그냥 사용할 수 있습니다.
// 이말입니다.
    
//     """
    
//     print(longstr)
// }
// 

// fun main() {
//     // 기본적으로 null 을 허용하지 않음(자바와 차이점)
//     // 코틀린의 타입은 기본적으로 non-null
//     val str: String = "hello"
//     // 끝에 물음표를 붙이면 NULL 이 될 수도 있는 타입
//     val str2: String? = null
    
//     println(str.length)
//     println(str2?.length)
    
// //     println( (str2 == null) ? null : str2.length))
// //     코틀린 3항 연산자는 그냥 if then else 로 하면 된다
// //    이 부분을 주의깊게 살펴보자. 스무스하게 넘어갔어요. 생각해보면 이게 그냥 넘어갈 일이 꼭 아닐 수도 있다는 말
// //    non-null 타입과 nullable 타입을 구분하는 것은 프로그램을 안전하게 작성하는 데 많은 도움을 준다
// //    안전에 신경을 쓸 수록 조금 귀찮아지는게 보통. 이런 귀찮음을 줄여주기 위하여...
// //    
//     println(
//         if (str2 == null) // str2: String?
// //         	여기서는 스마트 캐스팅이 안일어남
//         	null
//         else // 여기에서 스마트 캐스팅이 일어난다. null과 비교하는 검사가 실패했기때문에 str2 를 String?이 아닌 String으로 취급해준다.
//         	str2.length // 잠깐 여기는 어째서 ?. 이 아니라 그냥 . 인데도 되는거지? 자세히 보면 이런 의문이 일어남..
//     )
// }
// 
// 
// 코틀린으로 이진트리 클래스 정의해보기
// (1) null 활용하여 <= 일단 이거 한번 해보자.
// (2) 널객체 패턴 <= 이건 나중에 하기 ..
// 
// 
// class Tree(int value, Tree left, Tree right) // Java 식 파라미터 선언 (헷갈린다... 잘하자.)

// data class Tree(val value: Int, val left: Tree?, val right: Tree?) //Kotlin 식 파라미터 선언
// // 아 코틀린도 자바처럼 toString 그거 귀찮게 오버라이드 그런거 해야하나? 좋은소식: 이렇게 간단한 건 안해도 된다. data class
// /*
//       3
//      / \
//     1  2
// */
// fun main() {
//     val tree1 = Tree(3, Tree(1, null, null), Tree(2, null, null))
//     println( tree1 ) // Profit! 오버라이드 안해도 된다...ㄷㄷ
    
// }

// 코틀린으로 이진트리 클래스 정의해보기
// (1) null 활용하여
// (2) 널객체 패턴
// 

// (1) null 활용
// data class Tree(val value: Int, val left: Tree?, val right: Tree?)
// 
// data class 가 자동으로 만들어주는 것들
// 		- toString()
// 		- === 내용 비교 Java라면 equals() / 그러므로 자바의 == 와 코틀린의 == 은 의미가 다르다 (사용 목적이 다르다)
// 				참고로 Object Equality는 코틀린에서 === 으로 한다.
// fun main() {
//     val tree1 = Tree(2, Tree(1, null, null), Tree(3, null, null))
// 	val tree2 = Tree(2, Tree(1, null, null), Tree(3, null, null))
    
//     println(tree1)
//     println(tree2)
    
//     // object equality 그러니까 코틀린의 === 는 자바의 == 에 해당함
//     println(tree1 === tree1) // Object Equality(O) (True)
//     println(tree1 === tree2) // Object Equality(X) (False)
    
//     // 내용이 같은지 비교하는 용도
//     println(tree1 == tree1) // true
//     println(tree1 == tree2) // false
    
// }


// (2) Null 객체 활용 // Composite 패턴 활용
// abstract class ATree() // 추상 부모 클래스
// class Null() : ATree() {// extends 를 코틀린에서는 이렇게 표현함 // data class 가 될 수 없기 때문에 toString() 이 자동으로 Overload 되지 않음
// 	override public fun toString() = "Null" // toString()을 수동으로 Override 함
// }
// data class Node(val value: Int, val left: ATree, val right: ATree) : ATree() 

// fun main() {
//     val tree1 = Tree(2, Tree(1, null, null), Tree(3, null, null))
//     println(tree1)
    
//     val tree3 = Node(2, Node(1,Null(), Null()), Node(3, Null(), Null()))
//     println(tree3)
// }


// 자료형 검사하고 변환하기
// null
// null 검사와 스마트 캐스트
// 
// fun main() {
//     val n = 8
//     // 문장과 식의 차이 (print문 등은 문장 / 식은 3 + 4 처럼 그런것을 식이라고 함)
//     println( if (true) 300 else 100 )
    
//     var str: String? = "hello"
//     // x가 null 인지 아닌지 검사하는 조건식과 같은 역할을 하는 연산자 ?: (Do it Kotlin p.72 ~  내용)
//     println(if (str != null) str else "bye" ) // String 이 아니라면 str 을 출력하고 그렇지 않으면 bye 를 출력함
//     println( str ?: "bye" ) // 자바의 3항 연산자를 연상시키도록.. 두개의 기호 ?와  :을 붙여서 하나의 코틀린 연산자가 됨
    
//     // 교재 p.72의 예제에 나오는 내용
//     println( str?.length ?: -1)
//     str = null
//     println( str?.length ?: -1) // str 이 null 이면 -1 되게 하고 싶다면.....
// }


// Try out 스마트 캐스트 (Do it Kotlin p.77 ~)
// 
// fun main() {
//     var test: Number = 12.2 // Number는 Int, long, float, Double 등의 상위 클래스 ==>> 기본적으로 Float로 스마트캐스트 됨.
// //     if  ( is ) // 자바에서 instanceof 와 비슷하지만 스마트캐스트가 된다!
//     println(test) // 결과 ==> 12.2 (정의로움!)
//     test = 12 // Int 형으로 스마트캐스트
//     println(test) // 결과 ==> 12 로 출력됨 (그러나 number 형임)
//     test = 12L	  // Long 형으로 스마트캐스트
//     println(test) // 12
//     test = 12F    // Float 형으로 스마트캐스트
//     println(test) // 12.0
// }
// 
// 

// // p.78 ~ / 자료형 검사하기 스마트캐스트.., as 나중에 실습할 것
// fun main() {
//     // Number는 Int, Long, Float 등의 상위 클래스
//     val num: Number = 256;
    
// //     print (num % 10) // 지금 이 경우에는 나머지 연산이 안된다. 이유는 Number 형이기 때문에... (% 는 Int에 대해서 정의된 연산자임 )
    
//     if (num is Int) { //자바에서 Instanceof 와 마찬가지로 사용가능 + 스마트 캐스트(조건 만족할 경우 if 안에서 )
//         // 이 안에서는 num 을 Int 로 취급(스마트캐스트)
//     	print(num % 10) // 이거 자바였으면 강제로 Int 처리 (캐스팅) 하던지 했어야 헀음.
//     }
    
//     if (num !is Int) {
//         print("Not a Int")
//     }
// }


// // 코틀린의 함수
// fun sum(x: Int, y: Int): Int { // 표현식 : 반환값의 자료형도 잊지말고 기입하기.
//     var sum = x + y
//     return sum
// }

// // fun sum (x: Int, y: Int): Int = x + y; // 이렇게도 많이 사용한다.
// // fun sum(x: Int, y: Int) = x + y // 더할값이 Int형이면 결과 또한 Int형이니 이렇게 생략도 가능함.... wow

// fun main() {
//     val result = sum(1,2)
//     print("결과 ==> " + result)
// }


// 복습
// Kotlin에서 변수는 val (불변, 대입 X) 또는 var(가변, 대입 O) 키워드로 선언함
// 
// 

/*
 * open, abstract, data, sealed 클래스
 * 메소드 앞에 붙는 override, abstract, final 클래스
 * 
 * 참고로 data 클래스는 더이상 상속해서 자식을 만들 수 없음(final 클래스의 성질을 가짐)
 */


/*
 * 자바는 기본적으로 어떤 클래스를 상속받아서 새로은 클래스를 정의하는 것을 허용함
 * 		한편, final이라는 키워드를 앞에 붙인 final class 는 상속을 허용하지 않음
 * Kotlin의 경우는 반대로 open 클래스만 상속이 가능함
 * 
 * override 또한 비슷함. Java의 경우는 기본적으로 final을 붙이지 않은 메소드는 오버라이드를 허용함
 * 					  Kotlin의 경우는 open을 붙인 method만 오버라이드를 허용함
 * override 관련 또 한가지 차이점: Java의 경우는 @Override 표시를 "권장" 할 뿐임( 안해도 에러는 안남, 하위호환을 위해..)
 * 							  그러나 Kotlin은 override는 '의무' 이며 빼먹으면 Compile Error 가 남.
 */

// class A()

// // A 를 상속해서 B라는 클래스를 정의하려고 함
// class B() : A() // BAAAAAM!! => Error: This type is final, so it can't be inherited from.
// /*
//  * Kotlin은 open 클래스만 상속 가능하고 기본적으로 클래스는 상속을 허용하지 않는다.
//  * 그러니까 Java 프로그래머에게 설명한다면 Kotlin 클래스는 기본적으로 final 이다.
//  * 
//  */

// fun main() {
//     val a: A = A() // Kotlin은 new같은거 안씀....ㄷㄷ // val a = A()  도 가능함.. 이정도는 알아버림..
//     print("Hello World")
// }

// open class A() {
//     open fun hello() { // fun 을 open fun 으로 바꾸면 ... 됨..... ㄷㄷ (앞으로 override할 가능성이 있다면 open을 붙이기..)
//         println("Hello A!")
//     }
// }

// class B(): A() {
//     override fun hello() { // 이렇게 해주면 된다.. 그리고 실행했을 떄... 결과는... Error: 'hello' in 'A' is final and cannot be overridden
//         // override를 해도 Error이 나는 이유는 open class A() 에서 override 허용을 하지 않음. 이걸 풀려면 앞에 open 키워드를 붙여야 함.

//         println("Hey! It's me!, I am a B!  ")
//     }
// }

// fun main() {
//     val a1 = A()
//     a1.hello()
    
//     // B는 왜 open이 필요없나? A 클래스에 있는 내용을 그대로 상속받았기 때문에.. (open 클래스로 되어 있음)
//     val a2: A = B() // 이건 B객체가 아니라 상위 클래스 정적 타입을 잇는 변수에다가 하위 클래스 객체를 초기화 하거나 대입할 수 있으니.. 동적 바인딩 됨.
//     a2.hello() // class B(): A() 만 되어있는 상태에서는 정상 작동 (hello A)
// }


/*
 * sealed 클래스
 * abstract 클래스의 경우는 파일을 넘어선 다른 파일에서 상속이 가능함
 * 그러나 이 sealed 클래스의 경우는 abstract와 유사하나 같은 파일 내에서만 상속이 가능하며 다른 파일에서는 이것을 상속할 수 없음
 * 
 * 
 * * 싱글톤 패턴
 * 코틀린은 언어적으로 싱글톤 패턴을 지원함
 */

// sealed class ATree
// data class Node(val value: Int, val left: ATree, val right: ATree): ATree()
// // class Null: ATree() {
// //     override public fun toString() = "Null"
// //     만약 Null 객체가 똑같은게 여러개 생성되면 Object Equality는 동일하지 않을 것이고, 수동으로 .. 자바에서는 나름 현란한 기법으로 직접 프로그래밍을 해서 val nil = Null() 과 val nil2 = Null() 이 같음을 프로그래밍 해야함
// //     그러나 Kotlin 은 싱글톤을 자체적으로 지원한다... class 대신 object 를 입력해보자..
// // }
// // 
// object Null: ATree() {// 싱글톤 객체 ( 이 우주속에 유일무이하게 하나...... ) / object로 정의된 Null 은 클래스이면서 객체의 의미로 사용가능!
//     override public fun toString() = "Null";
// }

// fun size(t: ATree): Int =
//     when (t) {
//         is Node -> 1 + size(t.left) + size(t.right)		// ATree 에서 Node 로 스마트 캐스팅
//         is Null -> 0									// ATree 에서 Null 로 스마트 캐스팅
//         else -> throw Error("ATree other than Node or Null") // 다른 파일에서 ATree를 상속해서 만들어진 구체적인 클래스가 있는 경우... // 이거 없으면 안된다. 모든 경우의 수를 고려하지 않았다고 함.
//     }

// fun main() {
//     // 빈 트리는 다 똑같은 빈 트리야.
//     val nil: ATree = Null  // 사실은 딱 한번만 만들어서 쓰고 싶다.
//     val nil2: ATree = Null // 근데 그냥 클래스로 하면 이렇게 또 다른 널 오브젝트를 만들 수 있다는게 문제.
    
//     val t1: ATree = Node(2, Node(1, nil, nil), Node(3, nil, nil))
//     val t2: ATree = Node(2, Node(1, nil, nil), Node(3, nil, nil2)) // nil2 가 null으로 같아짐... object 로 정의했기 때문에.. 싱글톤,..
//     println(t1)
//     println(t2)
//     println(t1 === t2) // Object Equality (참고로 Java에서는 == )
//     println(t1 == t2) // data 클래스이므로 자동으로 적절히 잘 만들어진 값 비교 ..
    
//     println(nil == nil2)
// }

// enum 클래스
// 
//
//
//
//
//

// 인터페이스는 스스로 학습...
// 

/*
 * 제네릭
 */

// data class Vec2D<T>(val x: T, val y: T)

// fun <T> getx(v: Vec2D<T>): T {
//     return v.x
// }

// fun main() {
//     val v1: Vec2D<Int> = Vec2D<Int>(3,4)
//     val v2: Vec2D<Double> = Vec2D<Double>(3.33, 4.44)
//     println(v1)
//     println(v2)
	
//     println(getx(v1))
//     println(getx(v2))
// }

// 클래스 뿐 아니라 함수도 제네릭을 만들 수 있다....
// 

/**
 * 제네릭 관련 추가 내용
 * 
 * T1이 T2의 하위개념일 때, T1(구체적인 경우.. 과일) < T2 (넓은 범위.. 음식) 라고 표기하기로 하자
 * 그러면 T1 < T2일때 C<T1>과 C<T2>의 관계는 어떻게 되는 것이 좋을까?
 * 그떄그떄 다르다. 무변, 공변, 반변 세가지 다른 경우를 알아보자.
 * 	무변: C<T1>, C<T2> 가 완전히 관련이 없다는 것.  
 * 	공변: C<T1> 이 C<T2> 의 하위개념..
 * 	반변: C<T1> 이 C<T2> 의 상위개념..
 * 
 * 	반변의 경우 즉 T1 < T2일때 C<T1> > C<T2> 인 것이 바람직한 경우를 다룬다.
 */
 
// open class Jewelry() { override public fun toString() = "보석" } // 일반적인 보석/장신구
// class Earring() : Jewelry() { override public fun toString() = "귀걸이"} // 귀걸이
// class Necklace() : Jewelry() { override public fun toString() = "목걸이" } // 목걸이

// class Box<in T>() {
//     var count = 0;
//     fun save(item: T) = println("${item} 들어옴. 현재 이 보관함에는 총 ${++count}개를 보관중입니다.")
// }

// // Box<Jewelry> // 아무 종류의 보석을 담을 수 있는 보관함
// // Box<Earring> // 귀걸이를 담을 수 있는 보관함
// // Box<Necklace> // 목걸이를 담을 수 있는 보관함
// // 
// // 일반적으로  x: T2 이고 T1 < T2라면 x에 T1 객체를 할당하도 됩니다.
// // 
// // 
    
// fun main() {
// //     val box: Box<Earring> = Box<Earring>() // 귀걸이 전용 보관함 타입의 변수를 귀걸이 전용 보관함 객체로 초기화
// //     val box: Box<Jewelry> = Box<Jewelry>() // 귀걸이 전용 보관함이 아니라도 귀걸이를 담을 수 있는 기능이 되는군
//     val box: Box<Earring> = Box<Jewelry>() // 그렇다면 귀걸이 전용 보관함이 필요한 곳에 일반 보석함 써도 되는거 아닌가..? < 이럴때는 반변임.. class Box<in T>() 하면 오류가 안남...
    
//     val earring1 = Earring()
//     val earring2 = Earring()
//     val earring3 = Earring()
    
//     box.save(earring1)
//     box.save(earring2)
//     box.save(earring3)
    
//     println("Hello World!")
// }



// 코틀린에서 Array와 List(컬렉션의 일종)
// Array는 Java의 배열과 동일 ( 완전히 호환 ) // 내부에서 동일하게 처리..
// List는 Java의 컬렉션 라이브러리와 같은 개념이지만 ( 완전히 호환은 아닐 수도 있음.. )
// 		List는 인터페이스 Java의 List 인터페이스랑 코틀린의 List 인터페이스랑 같은 건 아님
// 		단, 코틀린의 List 인터페이스를 구현하는 클래스는 Java의 ArrayList라던가 이런 것과 연동되어 있음

// fun main() {
//     // 코틀린에서는 배열 또한 제너릭 타입으로 처리한다.
//     // 	=> 코틀린은 처음부터 제네릭이 포함되어 있기 때문 (자바의 경우는 배열이 먼저 있고 나중에 제네릭이 추가되었었음.)
//     val arr: Array<String> = arrayOf("Hello", "World", "bye", "sky")
//     println(arr.size)
//     println(arr) // 배열의 toString을 이용해서 나옴 // 결과: [Ljava.lang.String;@5a07e868 ... 많이 보던거... 얜 Java의 배열이구나.. // toString이 좀 불친절하네..
//     println( arr[1] )
//     println( arr.get(1) )
    
//     val list1: List<String> = listOf("Hello", "World", "bye", "sky")
//     println(list1)
// //     리스트 자체를 Array로부터 만들어 낼 수는 없을까...?
//     val list2: List<String> = arr.toList() //
//     println(list2)
//     println( list2[1] ) // 어 이게 된다고? Java에서는 안되었는데...  코틀린은 연산자 오버로딩 가능 [] 연산자의 의미를 정의 
// }

// 메인 함수에 프로그램 인자 (또는 명령줄 인자)
fun main(args: Array<String>) { //메인 함수에서 넘어오는 명령줄 인자
    println(args.size)
    println(args.toList())
}
























