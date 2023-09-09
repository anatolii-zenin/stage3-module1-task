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
    implementation(project(":module-repository"))
}

tasks.test {
    useJUnitPlatform()
}