package com.ai.SpringAiDemo;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

/**
 * @author sahil.sharma
 */

/**
 * Service class for generating images using OpenAI's image generation models.
 * Provides methods to generate images based on user prompts with customizable options.
 */
@Service
public class ImageService {

  private final OpenAiImageModel imageModel;

  public ImageService(OpenAiImageModel imageModel) {
    this.imageModel = imageModel;
  }

  /**
   * Generates an image based on the given prompt.
   *
   * @param prompt the textual description of the image to be generated
   * @return the generated image encapsulated in an {@link ImageResponse}, or {@code null} if not implemented
   */
  public ImageResponse generateImage(String prompt) {
    return null;
  }

  /**
   * Generates multiple images based on the given prompt with specific dimensions and count.
   *
   * @param prompt    the textual description of the images to be generated
   * @param width     the desired width of the images
   * @param height    the desired height of the images
   * @param numImages the number of images to generate
   * @return the generated images encapsulated in an {@link ImageResponse}
   */
  public ImageResponse generateImageOptions(String prompt, int width, int height, int numImages) {
    return imageModel.call(new ImagePrompt(prompt, OpenAiImageOptions.builder()
        .withModel("dall-e-2")
        .withWidth(width)
        .withHeight(height)
        .withN(numImages)
        .build()));
  }
}
