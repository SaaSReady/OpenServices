package com.openservices.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpenServicesApplication

fun main(args: Array<String>) {
	runApplication<OpenServicesApplication>(*args)
}
