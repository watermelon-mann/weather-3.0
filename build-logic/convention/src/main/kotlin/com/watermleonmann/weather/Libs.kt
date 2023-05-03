package com.watermleonmann.weather

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType


fun Project.withLibs(block: VersionCatalog.() -> Unit): VersionCatalog = libs.apply(block)

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun VersionCatalog.getLibrary(alias: String) = findLibrary(alias).get()

fun VersionCatalog.getVersion(alias: String) = findVersion(alias).get()