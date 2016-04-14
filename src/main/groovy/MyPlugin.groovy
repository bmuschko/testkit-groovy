import org.gradle.api.Plugin
import org.gradle.api.Project
import groovy.util.XmlSlurper

class MyPlugin implements Plugin<Project> {
    void apply(Project project) {
        def rootNode = new XmlSlurper().parseText(
            '<root><one a1="uno!"/><two>Some text!</two></root>' )

         assert rootNode.name() == 'root'
         assert rootNode.one[0].@a1 == 'uno!'
         assert rootNode.two.text() == 'Some text!'
         rootNode.children().each { assert it.name() in ['one','two'] }
    }
}