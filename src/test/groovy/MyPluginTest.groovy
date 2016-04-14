import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class MyPluginTest extends Specification {
    
    @Rule TemporaryFolder testProjectDir = new TemporaryFolder()
    
    def "can parse XML"() {
        given:
        testProjectDir.newFile('build.gradle') << """
            plugins {
                id "myplugin"
            }
        """

        when:
        GradleRunner.create()
            .withProjectDir(testProjectDir.root)
            .withArguments('tasks')
            .withPluginClasspath()
            .withDebug(true)
            .build()

        then:
        noExceptionThrown()
    }
}