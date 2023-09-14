plugins {
    id("java")
}

group = "com.mjc.school"
version = "unspecified"

repositories {
    mavenCentral()
}

//tasks.withType<Jar> {
//    manifest {
//        attributes("Main-Class" to "com.mjc.school.Main")
//    }
//    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
//}



dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":module-web"))
    implementation(project(":module-dto"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Jar>("uberJar") {
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = "com.mjc.school.Main"
    }
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar")}.map { zipTree(it) }
    })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}