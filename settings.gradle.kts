pluginManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        includeBuild("build-logic")
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Weather"

include(":app")
include(":shared:entity")
include(":api:data")
include(":core:data")
include(":core:domain")
