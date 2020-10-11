package MailSever;

import java.io.IOException;

import library.ILinkedList;

public interface IApp {
    boolean signin(String email, String password) throws Exception;

    boolean signup(IContact contact) throws IOException;

    IMail[] listEmails(int page) throws Exception;

    void deleteEmails(ILinkedList mails) throws IOException, ClassNotFoundException;

    boolean compose(IMail email);

	void moveEmails(ILinkedList mails, IFolder des) throws IOException, ClassNotFoundException;

	void setViewingOptions(IFolder folder, IFilter filter, ISort sort);
}
