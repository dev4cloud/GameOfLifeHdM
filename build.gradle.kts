/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java Library project to get you started.
 * For more details take a look at the Java Libraries chapter in the Gradle
 * User Manual available at https://docs.gradle.org/5.3.1/userguide/java_library_plugin.html
 */

plugins {
    // Apply the java-library plugin to add support for Java Library
    `java-library`
    `maven-publish`
}

group = "com.ibm.gol"
version = "1.0.0"

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

//TODO: add source jar
//task sourceJar(type: Jar) {
//    from sourceSets.main.allJava
//}

dependencies {
    // This dependency is exported to consumers, that is to say found on their compile classpath.
    //api("org.apache.commons:commons-math3:3.6.1")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    //implementation("com.google.guava:guava:27.0.1-jre")

    // Use JUnit test framework
    testImplementation("junit:junit:4.12")
}
// test
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val maven_username: String? by project
val maven_password: String? by project

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            
        }
    }
    repositories {
        maven {
            // change to point to your repo, e.g. http://my.org/repo
            url = uri("https://mymavenrepo.com/repo/gMeEUIpLpQJqRkWqgW0E/")
            credentials {
                username = maven_username  
                password = maven_password 
            }
        }
    }
}


