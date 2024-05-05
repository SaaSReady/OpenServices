import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.jpa") version "1.9.22"
	id("org.liquibase.gradle") version "2.2.0"
	java
}

group = "com.open-services"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.liquibase:liquibase-core:3.6.2")
	liquibaseRuntime("org.postgresql:postgresql")
	liquibaseRuntime("org.liquibase:liquibase-core:4.24.0")
	liquibaseRuntime("org.liquibase:liquibase-groovy-dsl:2.1.1")
	liquibaseRuntime("info.picocli:picocli:4.7.5")
	liquibaseRuntime("org.yaml:snakeyaml:1.33")
	developmentOnly("org.liquibase:liquibase-gradle-plugin:2.2.0")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

liquibase {
	val dbHost = System.getenv("DB_HOST")
	val dbPort = System.getenv("DB_PORT")
	val dbName = System.getenv("DB_NAME")
	val dbUser = System.getenv("DB_USERNAME")
	val dbPassword = System.getenv("DB_PASSWORD")

	activities.register("main") {
		this.arguments = mapOf(
			"logLevel" to "info",
			"changeLogFile" to "src/main/resources/db/changelog.xml",
			"url" to "jdbc:postgresql://${dbHost}:${dbPort}/${dbName}",
			"username" to dbUser,
			"password" to dbPassword
		)
	}
}

tasks.register("migrationRun") {
	dependsOn("update")
}
