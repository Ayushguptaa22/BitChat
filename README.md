# BitChat
Blockchain based communication system

Based on the concept of simple blockchain implementation:

Chats/messages between indiviual users are strings that can be encrypted and used to create blocks that form a blockchain.

The use of blockchain here is to provide security to the authenticity of the communication channel.

![bcs](https://user-images.githubusercontent.com/68814647/179536570-93e87627-ae4a-4e52-9a63-4ecb8dcbb920.png)



Steps to execute: 
Run the Server class to setup the server
Run the client class (can run multiple times to include multiple clients)

Output: terminal/ide window displays the chat along with blocks created after each conversation

        Block consists of previous hash value, new hash value and the list of transactions.
        
        Matching new and previous hash values for two consecutive blocks, indicate that the commubication is secure.
