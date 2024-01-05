package com.mockito.juzyz.testdoubletypes.dummy;

/*
This service is used to show how to test
a dummy double WITHOUT using Mockito
and used just to compile the code.
*/
public class DummyEmailService implements EmailService {

    @Override
    public void sendEmail(String message) {
        throw new AssertionError("Method is not implemented!");
    }
}
