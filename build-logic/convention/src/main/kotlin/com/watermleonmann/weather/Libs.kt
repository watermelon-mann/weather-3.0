package com.watermleonmann.weather

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType


fun Project.withLibs(block: VersionCatalog.() -> Unit) = libs.apply(block)

val Project.libs get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun VersionCatalog.get(alias: String) = findLibrary(alias).get()