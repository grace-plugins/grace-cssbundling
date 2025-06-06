/*
 * Copyright 2024 the original author or authors.
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
package org.graceframework.plugins.cssbundling

import grails.plugins.Plugin

class CssBundlingGrailsPlugin extends Plugin {

    def version = '0.1.0-SNAPSHOT'
    def grailsVersion = "2023.0.0 > *"
    def loadAfter = ['core']

    def pluginExcludes = [
        "app/views/error.gsp"
    ]

    def title = "Grace CSS Bundling Plugin"
    def author = "Michael Yan"
    def authorEmail = "rain@rainboyan.com"
    def description = '''\
Bundle and process CSS in Grace with Tailwind, PostCSS, and Sass via Node.js.
'''
    def profiles = ['web']

    def documentation = "https://github.com/grace-plugins/grace-cssbundling"

    // Extra (optional) plugin metadata
    def license = "APACHE"
    def organization = [ name: "Grace Plugins", url: "https://github.com/grace-plugins/" ]
    def developers = [ [ name: "Michael Yan", email: "rain@rainboyan.com" ]]
    def issueManagement = [ system: "GitHub", url: "https://github.com/grace-plugins/grace-cssbundling/issues" ]
    def scm = [ url: "https://github.com/grace-plugins/grace-cssbundling.git" ]

}
