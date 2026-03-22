# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
./gradlew build          # Build the project
./gradlew test           # Run all tests
./gradlew bootJar        # Build the executable jar
./gradlew clean          # Clean build artifacts
./gradlew test --tests "orsn.aidevs4.aidevs4.SomeTest"  # Run a single test class

# Run the interactive shell (bootRun doesn't work — Gradle doesn't allocate a PTY)
java -jar build/libs/aidevs4-0.0.1-SNAPSHOT.jar
```

## Running in IntelliJ

`bootRun` and Spring Boot run configurations don't allocate a PTY, so the shell exits immediately. Use a **Shell Script** run configuration instead:

1. **Run → Edit Configurations → + → Shell Script**
2. **Script text:** `java -jar build/libs/aidevs4-0.0.1-SNAPSHOT.jar`
3. Enable **"Execute in the terminal"**
4. **Before launch → + → Run Gradle task:** `bootJar`

## Architecture

This is a **Spring Boot CLI application** using Spring Shell for interactive command-line interaction. The main package is `orsn.aidevs4.aidevs4`.

**Key dependencies:**
- Spring Boot 4.0.4
- Spring Shell 4.0.1 — commands are defined as methods annotated with `@Command` on Spring-managed beans
- Java 25 (configured via Gradle toolchain)

**Adding shell commands:** Annotate a method with `@Command` (and optionally `@CommandAvailability`) in any Spring-managed component. Spring Shell auto-discovers them.
