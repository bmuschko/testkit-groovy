import org.gradle.testkit.runner.GradleRunner
import static org.gradle.testkit.runner.TaskOutcome.*
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class MyPlugin extends Specification {
    
    @Rule TemporaryFolder testProjectDir = new TemporaryFolder()
    
    def "can parse XML"() {
        given:
        testProjectDir.newFile('build.gradle') << """
            plugins {
                id "myplugin"
            }
        """

        when:
        def result = GradleRunner.create()
            .withProjectDir(testProjectDir.root)
            .withArguments('tasks')
            .withPluginClasspath()
            .build()

        then:
        noExceptionThrown()
    }
}