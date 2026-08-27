/*
 * Copyright 2024-2026 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.nio.file.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import org.graceframework.plugins.cssbundling.CssBundlingGrailsPlugin

namespace 'css'
description("Install CSS framework") {
    usage "grace css:install [bootstrap]"
    argument name: "Name", description: "The name of the CSS Bundler"
}
visible false

String bundler = args[0]

URL url = CssBundlingGrailsPlugin.getResource("/META-INF/templates/$bundler")
def projectDir = executionContext.baseDir

use(FileCategory) {
    def assetsDir = projectDir.join('app/assets')
    def applicationCss = projectDir.join('app/assets/stylesheets/application.css')
    def applicationJs = projectDir.join('app/assets/javascripts/application.js')
    def jarFile = url.toFile()

    jarFile.unzip(assetsDir, "META-INF/templates/$bundler/")

    if (bundler == 'bootstrap') {
        applicationCss.insertBefore('*= require main', '''*= require bootstrap
*= require bootstrap-icons
''')
        applicationJs.insertBefore('//= require_self', '''//= require jquery.min
//= require bootstrap.bundle
''')
    }
}

consoleLogger.addStatus "Copying the $bundler CSS and JavaScripts to 'app/assets'"


class FileCategory {

    def static unzip(File zipFile, File distDir, String path) {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))
        ZipEntry entry

        while (entry = zis.nextEntry) {
            String fileName = entry.name
            if (!fileName.startsWith(path)) {
                continue
            }
            File file = new File(distDir, fileName - path)
            if (fileName.endsWith('/')) {
                if (file.isFile()) {
                    file.delete()
                }
                file.mkdirs()
            }
            else {
                Files.copy(zis, file.toPath(), StandardCopyOption.REPLACE_EXISTING)
            }
        }

        zis.closeEntry()
        zis.close()
    }

    def static toFile(URL url) {
        new File(new URI(url.file.takeBefore('!')))
    }

    def static join(File file, String path) {
        new File(file, path)
    }

    def static leftShift(File file, URL url) {
        url.withInputStream { is ->
            file.withOutputStream { os ->
                def bs = new BufferedOutputStream(os)
                bs << is
            }
        }
    }

    def static leftShift(File dest, File src) {
        src.withInputStream { is ->
            dest.withOutputStream { os ->
                def bs = new BufferedOutputStream(os)
                bs << is
            }
        }
    }

    def static insertAfter(File file, String searchString, String text) {
        if (!file?.exists()) return
        String content = file.text
        if (content?.indexOf(searchString) <= 0) return
        String before = content.takeBefore(searchString)
        String after = content.takeAfter(searchString)
        StringBuffer newContent = new StringBuffer()
        newContent << before << searchString << text << after
        file.text = newContent
    }

    def static insertBefore(File file, String searchString, String text) {
        if (!file?.exists()) return
        String content = file.text
        if (content?.indexOf(searchString) <= 0) return
        String before = content.takeBefore(searchString)
        String after = content.takeAfter(searchString)
        StringBuffer newContent = new StringBuffer()
        newContent << before << text << searchString << after
        file.text = newContent
    }

}
