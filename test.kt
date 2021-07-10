//摂氏○○度というデータクラス
data class CelsiusTemperature(var temperature: Double)

// 仕様変更
// ・摂氏-華氏に変換できるようにしろ。
// ・華氏について temperatureで表示できるようにしろ
data class FahrenheitTemperature(var celsiusTemperature: CelsiusTemperature) {
    //華氏のデータをtemperatureで設定。華氏temperatureを設定したら(set)摂氏の設定も変える。
    var temperature: Double
        get() = convertCelsiusToFahrenheit(celsiusTemperature.temperature)
        set(temperatureInF) {
            celsiusTemperature.temperature = convertFahrenheitToCelsius(temperatureInF)
        }
    //摂氏華氏変換式
    private fun convertFahrenheitToCelsius(f: Double): Double = (f - 32) * 5 / 9
    private fun convertCelsiusToFahrenheit(c: Double): Double = (c * 9 / 5) + 32
}

fun main() {
    val celsiusTemperature = CelsiusTemperature(0.0)
    val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)

    celsiusTemperature.temperature = 36.6
    println("${celsiusTemperature.temperature} C -> ${fahrenheitTemperature.temperature} F")

    fahrenheitTemperature.temperature = 100.0
    println("${fahrenheitTemperature.temperature} F -> ${celsiusTemperature.temperature} C")
}
