package io.github.shreyanshp.cucumber.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.github.shreyanshp.cucumber.runner.runtime.ExtendedRuntimeOptions;

import cucumber.api.cli.Main;

public final class CLIRunner {
    private CLIRunner() {
    }
    public static void main(String[] argv) throws Throwable {
        ExtendedRuntimeOptions[] extendedOptions = new ExtendedRuntimeOptions[1];
        List<String> input = new ArrayList<String>(Arrays.asList(argv));
        extendedOptions[0] = new ExtendedRuntimeOptions(input);
        byte exitstatus = Main.run(argv, Thread.currentThread().getContextClassLoader());
        ReportRunner.run(extendedOptions[0]);
        System.exit(exitstatus);
    }
}
