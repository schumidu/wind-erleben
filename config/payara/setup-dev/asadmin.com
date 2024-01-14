


--setup database


-- setup mail
asadmin create-javamail-resource --mailhost mail.example.com --mailuser example --fromaddress example@example.com --storeprotocol=imap --storeprotocolclass=com.sun.mail.imap.IMAPStore --transprotocol=smtp --transprotocolclass=com.sun.mail.smtp.SMTPTransport --password mypassword --auth true --property mail-smtp-starttls-enable=true --target=exampleNodeName mail/EmailNotifications

