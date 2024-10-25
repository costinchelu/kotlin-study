plugins {
    kotlin("jvm") version "2.0.0"
//    application
}


group = "ro.ccar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets.main {
    java.srcDirs("src/main/java", "src/main/kotlin")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
    implementation("io.reactivex.rxjava3:rxjava:3.1.9")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

//application {
//    mainClass.set("ro.ccar.kia.ApplicationKt")
//}

/*
default source file locations:

src/main/kotlin
src/main/java
 */