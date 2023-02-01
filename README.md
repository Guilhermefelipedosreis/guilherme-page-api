# guilherme-page-api
<p>API for personal page, able to create, list and delete new messages.</p>
<p>Download all the files into a folder. Open the project, open src/main/resources/application.properties to configure to your database connection. 
Create a new schema and then start the application.</p>
<p>The application can be tested using Insomnia or similar. 
A POST method from a http request to /messages, containing "name", "email", "phone" and "content" to create new messages.
A GET to /messages to obtain the list of messages.
A DELETE method to /messages/{id} to delete a message.
</p>
