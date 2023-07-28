pluginManagement {
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
include(":shared:common")
include(":shared:entity")
include(":shared:testing")
include(":shared:testing:data-mock")

include(":api:data")

include(":core:data")
include(":core:domain")
include(":core:ui")

include(":feature")
include(":feature:cities")
