package io.zipcoder.casino.ioconsoles;

import io.zipcoder.casino.utilities.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class IOBlackJackConsoleTest {

    Console blackJackConsole;

    private PrintStream oldPrintStream;
    ByteArrayOutputStream testOutStream;

    @Before
    public void setup() {
        testOutStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(testOutStream);
        oldPrintStream = System.out;
        System.setOut(printStream);
    }

    @After
    public void cleanup() {
        System.setOut(oldPrintStream);
    }





}