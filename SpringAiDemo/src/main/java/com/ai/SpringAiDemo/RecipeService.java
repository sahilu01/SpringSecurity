package com.ai.SpringAiDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author sahil.sharma
 */
@Service
public class RecipeService {

  private final ChatModel chatModel;

  public RecipeService(ChatModel chatModel) {
    this.chatModel = chatModel;
  }

  public String createRecipe(String ingredients, String cuisine, String diataeryRestrictions) {
    var template = """
        I want to to create a recipe using the following ingredients: {ingredients},
        The cuisine type i prefer is {cuisine},
           I have the following dietary restrictions: {dietaryRestrictions}.
        Please provide me with a detailed recipe including title, ingredients, instructions and nutritional information.
        """;

    PromptTemplate promptTemplate = new PromptTemplate(template);

    Map<String, Object> params =
        Map.of("ingredients", ingredients, "cuisine", cuisine, "dietaryRestrictions", diataeryRestrictions);

    Prompt prompt = promptTemplate.create(params);

    return  chatModel.call(prompt).getResult().getOutput().getContent();
  }
}
