val javaVersion = JavaVersion.VERSION_16
val kotlinLanguageVersion = "1.6"
val liquibaseVersion = "4.7.1"
val liquibaseSessionLockVersion = "1.5.0"

group = "land.tbp"
version = "0.0.1"
java.sourceCompatibility = javaVersion
java.targetCompatibility = javaVersion

plugins {
    application
    java
    kotlin("jvm") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // database
    implementation("org.xerial:sqlite-jdbc:3.36.0.3")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.liquibase:liquibase-core:$liquibaseVersion")
    implementation("com.github.blagerweij:liquibase-sessionlock:$liquibaseSessionLockVersion")
    implementation("org.yaml:snakeyaml:1.30")
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            @Suppress("SuspiciousCollectionReassignment")
            freeCompilerArgs += listOf("-Xjsr305=strict")
            jvmTarget = javaVersion.majorVersion
            languageVersion = kotlinLanguageVersion
            apiVersion = kotlinLanguageVersion
        }
    }


    test {
        useJUnitPlatform()
    }

    wrapper {
        gradleVersion = "7.4"
    }
}
