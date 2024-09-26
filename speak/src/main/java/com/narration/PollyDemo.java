package com.narration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.InputStream;
import java.io.FileOutputStream;

public class PollyDemo {
    private final AmazonPolly polly;
    private final String outputFileName = "speech.mp3";

    public PollyDemo(String accessKey, String secretKey) {
        // Initialize AWS Polly Client
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        this.polly = AmazonPollyClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.US_EAST_1)
                .build();
    }

    public void synthesize(String text) throws IOException {
        // Create a speech synthesis request
        SynthesizeSpeechRequest synthReq = new SynthesizeSpeechRequest()
                .withText(text)
                .withVoiceId("Joanna") // Choose a voice ID
                .withOutputFormat(OutputFormat.Mp3);

        // Synthesize speech
        SynthesizeSpeechResult synthRes = polly.synthesizeSpeech(synthReq);

        // Get the audio stream and write it to a file
        try (InputStream inStream = synthRes.getAudioStream();
             FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            byte[] buffer = new byte[2 * 1024];
            int readBytes;

            while ((readBytes = inStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, readBytes);
            }
            System.out.println("Speech synthesized and saved as " + outputFileName);
        }
    }

public static void main(String[] args) {
        String accessKey = "";
        String secretKey = "";

        // Read the access key and secret key from the credentials.txt file
        try {
            List<String> lines = Files.readAllLines(Paths.get("credentials.txt"));
            if (lines.size() >= 2) {
                accessKey = lines.get(0).trim();  // First line for access key
                secretKey = lines.get(1).trim();  // Second line for secret key
            } else {
                System.err.println("Credentials file must contain at least two lines.");
                return;
            }
        } catch (IOException e) {
            System.err.println("Error reading credentials file: " + e.getMessage());
            return;
        }

        PollyDemo pollyDemo = new PollyDemo(accessKey, secretKey);
        try {
            pollyDemo.synthesize("Hello, my name is Polly! I'm from AWS!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
