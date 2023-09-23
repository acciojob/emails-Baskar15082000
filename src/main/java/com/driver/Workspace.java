package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId);
        this.calendar=new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        Collections.sort(calendar, (m1, m2) -> m1.getStartTime().compareTo(m2.getStartTime()));

        int maxMeetings = 0;
        LocalTime endTime = LocalTime.MIN;

        for (Meeting meeting : calendar) {
            if (meeting.getStartTime().compareTo(endTime) >= 0) {
                maxMeetings++;
                endTime = meeting.getEndTime();
            }
        }

        return maxMeetings;


    }
}
