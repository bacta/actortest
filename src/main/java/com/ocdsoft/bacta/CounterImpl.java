package com.ocdsoft.bacta;

import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.Strand;

/**
 * Created by kyle on 3/28/2017.
 */
public class CounterImpl implements Counter {
    int counter;

    public String count(String text) throws SuspendExecution {
        try {
            Strand.sleep(20);
            return "Response from a simple proxy server: " + text + " " + (counter++);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}