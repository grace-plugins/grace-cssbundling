[![Main branch build status](https://github.com/grace-plugins/grace-cssbundling/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-plugins/grace-cssbundling/actions?query=workflow%3A%Grace+CI%22)
[![Apache 2.0 license](https://img.shields.io/badge/License-APACHE%202.0-green.svg?logo=APACHE&style=flat)](https://opensource.org/licenses/Apache-2.0)
[![Latest version on Maven Central](https://img.shields.io/maven-central/v/org.graceframework.plugins/cssbundling.svg?label=Maven%20Central&logo=apache-maven&style=flat)](https://search.maven.org/search?q=g:org.graceframework.plugins)
[![Grace Document](https://img.shields.io/badge/Grace_Document-latest-blue?style=flat&logo=asciidoctor&logoColor=E40046&labelColor=ffffff&color=f49b06)](https://plugins.graceframework.org/grace-cssbundling/latest/)
[![Grace on X](https://img.shields.io/twitter/follow/graceframework?style=social)](https://x.com/graceframework)

[![Groovy Version](https://img.shields.io/badge/Groovy-4.0.23-blue?style=flat&color=4298b8)](https://groovy-lang.org/releasenotes/groovy-4.0.html)
[![Grace Version](https://img.shields.io/badge/Grace-2023.0.0-blue?style=flat&color=f49b06)](https://github.com/graceframework/grace-framework/releases/tag/v2023.0.0)
[![Spring Boot Version](https://img.shields.io/badge/Spring_Boot-3.0.13-blue?style=flat&color=6db33f)](https://github.com/spring-projects/spring-boot/releases)

# Grace CSS Bundling Plugin

Bundle and process CSS in Grace with Tailwind, PostCSS, and Sass via Node.js.

## Grace Version

- Grace **2023.0.0**

## Ducumentation

* [latest](https://plugins.graceframework.org/grace-cssbundling/latest/)

## Usage

### Add `cssbundling` plugin

Add `cssbundling` plugin to `build.gradle`,

```gradle
repositories {
    mavenCentral()
}

dependencies {
    implementation "org.graceframework.plugins:cssbundling:VERSION"
}
```

### Install Bootstrap

```
$ grace css:install bootstrap
```

## Development

### Build from source

```
git clone https://github.com/grace-plugins/grace-cssbundling.git
cd grace-cssbundling
./gradlew publishToMavenLocal
```

## Release notes

- [Release notes](https://plugins.graceframework.org/grace-cssbundling/latest/guide/changelog.html)

## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Plugins](https://github.com/grace-plugins)