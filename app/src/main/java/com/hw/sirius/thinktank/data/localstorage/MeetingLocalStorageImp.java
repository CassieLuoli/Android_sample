package com.hw.sirius.thinktank.data.localstorage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hw.sirius.thinktank.data.model.MeetingEvent;
import com.hw.sirius.thinktank.application.ThinkTankApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MeetingLocalStorageImp implements MeetingLocalStorage {

    public static final String FILENAME = "meetingEventList";

    @Override
    public void save(List<MeetingEvent> meetingEventList) {
        saveToLocalStorageFile(meetingEventList);
    }

    private void saveToLocalStorageFile(List<MeetingEvent> meetingEventList) {
        Gson gson = new Gson();
        String json = gson.toJson(meetingEventList);

        try {
            File cacheDir = ThinkTankApp.getContext().getCacheDir();
            File tempFile = new File(cacheDir.getPath(), FILENAME);

            FileOutputStream fos = new FileOutputStream(tempFile);
            fos.write(json.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MeetingEvent> get(String userName) {
        List<MeetingEvent> meetingEvents = new ArrayList<>();
        try {
            File cacheDir = ThinkTankApp.getContext().getCacheDir();
            File tempFile = new File(cacheDir, FILENAME);
            FileInputStream inputStream = new FileInputStream(tempFile);

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();
            int c = bufferedReader.read();
            while (c != -1) {
                stringBuilder.append(c);
                c = bufferedReader.read();
            }

            inputStream.close();

            Gson gson = new Gson();
            List<MeetingEvent> events = gson.fromJson(stringBuilder.toString(), new TypeToken<List<MeetingEvent>>() {
            }.getType());
            meetingEvents.addAll(events);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return meetingEvents;
    }
}
