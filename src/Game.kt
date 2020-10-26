import sun.security.pkcs11.wrapper.CK_C_INITIALIZE_ARGS

fun main(args: Array<String>) {
    //3.1 output healtPoint
    //Madrigal is in excelent condition!
    val name="Madrigal"
    //var healthPoint=100
    //3.2 Madrigal is in awful condition!
    var healthPoint=89
    //3.4 baff
    val isBlessed=true
    //3.5 Бессмертие
    val isImmortal=false
    //3.5 Аура
    //if (isBlessed && healthPoint > 50||isImmortal){
    //3.6

    val auraVisible=isBlessed && healthPoint > 50 || isImmortal
    //3.8 покращення за допомогою умовного виразу
        /*if (auraVisible) {
        println("GREEN")
    }else{
        println("NONE")
    }*/
    val auraColor=if (auraVisible) "GREEN" else "NONE"
    //3.12 println(auraColor)

    /*3.10 when
    //3.7 if (healthPoint==100) {
        //println("$name is in excelent condition!")
        //ім'я+стан здоров'я
        //3.3
        //вписати проміжні ланки
    val healthStatus = if (healthPoint==100) {
        "is in excelent condition!"
        //3.9 refactoring
        //}else if (healthPoint>=90) {
    } else if (healthPoint in 90..99) {
        //println("$name has a few scratches.")
        "has a few scratches."
    }else if (healthPoint/*>=75*/in 75..89) {
        //3.4 baff
        if (isBlessed) {
            //println("$name has come minor wounds but is healing quite quickly!")
            "has come minor wounds but is healing quite quickly!"
        } else {
            //println("$name has come minor wounds.")
            "has come minor wounds."
        }
    }else if (healthPoint/*>=15*/in 15..74) {
        //println("$name looks pretty hurt.")
        "looks pretty hurt."
    }else{
        //println("$name is in awful condition!")
        "is in awful condition!"
    } */
    val healthStatus = when (healthPoint) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    //3.7 Стан гравця
    //3.12 auraColor
    println("(Aura: $auraColor) " +
    "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")

}