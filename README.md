# Email Client

This is a simple Java email client for sending plain text and HTML emails with attachments. It uses the JavaMail API to send emails through a local SMTP server.

## Features

- Send plain text and HTML emails
- Send emails with attachments
- Uses a local SMTP server for sending emails

## Requirements

- Java Development Kit (JDK)
- JavaMail API

## Setup

1. Clone the repository:

    ```sh
    git clone https://github.com/yourusername/email-client.git
    ```

2. Navigate to the project directory:

    ```sh
    cd email-client
    ```

3. Compile the project:

    ```sh
    javac -cp "path/to/javamail.jar" com/mycompany/emailclientmo/EmailClientmo.java
    ```

4. Run the project:

    ```sh
    java -cp ".;path/to/javamail.jar" com.mycompany.emailclientmo.EmailClientmo
    ```

## Configuration

- Update the `to` and `from` email addresses in the `EmailClientmo.java` file.
- Ensure your local SMTP server is running on `localhost` and listening on port `1025`.

## Usage

- The `sendEmail` method sends a simple HTML email.
- The `sendAttach` method sends an email with an attachment.

### Example

Here's the main method example:

```java
public static void main(String[] args) {
    System.out.println("Prepare to send message...");

    String htmlMessage = "<h1>Hello</h1><p>This is an HTML message for security check.</p>";
    String subject = "Codeclause: Confirmation";
    String to = "recipient@example.com"; // Enter the recipient's email
    String from = "sender@example.com"; // Enter the sender's email

    sendEmail(htmlMessage, subject, to, from);
    sendAttach(htmlMessage, subject, to, from);
}
