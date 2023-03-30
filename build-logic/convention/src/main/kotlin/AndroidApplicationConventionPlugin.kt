import com.android.build.api.dsl.ApplicationExtension
import com.watermleonmann.weather.configureAndroidApplication
import com.watermleonmann.weather.configureKotlinAndroid
import com.watermleonmann.weather.configureSdkVersions
import com.watermleonmann.weather.configureTest
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }
        configureAndroidApplication()
        configureSdkVersions()
        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)
        }
        configureTest()
    }
}