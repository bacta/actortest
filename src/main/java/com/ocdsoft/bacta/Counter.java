package com.ocdsoft.bacta;

import co.paralleluniverse.fibers.SuspendExecution;

/**
 * Created by kyle on 3/28/2017.
 */
public interface Counter {
    String count(String text) throws SuspendExecution;
}
