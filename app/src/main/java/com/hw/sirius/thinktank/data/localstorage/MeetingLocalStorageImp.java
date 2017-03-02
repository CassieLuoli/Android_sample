package com.hw.sirius.thinktank.data.localstorage;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hw.sirius.thinktank.R;
import com.hw.sirius.thinktank.data.model.MeetingEvent;
import com.hw.sirius.thinktank.application.ThinkTankApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.hw.sirius.thinktank.account.login.LoginPresenterImp.TAG;

public class MeetingLocalStorageImp implements MeetingLocalStorage {

    public static final String FILENAME = "meetingEventList";
    private static final int YUNA_NIAN = 1900;

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
        Date fromDate = new Date();
        return prepareWeekViewEvents(YUNA_NIAN + fromDate.getYear(), fromDate.getMonth(), fromDate.getDate());
    }

    @NonNull
    private List<MeetingEvent> getFromCache() {
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


    @NonNull
    private List<MeetingEvent> prepareWeekViewEvents(int newYear, int newMonth, int date) {
        Log.d(TAG, "prepareWeekViewEvents");
        List<MeetingEvent> eventList = new ArrayList<>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth);
        startTime.set(Calendar.YEAR, newYear);
        startTime.set(Calendar.DAY_OF_MONTH, date);
        Calendar end = (Calendar) startTime.clone();
        end.set(Calendar.HOUR_OF_DAY, 12);
        end.set(Calendar.MINUTE, 30);
        end.set(Calendar.MONTH, newMonth);
        MeetingEvent weekViewEvent = new MeetingEvent(31, "meeting", startTime, end);
        weekViewEvent.setColor(R.color.event_color_04);
        eventList.add(weekViewEvent);


        Log.d(TAG, "todayEvent: " + weekViewEvent.getStartTime());

        Log.d(TAG, "day: " + date + "month: " + newMonth);

        Random random = new Random();
        int hourSeed = 99;
        for (int i = 0; i < 30; i++) {

            int daySeed = Math.abs(new Random(i).nextInt(hourSeed + i));
            hourSeed = Math.abs(new Random(daySeed).nextInt(i + daySeed));

            int day = daySeed % 29;
            int hour = hourSeed % 8 + 8;

            Log.d(TAG, "day: " + day + "hour: " + hour);

            startTime = Calendar.getInstance();
            startTime.set(Calendar.DAY_OF_MONTH, i);
            startTime.set(Calendar.HOUR_OF_DAY, hour);
            startTime.set(Calendar.MINUTE, day);
            startTime.set(Calendar.MONTH, newMonth);
            startTime.set(Calendar.YEAR, newYear);
            Calendar endTime = (Calendar) startTime.clone();
            int length = Math.abs(new Random(i).nextInt(hourSeed + i)) % 6;
            endTime.set(Calendar.HOUR_OF_DAY, hour + length);
            MeetingEvent event = new MeetingEvent(i, "SESSION", startTime, endTime);
            int event_color_01 = day % 2 == 0 ? R.color.event_color_01 : R.color.event_color_03;
            event.setColor(event_color_01);
            eventList.add(event);
        }

        return eventList;
    }
}
