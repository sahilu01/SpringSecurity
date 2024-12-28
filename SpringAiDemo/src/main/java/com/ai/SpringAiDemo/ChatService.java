package com.ai.SpringAiDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

/**
 * @author sahil.sharma
 */


/**
 * Service class for handling chat-based interactions using a ChatModel.
 * Provides methods to process user input and retrieve AI-generated responses.
 */
@Service
public class ChatService {

  private final ChatModel chatModel;

  /**
   * Constructs a ChatService instance with the provided ChatModel.
   *
   * @param chatModel the ChatModel used for generating responses.
   */
  public ChatService(ChatModel chatModel) {
    this.chatModel = chatModel;
  }

  /**
   * Generates a response based on the provided user message.
   *
   * @param message the input message from the user.
   * @return the AI-generated response as a String.
   */
  public String getResponse(String message) {
    return chatModel.call(message);
  }

  /**
   * Generates a response with additional configuration options based on the user message.
   *
   * @param message the input message from the user.
   * @return the AI-generated response content as a String.
   */
  public String getResponseOptions(String message) {
    ChatResponse chatResponse = chatModel.call(new Prompt(message, OpenAiChatOptions.builder()
        .withModel("gpt-4o")
        .withTemperature(0.4)
        .build()));

    return chatResponse.getResult().getOutput().getContent();
  }
}
