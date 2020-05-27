package com.odp.creational.factory;

enum SenderType {
    EMAIL, TXT, FAX
}

public interface MessageSender {

    static MessageSender getSender(SenderType senderType) {
        if (senderType.equals(SenderType.EMAIL)) {
            return new EmailSender();
        } else if (senderType.equals(SenderType.TXT)) {
            return new TxtMsgSender();
        } else {
            throw new RuntimeException("Sender type is not supported yet");
        }
    }
}
