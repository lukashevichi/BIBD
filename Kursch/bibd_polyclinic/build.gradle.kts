import java.util.regex.Pattern.compile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version = "0.37.2"

plugins {
    kotlin("multiplatform") version "1.5.10"
    application
}

group = "me.x99"
version = "1.0"


repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
    jcenter()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
                implementation("io.ktor:ktor-server-core:$ktor_version")
                implementation("io.ktor:ktor-server-netty:$ktor_version")
                implementation("io.ktor:ktor-html-builder:$ktor_version")
                implementation("io.ktor:ktor-freemarker:$ktor_version")
                implementation ("io.ktor:ktor-gson:$ktor_version")

                implementation("ch.qos.logback:logback-classic:$logback_version")
                implementation("io.ktor:ktor-gson:$ktor_version")

                //exposed to connect sql
                implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
                implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
                implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
                implementation("mysql:mysql-connector-java:6.0.6")
                // postgres SQL
                implementation("org.postgresql:postgresql:42.3.1")
                // Hikari configuration
                implementation("com.zaxxer:HikariCP:5.0.0")
                implementation("com.h2database:h2:1.4.200")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.206-kotlin-1.5.10")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.206-kotlin-1.5.10")
                implementation(npm("react", "> 14.0.0 <=16.9.0"))
            }
        }
        val jsTest by getting
    }
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

tasks.named<Copy>("jvmProcessResources") {
    val jsBrowserDistribution = tasks.named("jsBrowserDistribution")
    from(jsBrowserDistribution)
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.named<Jar>("jvmJar"))
    classpath(tasks.named<Jar>("jvmJar"))
}

tasks {
    withType<Copy> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}