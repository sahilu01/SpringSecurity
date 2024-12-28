package com.ai.SpringAiDemo;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

/**
 * @author sahil.sharma
 */

/**
 * Service class responsible for transcribing audio files using the OpenAI transcription API.
 * It leverages the OpenAiAudioTranscriptionModel to process audio files and return transcribed text.
 */
@Service
public class TranscriptionService {

  private final OpenAiAudioTranscriptionModel transcription;

  /**
   * Constructs a new TranscriptionService instance.
   *
   * @param transcription the OpenAI audio transcription model used for processing audio files
   */
  public TranscriptionService(OpenAiAudioTranscriptionModel transcription) {
    this.transcription = transcription;
  }

  /**
   * Transcribes an audio file into text using the OpenAI transcription API.
   *
   * @return the transcribed text from the audio file
   */
  public String transcribeAudio() {

    var transcriptionOptions = OpenAiAudioTranscriptionOptions.builder()
        .withResponseFormat(OpenAiAudioApi.TranscriptResponseFormat.TEXT)
        .withTemperature(0f)
        .build();

    var audioFile = new FileSystemResource("src/main/java/com/ai/SpringAiDemo/audio/Monologue.ogg");

    AudioTranscriptionPrompt transcriptionRequest = new AudioTranscriptionPrompt(audioFile, transcriptionOptions);
    AudioTranscriptionResponse response = transcription.call(transcriptionRequest);

    return response.getResult().getOutput();

  }
}
