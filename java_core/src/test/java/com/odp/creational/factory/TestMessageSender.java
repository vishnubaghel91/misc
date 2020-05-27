package com.odp.creational.factory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class TestMessageSender {

    @Test
    public void testGetSender() {
        MessageSender sender = MessageSender.getSender(SenderType.EMAIL);
        Assert.assertTrue(sender instanceof EmailSender);
        sender = MessageSender.getSender(SenderType.TXT);
        Assert.assertTrue(sender instanceof TxtMsgSender);
    }

    @Test(expected = RuntimeException.class)
    public void testGetSenderError() {
        MessageSender.getSender(SenderType.FAX);
    }

}
