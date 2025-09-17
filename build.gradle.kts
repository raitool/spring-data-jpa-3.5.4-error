plugins {
    id("java")
    id("io.spring.dependency-management") version "1.1.6"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Java LTS
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // change versions as needed
    implementation("org.springframework.data:spring-data-jpa:3.5.4")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.hibernate.orm:hibernate-core:6.6.29.Final")

    runtimeOnly("org.postgresql:postgresql:42.7.4")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework:spring-test:6.2.11")
    // Testcontainers (BOM + modules you need)
    testImplementation(platform("org.testcontainers:testcontainers-bom:1.20.3"))
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql") // or mysql, kafka, etc.

    testImplementation(platform("org.assertj:assertj-bom:3.26.3"))
    testImplementation("org.assertj:assertj-core")
}

tasks.withType<Test> {
    useJUnitPlatform()
    // Helpful to see container logs when debugging locally:
    systemProperty("org.slf4j.simpleLogger.log.org.testcontainers", "WARN")
}
