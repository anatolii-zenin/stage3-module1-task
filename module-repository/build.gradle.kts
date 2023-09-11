plugins {
    id("java")
}

group = "com.mjc.school"
version = "unspecified"

repositories {
    mavenCentral()
}

tasks {
    val sourceJar by creating(Jar::class){
        from(sourceSets["main"].allSource)
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    //implementation("com.fasterxml.jackson.core:jackson-core:2.14.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.14.2")
    //implementation("com.fasterxml.jackson.module:jackson-modules-java8:2.14.2")
    //implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:2.14.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
    //implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.14.2")
    implementation("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
}

tasks.test {
    useJUnitPlatform()
}