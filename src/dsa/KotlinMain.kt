package dsa

fun main(){
    val data : String? = null

    println(data ?: "Hello")

    val length = data?.length ?: 0


    println(length)
}