package ch13.ex2_InvokeConventionInDSLs

class DependencyHandler {

    // regular command API
    fun implementation(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    // defines invoke(0 to support DSL API
    // the "this" expression becomes a receiver of the body function: this.body()
    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}

fun main() {
    val dependencies = DependencyHandler()

    // dependencies.invoke({ this.implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0") })
    dependencies.implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    // Added dependency on org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
    }
    // Added dependency on org.jetbrains.kotlinx:kotlinx-datetime:0.5.0
}
